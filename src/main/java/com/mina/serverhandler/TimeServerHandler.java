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
		String sss = "问题： 1.副本统计里，调整为1列是未通关的，1列是非一次性通关的 2.在线查询--活跃统计里增加一列：平均登陆次数（活跃次数/活跃人数） 3.注册统计里的活跃统计咋跟在线查询的活跃统计不一样，查一下，顺便确定在线查询--活跃统计的数据是正确的，并把注册统计--活跃统计删掉 问题： 1.副本统计里，调整为1列是未通关的，1列是非一次性通关的 2.在线查询--活跃统计里增加一列：平均登陆次数（活跃次数/活跃人数） 3.注册统计里的活跃统计咋跟在线查询的活跃统计不一样，查一下，顺便确定在线查询--活跃统计的数据是正确的，并把注册统计--活跃统计删掉 问题： 1.副本统计里，调整为1列是未通关的，1列是非一次性通关的 2.在线查询--活跃统计里增加一列：平均登陆次数（活跃次数/活跃人数） 3.注册统计里的活跃统计咋跟在线查询的活跃统计不一样，查一下，顺便确定在线查询--活跃统计的数据是正确的，并把注册统计--活跃统计删掉 问题： 1.副本统计里，调整为1列是未通关的，1列是非一次性通关的 2.在线查询--活跃统计里增加一列：平均登陆次数（活跃次数/活跃人数） 3.注册统计里的活跃统计咋跟在线查询的活跃统计不一样，查一下，顺便确定在线查询--活跃统计的数据是正确的，并把注册统计--活跃统计删掉 问题： 1.副本统计里，调整为1列是未通关的，1列是非一次性通关的 2.在线查询--活跃统计里增加一列：平均登陆次数（活跃次数/活跃人数） 3.注册统计里的活跃统计咋跟在线查询的活跃统计不一样，查一下，顺便确定在线查询--活跃统计的数据是正确的，并把注册统计--活跃统计删掉 问题： 1.副本统计里，调整为1列是未通关的，1列是非一次性通关的 2.在线查询--活跃统计里增加一列：平均登陆次数（活跃次数/活跃人数） 3.注册统计里的活跃统计咋跟在线查询的活跃统计不一样，查一下，顺便确定在线查询--活跃统计的数据是正确的，并把注册统计--活跃统计删掉";
		session.write(sss);
	}
	
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		String msg = message.toString().trim();
		logger.info(msg);
//		session.write("sent time:"+new Date().toString());
	}
}
