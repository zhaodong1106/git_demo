package com.imooc.usermgr.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class test2 {
	private static List<Object[]> list=new ArrayList<Object[]>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			list.add(new Object[]{1,2,3});
			list.add(new Object[]{4,5,6});
			for(Object[] object:list){
				System.out.println(object[1]);
			}
			for(Iterator<Object[]> iter=list.iterator();iter.hasNext();){
				Object[] object=(Object[])iter.next();
				System.out.println(object[0]);
			}
			Iterator<Object[]> iter=list.iterator();
			while(iter.hasNext()){
				Object[] object=(Object[])iter.next();
				System.out.println(object[0]);
			}
			System.out.println("adaddadd");
		
	}

}
