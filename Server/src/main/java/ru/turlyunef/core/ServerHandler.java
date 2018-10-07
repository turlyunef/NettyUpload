package ru.turlyunef.core;

import java.io.FileOutputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Handles a server-side channel.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
	private static Logger logger = LoggerFactory.getLogger(ServerHandler.class);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws IOException {
		ByteBuf buf = (ByteBuf) msg;
		String fileName = "D:/file.mp3";
		saveToFile(buf, fileName);

	}

	public void saveToFile(ByteBuf buf, String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName, true);
		for (int i = 0; i < buf.capacity(); i++) { // Поискать замены этому алгоритму в либе Netty
			byte b = buf.getByte(i);
			fos.write(b);
		}
		fos.close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {

		// Close the connection when an exception is raised.
		cause.printStackTrace();
		ctx.close();
		logger.error("ChannelHandlerContext and the connection closed because an exception is raised");
	}
}
