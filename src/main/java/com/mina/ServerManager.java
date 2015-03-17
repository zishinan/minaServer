package com.mina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.dao.DirDao;
import com.dao.ProductDao;
import com.dao.SmalldirDao;
import com.dao.UserDao;
import com.dao.impl.DirDaoImpl;
import com.dao.impl.ProductDaoImpl;
import com.dao.impl.SmalldirDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.entity.Dir;
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
			result = getBuyData(data.getMsg());
			break;
		case ActValue.SHOW_BUY:
			result = getShowBuyData(data.getMsg());
			break;
		case ActValue.CHANGE_PWD:
			result = getChagePwdData(data.getMsg());
			break;
		default:
			break;
		}
		return result;
	}

	//user;product;
	private static String getBuyData(String msg) {
		
		return null;
	}

	private static String getShowBuyData(String msg) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String getChagePwdData(String msg) {
		// TODO Auto-generated method stub
		return null;
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
		maps.put("dir", dirs);
		maps.put("smalldirs", smalldirs);
		
		String msg = JSON.toJSONString(maps);
		Data data = new Data(ActValue.LOGIN, msg);
		return JSON.toJSONString(data);
	}
	
	public static void main(String[] args) {
		System.out.println(getLoginData());
	}
}
