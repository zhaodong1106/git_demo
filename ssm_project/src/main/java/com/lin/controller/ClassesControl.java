package com.lin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.domain.Classes;
import com.lin.service.ClassesService;
@Controller
public class ClassesControl {
	@Autowired
	private ClassesService classesService;
	
	@RequestMapping("/showClassAll")
	public String showClassAll(Map<String,Object> map,@RequestParam(value="page",required=false,defaultValue="1") Integer page,@RequestParam(value="pageSize",required=false,defaultValue="4") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Classes> list=classesService.selectClasses();
		PageInfo<Classes> pageList=new PageInfo<Classes>(list);
		map.put("pageList", pageList);
		return "showClassesAll";
	}
	@RequestMapping("/classesShowUser")
	public String classesShowUser(Map<String,Object> map){

		return "classesShowUser";
	}
}
