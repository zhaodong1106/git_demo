package com.imooc.usermgr.entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Classes classes=new Classes("zhao");
		System.out.println(classes.toString());
		String a="abcde";
		System.out.println(a.length());
		String[] string=new String[a.length()];
		for(int i=0;i<a.length();i++){
			string[i]=String.valueOf(a.charAt(i));
		}
		for(String string1:string){
			System.out.println(string1);
		}
		int i=222222;
		String b=String.valueOf(i);
		int c=Integer.parseInt(b);
		System.out.println(b);
		System.out.println(c);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sdf.format(new Date());
		System.out.println(date);
		@SuppressWarnings("unused")
		Date date1=null;
		try {
			 date1=sdf.parse("2014-03-22 16:23:24");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String date3=sdf.format(sdf.parse("2014-03-22 16:23:24"));
		System.out.println(date3);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("1", "zhao");
		map.put("3", "dong");
		map.put("4", classes);
		for(String string1:map.keySet()){
			System.out.println(string1);
		}
		for(Object object:map.values()){
			System.out.println(object);
		}
		for(Entry<String,Object> entry:map.entrySet()){
			System.out.println(entry);
		}
		System.out.println(map.size());
		@SuppressWarnings("rawtypes")
		Set set1=new HashSet();
		set1.add(classes);
		set1.add("adsdad");
		for(Object object1:set1){
			System.out.println(object1);
		}
		System.out.println(set1.size());
		int[] arr = new int[10];
		for(int arr1:arr){
		System.out.println(arr1);}
		int x=10;
		
		for(int j=0;j<10;j++){
			x+=10;
		}
		
		System.out.println(x);
		
		int ac=33333333;
		String bd=String.valueOf(ac);
		System.out.println(bd);
		
		test1("1111");
		test1();
//		try {
//			copy();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			write1();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			copy2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String str="1,2,3,4,3,2,1,";
//		String[] str2={"1","3","3","123"};
		String[] str2=new String[10];
		
 		String[]  str1=str.split(",");
		int[] int1=new int[str.length()];
		for(int h=0;h<str1.length;h++){
				int1[h]=Integer.parseInt(str1[h]);
				System.out.println(int1[h]);
		}	
		
		System.out.println(Arrays.toString(int1));
		System.out.println(Arrays.toString(str2));
	}
		
	private static void test1(){
		System.out.println("dasdasdd");
	}
	
	private static void test1(String a){
		System.out.println(a);
	}
	private static void copy() throws IOException{
		String content=null;
		try {
			InputStream is=new FileInputStream("D:\\test.txt");
			InputStreamReader isr=new InputStreamReader(is,"gbk");
			BufferedReader br=new BufferedReader(isr);
			OutputStream os=new FileOutputStream("D:\\test1.txt",true);
			OutputStreamWriter osr=new OutputStreamWriter(os,"gbk");
			BufferedWriter bw=new BufferedWriter(osr);
			
			
			while((content=br.readLine())!=null){
				bw.write(content);
				bw.newLine();
			}
			bw.close();
			osr.close();
			os.close();
			isr.close();
			is.close();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private static void write1() throws IOException{
		OutputStream os=new FileOutputStream("D:\\test.txt",true);
		OutputStreamWriter osr=new OutputStreamWriter(os,"gbk");
		BufferedWriter bw=new BufferedWriter(osr);
		String a="这种CAD123";
		bw.newLine();
		bw.write(a);
		
		bw.flush();
		bw.close();
		osr.close();
		os.close();
			
	}
	private static void read() throws IOException{
		InputStream is=new FileInputStream("D:\\test2.txt");
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		
		String content=null;
		while((content=br.readLine())!=null){
			System.out.println(content);
		}
	}
	public static void copy2() throws IOException{
		InputStream is=new FileInputStream("D:\\迅雷下载\\081816_364\\AA.jpg");
		byte[] body=new byte[is.available()];
		is.read(body);
		OutputStream os=new FileOutputStream("D:\\迅雷下载\\081816_364\\AAb.jpg");
		os.write(body);
		
	}

}
