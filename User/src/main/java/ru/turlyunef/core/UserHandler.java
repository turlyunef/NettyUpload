package ru.turlyunef.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class UserHandler extends ChannelInboundHandlerAdapter {
	private static Logger logger = LoggerFactory.getLogger(UserHandler.class);
	@Override
	public void channelActive(final ChannelHandlerContext ctx) throws IOException { 
		
		
		
		
		File file = new File ("D:/Downloads/Blockhead - The Music Scene (2009)_onetwo.tv/01 - Blockhead - It's Raining Clouds.mp3");
	    byte [] bytearray  = new byte [(int)file.length()];
	    
	    logger.debug("----------------------------Client started to transfer the file with size = " + (int)file.length() + "bytes ( "
	    			+ (float) ((int) file.length() /Math.pow(1024, 2)) + " MB)");
		
	    FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		bis.read(bytearray, 0, bytearray.length);
		
		
	    
		final ByteBuf buf = ctx.alloc().buffer(bytearray.length);
		buf.writeBytes(bytearray);
		logger.debug("----------------------------size of buffer buf is " + buf.capacity() + "bytes ( "
    			+ (float) (buf.capacity() /Math.pow(1024, 2)) + " MB)");
	
		
		logger.debug("----------------------------Client wrote the file to buffer ByteBuf buf ");      
		        
		    

		final ChannelFuture f = ctx.writeAndFlush(buf);
		f.addListener(new ChannelFutureListener() {
			public void operationComplete(ChannelFuture future) {
				assert f == future;
				ctx.close();
				logger.debug("----------------------------Client completed to transfer the file and closed ChannelHandlerContext ctx");
			}
		});
		//bis.close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

}
