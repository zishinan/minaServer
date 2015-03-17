package com.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.mina.serverhandler.ServerHandler;

public class MinaServer {
	private static Logger logger = Logger.getLogger(MinaServer.class);
	private static final int PORT = 8888;
	public static void main(String[] args) throws IOException {
		IoAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "gbk" ))));
		acceptor.setHandler(new ServerHandler());
		acceptor.setDefaultLocalAddress(new InetSocketAddress(PORT));
		acceptor.bind();
	}
}
