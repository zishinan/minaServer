package com.mina;

import java.io.IOException;
import java.io.WriteAbortedException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.alibaba.fastjson.JSON;
import com.mina.serverhandler.TimeServerHandler;

public class MinaServer {
	private static Logger logger = Logger.getLogger(MinaServer.class);
	private static final int PORT = 8888;
	public static void main(String[] args) throws IOException {
//		Data data = new Data();
//		data.setAct("login");
//		data.setMsg("user:yangxi;password:yangxiouyang");
//		String msgs = JSON.toJSONString(data);
//		logger.info(msgs);
		
//		Map<String, String> map = (Map<String, String>) JSON.parse(msgs);
//		System.out.println(map.get("act"));
//		System.out.println(map.get("msg"));
		
		
		IoAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "gbk" ))));
		acceptor.setHandler(new TimeServerHandler());
		acceptor.setDefaultLocalAddress(new InetSocketAddress(PORT));
		acceptor.bind();
	}
}
