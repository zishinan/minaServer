package com.mina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.dao.DirDao;
import com.dao.OrderformDao;
import com.dao.ProductDao;
import com.dao.SmalldirDao;
import com.dao.UserDao;
import com.dao.impl.DirDaoImpl;
import com.dao.impl.OrderformDaoImpl;
import com.dao.impl.ProductDaoImpl;
import com.dao.impl.SmalldirDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.entity.Dir;
import com.entity.Orderform;
import com.entity.Product;
import com.entity.Smalldir;
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
		case ActValue.BUY:
			result = buyData(data.getMsg());
			break;
		case ActValue.SHOW_BUY:
			result = showBuyData(data.getMsg());
			break;
		case ActValue.CHANGE_PWD:
			result = chagePwdData(data.getMsg());
			break;
		default:
			break;
		}
		return result;
	}

	private static String buyData(String msg) {
		String result = "error";
		Orderform orderform = JSON.parseObject(msg,Orderform.class);
		OrderformDao dao = new OrderformDaoImpl();
		boolean flag = dao.add(orderform);
		if(flag){
			result = "success";
		}
		
		return result;
	}

	private static String showBuyData(String msg) {
		
		return null;
	}

	private static String chagePwdData(String msg) {
		User user = JSON.parseObject(msg, User.class);
		UserDao dao = new UserDaoImpl();
		boolean flag = dao.update(user);
		String result = "error";
		if(flag){
			result = "success";
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
		}else {
			result = "没有该用户信息!";
		}
		return result;
	}

	private static String getLoginData() {
		ProductDao productDao = new ProductDaoImpl();
		List<Product> products = productDao.listQuery(null, null, null, null);
		DirDao dirDao = new DirDaoImpl();
		List<Dir> dirs = dirDao.listQuery(null, null, null, null);
		SmalldirDao smalldirDao = new SmalldirDaoImpl();
		List<Smalldir> smalldirs = smalldirDao.listQuery(null, null, null, null);
		Map<String, Object> maps = new HashMap<>();
		maps.put("products", products);
		maps.put("dirs", dirs);
		maps.put("smalldirs", smalldirs);
		
		String msg = JSON.toJSONString(maps);
		Data data = new Data(ActValue.LOGIN, msg);
		return JSON.toJSONString(data);
	}
	
	public static void main(String[] args) {
		String result = getLoginData().trim();
		System.out.println(result);
		Data data = JSON.parseObject(result, Data.class);
		System.out.println(data.getAct());
		System.out.println(data.getMsg());
	}
}
