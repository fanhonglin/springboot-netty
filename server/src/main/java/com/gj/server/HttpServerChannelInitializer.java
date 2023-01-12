/**
 * Welcome to https://waylau.com
 */
package com.gj.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import org.springframework.stereotype.Component;

/**
 * HTTP Server ChannelInitializer.
 * 
 * @since 1.0.0 2019年12月26日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Component
public class HttpServerChannelInitializer extends ChannelInitializer<SocketChannel> {

	public HttpServerChannelInitializer() {
		
	}
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast("codec", new HttpServerCodec());
		ch.pipeline().addLast("aggregator", new HttpObjectAggregator(1048576));
		ch.pipeline().addLast("serverHandler", new HttpServerHandler());
	}

}
