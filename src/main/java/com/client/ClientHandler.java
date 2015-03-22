package com.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSON;
import com.entity.Dir;
import com.entity.Product;
import com.entity.Smalldir;
import com.mina.ActValue;
import com.mina.Data;

public class ClientHandler extends IoHandlerAdapter {
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String dataResult = message.toString().trim();
		System.out.println(dataResult);
		Data data = JSON.parseObject(dataResult,Data.class);
		String msg = data.getMsg();
		if(ActValue.LOGIN.equals(data.getAct())){
			Map<String, Object> maps = (Map<String,Object>) JSON.parse(msg);
//			String productsString = maps.get("products");
//			String dirsString = maps.get("dirs");
//			String smalldirsString = maps.get("smalldirs");
			List<Product> products = new ArrayList<Product>();
			List<Dir> dirs = new ArrayList<Dir>();
			List<Smalldir> smalldirs = new ArrayList<Smalldir>();
			
			List productsObj = (List) maps.get("products");
			List dirsObj = (List) maps.get("dirs");
			List smalldirsObj = (List) maps.get("smalldirs");
//			List productsObj = JSON.parseObject(productsString, List.class);
//			List dirsObj = JSON.parseObject(dirsString, List.class);
//			List smalldirsObj = JSON.parseObject(smalldirsString, List.class);
			for (Object object : smalldirsObj) {
				smalldirs.add(JSON.parseObject(object.toString(), Smalldir.class));
			}
			for (Object object : dirsObj) {
				dirs.add(JSON.parseObject(object.toString(), Dir.class));
			}
			for (Object object : productsObj) {
				products.add(JSON.parseObject(object.toString(), Product.class));
			}
			ResultData.setDirs(dirs);
			ResultData.setSmalldirs(smalldirs);
			ResultData.setProducts(products);
			System.err.println(dirs.size());
		}
		if(ActValue.SIGIN.equals(data.getAct())){
			
		}
		if(ActValue.BUY.equals(data.getAct())){
			
		}
		if(ActValue.SHOW_BUY.equals(data.getAct())){
			
		}
		if(ActValue.CHANGE_PWD.equals(data.getAct())){
			
			
		}
		session.setAttribute(Client.RESULT, Client.SUCCESS);
		session.close();
	}
}
