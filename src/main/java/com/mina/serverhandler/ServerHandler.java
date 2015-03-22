package com.mina.serverhandler;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.mina.ServerManager;

public class ServerHandler extends IoHandlerAdapter {
	private static Logger logger = Logger.getLogger(ServerHandler.class);
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		logger.info(session.getRemoteAddress().toString());
		super.sessionCreated(session);
	}
	
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		logger.info("server received:"+message.toString());
		String result = ServerManager.getServerResult(message.toString().trim());
		
		session.write(result);
		logger.info("result is :"+ result);
		super.messageReceived(session, message);
	}
	
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		super.messageSent(session, message);
//		String msg = message.toString().trim();
//		logger.info(msg);
//		session.write("sent time:"+new Date().toString());
	}
}
