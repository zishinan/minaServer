package com.client;

import java.util.List;

import com.entity.Dir;
import com.entity.Orderform;
import com.entity.Product;
import com.entity.Smalldir;
import com.entity.User;

public class ResultData {
	public static List<Dir> mainDirs;
	public static List<Dir> dirs;
	public static List<Smalldir> smalldirs;
	public static List<Product> products;
	public static List<Orderform> orderforms;
	public static User user;
	public static List<Dir> getMainDirs() {
		return mainDirs;
	}
	public static void setMainDirs(List<Dir> mainDirs) {
		ResultData.mainDirs = mainDirs;
	}
	public static List<Dir> getDirs() {
		return dirs;
	}
	public static void setDirs(List<Dir> dirs) {
		ResultData.dirs = dirs;
	}
	public static List<Smalldir> getSmalldirs() {
		return smalldirs;
	}
	public static void setSmalldirs(List<Smalldir> smalldirs) {
		ResultData.smalldirs = smalldirs;
	}
	public static List<Product> getProducts() {
		return products;
	}
	public static void setProducts(List<Product> products) {
		ResultData.products = products;
	}
	public static List<Orderform> getOrderforms() {
		return orderforms;
	}
	public static void setOrderforms(List<Orderform> orderforms) {
		ResultData.orderforms = orderforms;
	}
	public static User getUser() {
		return user;
	}
	public static void setUser(User user) {
		ResultData.user = user;
	}
	
}
