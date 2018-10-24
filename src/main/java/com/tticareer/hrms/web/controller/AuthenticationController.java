package com.tticareer.hrms.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tticareer.hrms.pojo.Employee;
import com.tticareer.hrms.pojo.dto.AuthenticationApproveDto;
import com.tticareer.hrms.pojo.dto.AuthenticationDto;
import com.tticareer.hrms.service.EmployeeService;
import com.tticareer.hrms.util.BeanUtils;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

	@Autowired
	EmployeeService employeeService;
	
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	public @ResponseBody ExtAjaxResponse login(@Param("userName") String userName, @Param("password") String password,HttpSession session) {
		Employee e=employeeService.queryEmployeeByUserName(userName);	
		if(e==null) {
			return new ExtAjaxResponse(false,"登录账号不存在！");
		}else if (userName.equals("admin")&&password.equals("123456")) {
			SessionUtil.setEmployee(session, e);			
			Map<String,String> map=new HashMap<String,String>();
	        map.put("userName", userName);
	        map.put("msg", "超级管理员登录成功!");
	        //map.put("loginUserImage", "imgUrl");
	        return new ExtAjaxResponse(true,map);
		}else if(e.getCheckSatus()!=3) {
			return new ExtAjaxResponse(false,"非人事部人员不能登录！");
			}else if (e.getPassword().equals(password)) {
						SessionUtil.setEmployee(session, e);
						Map<String,String> map=new HashMap<String,String>();
				        map.put("userName", userName);
				        map.put("msg", "登录成功!");
				        //map.put("loginUserImage", "imgUrl");
				        return new ExtAjaxResponse(true,map);						
					} else {
						return new ExtAjaxResponse(false,"密码错误！");
					}
	}	

	
	
	
	
	/**
     * 退出登录
     */
    @PostMapping(value = "/logout")
    public ExtAjaxResponse logout(HttpSession session) 
    {
    	try {
    		SessionUtil.removeAttribute(session);
        	return new ExtAjaxResponse(true,"登出成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"登出失败!");
		}
    }
       
   
    
    
    /**
     * 注册
     */
    //@RequestBody  json
    //Content-Type: application/x-www-form-urlencoded; charset=UTF-8
    
    
    @PostMapping(value = "/register")
    public  ExtAjaxResponse register(AuthenticationDto authenticationDto) {
    	Employee e=employeeService.queryEmployeeByUserName(authenticationDto.getUserName());
    	if(e==null||e.getCheckSatus()==0||e.getState()==0) {
    		return new ExtAjaxResponse(false,"非公司员工不能注册！");
    	}else if(e.getCheckSatus()==3) {
    		return new ExtAjaxResponse(false,"已经是人事部人员，不能重复注册！");
    	}else{
    		BeanUtils.copyProperties(authenticationDto, e);
    		employeeService.updateEmployee(e);
    		return new ExtAjaxResponse(true,"注册成功，请进行实名认证！");
    	}
    }
    
   
       
    
    /**
     * 实名认证
     */
    @PostMapping(value = "/realname")
    public  ExtAjaxResponse realName( AuthenticationDto authenticationDto) {
    	System.out.println(authenticationDto.getIdCardNumber());
    	System.out.println(authenticationDto.getIdCardPicture());
    	System.out.println(authenticationDto.getRealName());
    	Employee e=employeeService.queryEmployeeByUserName(authenticationDto.getUserName());  	
    	if(e==null) {
    		return new ExtAjaxResponse(false,"非公司员工不能实名认证！");
    	}else {
    		BeanUtils.copyProperties(authenticationDto, e);
    		e.setCheckSatus(2);
    		employeeService.updateEmployee(e);
    		return new ExtAjaxResponse(true,"实名认证信息填写成功，等待审核！");
    	}
    }
 
    
    
    /**
     * 修改个人信息
     */
    @PostMapping(value = "/modifyinformation")
    public  ExtAjaxResponse modifyInformation(AuthenticationDto authenticationDto,HttpSession session) {   	
    	if(SessionUtil.getUserName(session)==null) {
    		return new ExtAjaxResponse(false,"非本人操作，不能修改个人信息！");
    	}else {
    		Employee e=employeeService.queryEmployeeByUserName(SessionUtil.getUserName(session));
    		BeanUtils.copyProperties(authenticationDto, e);
    		e.setCheckSatus(2);
    		employeeService.updateEmployee(e);
    		SessionUtil.removeAttribute(session);
    		return new ExtAjaxResponse(true,"修改个人信息成功，等待审核！");
    	}
    }
    
    
    
    /**
     * 修改个人密码
     */
    @PostMapping(value = "/modifypassword")
    public  ExtAjaxResponse modifyPassword(AuthenticationDto authenticationDto, @Param("newPassword") String newPassword,HttpSession session) {
    	if(SessionUtil.getUserName(session)==null) {
    		return new ExtAjaxResponse(false,"非本人操作，不能修改密码！");
    	}else {
    		Employee e=employeeService.queryEmployeeByUserName(SessionUtil.getUserName(session));
    		System.out.println(e.getPassword()); 
    		System.out.println(authenticationDto.getNewPassword()); 
    		if(!e.getPassword().equals(authenticationDto.getPassword())) {    			
    			return new ExtAjaxResponse(false,"原始密码不正确！");
    		}else {
    			e.setPassword(authenticationDto.getNewPassword());
	    		employeeService.updateEmployee(e);
	    		SessionUtil.removeAttribute(session);
	    		return new ExtAjaxResponse(true,"修改密码成功！");
    		}
    	}
    }
    
     
    
    
    /**
     * 能否审核
     */
    @PostMapping(value = "/clickapprove")
    public  ExtAjaxResponse clickapprove(HttpSession session) {
    	if(SessionUtil.getUserName(session)==null) {
    		return new ExtAjaxResponse(false,"非本人操作，不能审核！");
    	}else if(!SessionUtil.getState(session).equals("3")) {
    		return new ExtAjaxResponse(false,"没有权限审核！");
    	}else {
    		 return new ExtAjaxResponse(true,"可以审核！");
    	}   	
    }
   
    
    /**
     * 审核提交
     */
    @PostMapping(value = "/approve")
    public  ExtAjaxResponse approve(AuthenticationApproveDto authenticationApproveDto,HttpSession session) {
    	if(SessionUtil.getUserName(session)==null) {
    		return new ExtAjaxResponse(false,"非本人操作，不能审核！");
    	}else if(!SessionUtil.getState(session).equals("3")) {
    		return new ExtAjaxResponse(false,"没有权限审核！");
    	}else if(authenticationApproveDto.isPass()){
    		System.out.println(authenticationApproveDto.getUserName());
    		Employee e=employeeService.queryEmployeeByUserName(authenticationApproveDto.getUserName());
    		e.setCheckSatus(3);
    		employeeService.updateEmployee(e);
    		return new ExtAjaxResponse(true,"审核通过！");
    	}else {
    		return new ExtAjaxResponse(false,"审核不通过！");
    	}   	
    }
}
