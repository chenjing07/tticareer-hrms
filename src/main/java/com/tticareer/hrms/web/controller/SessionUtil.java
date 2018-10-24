package com.tticareer.hrms.web.controller;

import javax.servlet.http.HttpSession;

import com.tticareer.hrms.pojo.Employee;

public class SessionUtil {
	
	public static final String EMPLOYEE 	= "employee";
	public static final String USERNAME 	= "userName";
	public static final String STATE 		= "state";
	
	
    /**
     * 设置员工到session
     */
    public static void setEmployee(HttpSession session, Employee employee) {
        session.setAttribute(EMPLOYEE, employee);
        setUserName(session,employee.getUserName());
        setState(session,employee.getState());
    }

    /**
     * 从Session获取当前员工信息
     */
    public static Employee getEmployee(HttpSession session) {
        Object employee = session.getAttribute(EMPLOYEE);
        return employee == null ? null : (Employee) employee;
    }

    /**
     * 设置工号到session
     */
    public static void setUserName(HttpSession session, String userName) {
        session.setAttribute(USERNAME, userName);
    }

    /**
     * 从Session获取当前工号信息
     */
    public static String getUserName(HttpSession session) {
        Object userName = session.getAttribute(USERNAME);
        return userName == null ? null : (String) userName;
    }
    /**
     * 设置员工状态到session
     */
    public static void setState(HttpSession session, int state) {
        session.setAttribute(STATE, state);
    }

    /**
     * 从Session获取当前员工状态信息
     */
    public static String getState(HttpSession session) {
        Object state = session.getAttribute(STATE);
        return state == null ? null : (String) state;
    }

	
	public static void removeAttribute(HttpSession session) {
		session.removeAttribute(EMPLOYEE);
		session.removeAttribute(USERNAME);
        session.removeAttribute(STATE);
    }
    
}
