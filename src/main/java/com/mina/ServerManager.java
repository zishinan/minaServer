package com.mina;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.dao.ProductDao;
import com.dao.UserDao;
import com.dao.impl.ProductDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.entity.Product;
import com.entity.User;

public class ServerManager {
	public static String getServerResult(String msg) {
		String result = "";
		Data data = JSON.parseObject(msg, Data.class);
		switch (data.getAct()) {
		case ActValue.LOGIN:
			result = getLoginData();
			break;
		case ActValue.SIGIN:
			result = getSiginData(data.getMsg());
			break;
		default:
			break;
		}
		return result;
	}

	private static String getSiginData(String msg) {
		User user = JSON.parseObject(msg, User.class);
		UserDao dao = new UserDaoImpl();
		List<User> users = dao.listQuery(" schNum = ? and password = ?", new Object[]{user.getSchNum(),user.getPassword()}, null, null);
		String result = "";
		if(users.size() > 0){
			result = JSON.toJSONString(new Data(ActValue.SIGIN, JSON.toJSONString(users.get(0))));
		}
		return result;
	}

	private static String getLoginData() {
		ProductDao dao = new ProductDaoImpl();
		List<Product> products = dao.listQuery(null, null, 0, 10);
		
		String msg = JSON.toJSONString(products);
		Data data = new Data(ActValue.LOGIN, msg);
		return JSON.toJSONString(data);
	}
	
	public static void main(String[] args) {
		System.out.println(getLoginData());
	}
}
