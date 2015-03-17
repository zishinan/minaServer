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
	}
	
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String result = ServerManager.getServerResult(message.toString().trim());
		
		session.write(result);
	}
	
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		String msg = message.toString().trim();
		logger.info(msg);
//		session.write("sent time:"+new Date().toString());
	}
}
