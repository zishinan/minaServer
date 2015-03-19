package com.util;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class StringUtil
{
	private StringUtil() {
		throw new Error("不要实例化!");
	}
	/**
	 * 判断一个字符串是否为空
	 * @param s
	 * @return trim后length>0 and not equals "null" and not equals "undefined" 返回true
	 */
	public static boolean isNotBlank(String s)
	{
		if(s == null){
			return false;
		}
		String ss = s.trim();
		if("".equals(ss) || "null".equals(ss) || ss.length() == 0 || "undefined".equals(ss)){
			return false;
		}
		return true;
	}
	
	public static boolean isBlank(String s)
	{
		if(isNotBlank(s))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * 获取一个随机的小写字母
	 * @return
	 */
	public static char getRandomSmallChar()
	{
		return (char)(Math.random() * 26 + 'a');
	}
	
	/**
	 * 获取一个随机的大写字母
	 * @return
	 */
	public static char getRandomBigChar()
	{
		return (char)(Math.random() * 26 + 'A');
	}
	
	/**
	 * "~"缩略拼接","分隔的数字字符串
	 * @param ts
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String getSortArrString(String ts) {
		String[] tsArr = ts.split(",");
		if(tsArr.length < 3){
			return ts;
		}
		Map<Integer, Integer> numMap = new TreeMap<Integer, Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		for (int i = 0; i < tsArr.length; i++) {
			int num = Integer.parseInt(tsArr[i]);
			boolean flag = true;
			for (Integer key : numMap.keySet()) {
				if(key == num - 1 || numMap.get(key) == num - 1){
					numMap.put(key, num);
					flag = false;
				}
			}
			if(flag){
				numMap.put(num, num);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Integer key : numMap.keySet()) {
			int value = numMap.get(key);
			if(value - key == 1){
				sb.append(",").append(key).append(",").append(value);
				continue;
			}
			if(value == key){
				sb.append(",").append(key);
				continue;
			}
			sb.append(",").append(key).append("~").append(value);
		}
		return sb.toString().replaceFirst(",", "");
	}
}
