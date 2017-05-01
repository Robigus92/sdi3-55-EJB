package uo.sdi.business;

import uo.sdi.business.impl.admin.EjbAdminService;

public interface Services {

	public AdminService getAdminService();

	public UserService getUserService();

	public TaskService getTaskService();

}
