package com.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.alibaba.fastjson.JSON;
import com.mina.ActValue;
import com.mina.Data;


public class Client {
	public static final String RESULT = "RESULT";
	public static final String SUCCESS = "SUCCESS";
	private static final String IP = "127.0.0.1";
	public static String sendToServer(Data data){
		IoConnector ioConnector = new NioSocketConnector();
		ioConnector.getFilterChain().addLast("logger", new LoggingFilter());
		ioConnector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		ioConnector.setHandler(new ClientHandler());
		ConnectFuture future = ioConnector.connect(new InetSocketAddress(IP, 8888));
		future.awaitUninterruptibly();
		IoSession ioSession = future.getSession();
		String sendData = JSON.toJSONString(data);
		ioSession.write(sendData);
		ioSession.getCloseFuture().awaitUninterruptibly();
		String result = (String) ioSession.getAttribute(RESULT);
		ioConnector.dispose();
		return result;
	}
	
	public static void main(String[] args)
	{
		sendToServer(new Data(ActValue.LOGIN, ""));
	}
}
