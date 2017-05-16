package com.lin.service;


import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.lin.baseTest.SpringTestCase;
import com.lin.domain.Classes;
import com.lin.domain.User;

public class ClassesServiceTest extends SpringTestCase {
	@Autowired
	private ClassesService classesService;

	
	@Test
	public void testSelectClassFetchUser(){
		Classes classes=classesService.selectClassFetchUser("小学二年级");
		for(User user: classes.getList()){
			try {
				copy(user.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	@Test
	public void testselectClassesExceptOne(){
		List<Classes> list=classesService.selectClassesExceptOne(1);
		for(Classes classes:list){
			String classesString=classes.toString();
			try {
				copy(classesString);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void copy(String str) throws IOException{
		OutputStream os=new FileOutputStream("D:\\test3.txt",true);
		OutputStreamWriter osw=new OutputStreamWriter(os);
		BufferedWriter bw=new BufferedWriter(osw);
		bw.write(str);
		bw.newLine();
		bw.close();
		osw.close();
		os.close();
	}
	
}
