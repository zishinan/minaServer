package com.mina.serverhandler;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class TimeServerHandler extends IoHandlerAdapter {
	private static Logger logger = Logger.getLogger(TimeServerHandler.class);
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		logger.info(session.getRemoteAddress().toString());
	}
	
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String msg = message.toString().trim();
		logger.info(msg);
		session.write("received time:"+new Date().toString());
	}
	
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		String msg = message.toString().trim();
		logger.info(msg);
		session.write("sent time:"+new Date().toString());
	}
}
