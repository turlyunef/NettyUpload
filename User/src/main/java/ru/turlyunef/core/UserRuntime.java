package ru.turlyunef.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class UserRuntime {
	private static Logger logger = LoggerFactory.getLogger(UserRuntime.class);
	String host = "localhost";
	int port = 8080;

	public UserRuntime(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void run() throws InterruptedException {
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			Bootstrap b = new Bootstrap();
			b.group(workerGroup);
			b.channel(NioSocketChannel.class);
			b.option(ChannelOption.SO_KEEPALIVE, true);
			b.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new UserHandler());
				}
			});

			// Start the client.
			ChannelFuture f = b.connect(host, port).sync();
			logger.info("----------------------------Client is connected to Server");

			// Wait until the connection is closed.
			f.channel().closeFuture().sync();
			logger.info("----------------------------Client've closed the connect to Server");
		} finally {
			workerGroup.shutdownGracefully();
		}
	}
}
