package com.lin.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.domain.Classes;
import com.lin.domain.JsonObject;
import com.lin.domain.User;
import com.lin.service.ClassesService;
import com.lin.service.UserService;
import com.lin.vo.User1;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ClassesService classesService;
	@RequestMapping("/listAll")
	public String selectUserById(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map){
		User user=userService.selectUserById(id);
		map.put("user", user);
		return "list";
	}
	
	@RequestMapping(value="/showUserAll",method={RequestMethod.GET,RequestMethod.POST})
	public String selectUserAll(Map<String,Object> map,@RequestParam(value="page",required=false,defaultValue="1") Integer page,@RequestParam(value="pageSize",required=false,defaultValue="4") Integer pageSize){
		PageHelper.startPage(page, pageSize);
		List<User> list=userService.selectAllUserJoinClass();
		
		PageInfo<User> pageList=new PageInfo<User>(list);
		map.put("pageList", pageList);
		return "showUserAll";
	}
	@RequestMapping("/studentInsert")
	public String studentInsert(Map<String,Object> map){
		@SuppressWarnings("rawtypes")
		List list=classesService.selectClasses();
		map.put("classesList", list);
		return "studentInsert";
	}
	@RequestMapping(value="/insertOneStudent",method=RequestMethod.POST)
	public String  insertOneStudent(User user1){
		userService.insert(user1);
		return "redirect:/studentInsert";
	}
	@RequestMapping("/showUserAll/delete/{id}")
	public String deleteOneUser(@PathVariable("id") int id){
		userService.delete(id);
		return "redirect:/showUserAll";
	}
	@RequestMapping("showUserAll/update/{id}")
	public String updateOneUser(@PathVariable("id") int id,Map<String,Object> map){
		User user=userService.selectUserById(id);

		map.put("user",user);
		@SuppressWarnings("rawtypes")
		List list=classesService.selectClassesExceptOne(user.getClassesId());
		map.put("classesList", list);
		return "updateUser";
	}
	@RequestMapping("/updateUser")
	public String updateUser(User user){
		userService.update(user);
		return "redirect:/showUserAll";
	}
	@RequestMapping("/showUserAll/update")
	public String updateOneUser2(@RequestParam("userId") int id,Map<String,Object> map){
		User user=userService.selectUserById(id);
		Classes classes=classesService.selectClassesById(user.getClassesId());
		map.put("oneClasses", classes);
		map.put("user",user);
		@SuppressWarnings("rawtypes")
		List list=classesService.selectClassesExceptOne(user.getClassesId());
		map.put("classesList", list);
		return "updateUser";
	}
	@RequestMapping("/showUserAll/delete")
	public String deleteOneUser2(@RequestParam("userId")  int id){
		userService.delete(id);
		return "redirect:/showUserAll";
		
	}
	@RequestMapping("/deleteUserBatch")
	public String deleteUserBatch(@RequestParam("userId") String userId){
		System.out.println(userId);
		String[] str=userId.split(",");
		for(String string:str){
		System.out.println(string);}
		int[] array=new int[str.length];
		for(int i=0;i<array.length;i++){
			array[i]=Integer.parseInt(str[i]);
		}
		for(int int1:array){
			System.out.println(int1);}
		userService.deleteBatch(array);
		return "redirect:/showUserAll";
	}
	@RequestMapping("/testJson")
	@ResponseBody
	public List<User> testJson(){
		List<User> list=userService.selectAllUserJoinClass();
		
		return list;
	}
	@RequestMapping("/testJson2")
	@ResponseBody
	public User testJson2(@RequestParam("userId")  int id){
		return userService.selectUserById(id);
	}
	
	@RequestMapping("/jsonReturnUser")
	@ResponseBody
	public List<User1> jsonReturnUser(@RequestParam("userId")  int id){
		return userService.selectUserByClassid(id);
	}
	@RequestMapping("/testUpload")
	public String testUpload(HttpServletRequest request,@RequestParam("file") MultipartFile file,@RequestParam("desc") String desc){
		System.out.println("filename:"+file.getOriginalFilename());
		System.out.println("descname:"+desc);
		String path=request.getSession().getServletContext().getRealPath("files");
		
		File targetFile=new File(path,desc);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		try{
			file.transferTo(targetFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "uploadSuccess";
	}
	@RequestMapping("/testDownload")
	public ResponseEntity<byte[]> testDownload(HttpServletRequest request) throws IOException{
		byte[] body=null;
		InputStream in=request.getSession().getServletContext().getResourceAsStream("files/oracleµÄ»ÆÍ¼.jpg");
		body=new byte[in.available()];
		in.read(body);
		HttpHeaders headers=new HttpHeaders();
// 		URLEncoder.encode解析汉字格式
		headers.add("Content-Disposition", "attachment;filename=oracle"+URLEncoder.encode("µÄ»ÆÍ¼","UTF-8")+".jpg");

		HttpStatus statusCode=HttpStatus.OK;
		ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}
	@RequestMapping("/checkNameValidate")
	@ResponseBody
	public JsonObject checkNameValidate(@RequestParam("userName") String name,HttpServletResponse response) throws IOException{
		
		int count=userService.selectUserByName(name);
		response.setContentType("text/xml;charset=utf-8");     
        response.setHeader("Cache-Control","no-cache");
        JsonObject obj=new JsonObject();
        
		if(count==0){
			  obj.setValid(true);
			  return obj;
			
		}else{
//			out.print("true");	
			obj.setValid(false);
			return obj;
		}
	}
	@RequestMapping("/checkEmailValidate")
	@ResponseBody
	public String checkEmailValidate(@RequestParam("userEmail") String email){
		int count=userService.selectUserByEmail(email);
		if(count==0){
			return "true";
		}else{
			return "false";
		}
	}
	@RequestMapping("/checkPassword")
	@ResponseBody
	public String checkPassword(@RequestParam("userName") String name,@RequestParam("userPassword") String password){
		int count=userService.selectUserByName(name);
		if (count==0){
			return "false";
		}else{
			User user=userService.checkPasswordByName(name);
			if(user.getUserPassword().equals(password)){
				return "true";
			}else{
				return "false";
			}
		}
	}
	@RequestMapping("/testValidate")
	public String testValidate(User user,HttpSession session,Map<String,Object> map,ModelMap model){
		System.out.println(user.getUserName());
		session.setAttribute("userName", user.getUserName());
		map.put("test", "this is a only test!!");
		model.addAttribute("haha", "hahahahahahahahahah");
		
		userService.insert(user);
		return "hello";
	}
	
		
	
	@RequestMapping("/logout.action")
	public String testLogout(HttpServletRequest request){
		request.getSession().invalidate();
		return "index";
	}
	
}
