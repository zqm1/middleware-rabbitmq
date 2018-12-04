package com.pc.test.util.jsonpath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class TestWork {
	 private static String readtxt() {
	        StringBuilder sb = new StringBuilder();
	        try {
	            FileReader fr = new FileReader("E:/work_soft/ariba.txt");
	            BufferedReader bfd = new BufferedReader(fr);
	            String s = "";
	            while((s=bfd.readLine())!=null) {
	                sb.append(s);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return sb.toString();
	    }
	public static void main(String[] args) {
        String sjson = readtxt();
       // LinkedHashMap<String,String> authors1 = JsonPath.read(sjson, "$.header.name");
        String test=JsonPath.read(sjson, "$.header.name");
        System.out.println(test);
	}
}
