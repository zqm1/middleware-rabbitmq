package com.pc.test.util;

import com.alibaba.fastjson.JSONObject;

import jdk.nashorn.internal.parser.JSONParser;

public class StringToJson {
	public static void main(String[] args) {

		String msg = "{test:'hello world!'}";
		JSONObject jsonObject = new JSONObject();
		JSONObject sendmsg=(JSONObject) jsonObject.parse(msg);
		System.out.println(sendmsg);
	}
}