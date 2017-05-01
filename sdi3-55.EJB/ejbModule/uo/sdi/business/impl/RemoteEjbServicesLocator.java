package uo.sdi.business.impl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import uo.sdi.business.AdminService;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.UserService;

public class RemoteEjbServicesLocator implements Services{
	
	private static final String ADMIN_SERVICE_JNDI_KEY = 
			"sdi3-55/" + "sdi3-55.EJB/" + "EjbAdminService!"
			+ "uo.sdi.business.impl.admin.RemoteAdminService";
	
	private static final String TASK_SERVICE_JNDI_KEY = 
			"sdi3-55/" + "sdi3-55.EJB/" + "EjbTaskService!"
			+ "uo.sdi.business.impl.task.RemoteTaskService";
	
	private static final String USER_SERVICE_JNDI_KEY = 
			"sdi3-55/" + "sdi3-55.EJB/" + "EjbUserService!"
			+ "uo.sdi.business.impl.user.RemoteUserService";
	
	@Override
	public AdminService getAdminService() {
		Context ctx;
		try {
			ctx = new InitialContext();
			return (AdminService) ctx.lookup(ADMIN_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("Problema con JNDI", e);
		}
		
	}
	
	@Override
	public TaskService getTaskService() {
		Context ctx;
		try {
			ctx = new InitialContext();
			return (TaskService) ctx.lookup(TASK_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("Problema con JNDI", e);
		}
		
	}
	
	@Override
	public UserService getUserService() {
		Context ctx;
		try {
			ctx = new InitialContext();
			return (UserService) ctx.lookup(USER_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("Problema con JNDI", e);
		}
		
	}

}
