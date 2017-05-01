package uo.sdi.business.impl.admin.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import alb.util.date.DateUtil;
import alb.util.log.Log;
import uo.sdi.business.AdminService;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;
import uo.sdi.persistence.Persistence;
import uo.sdi.persistence.UserDao;

public class ResetDBCommand {

	public Void execute() throws BusinessException {
/*
		Log.info("Attention. It is necessary that into the DB there is at least one admin with id '1'");
		// Declaring usefull variables.
		TaskService ta_serv;
		AdminService ad_serv;
		UserDao us_dao;
		List<User> tmp_usr_list = new ArrayList<User>();
		List<Task> tmp_task_list = new ArrayList<Task>();
		List<Category> tmp_category_list = new ArrayList<Category>();
		User user;
		Category category;
		Task task;
		long id_admin = 1;

		// initializing the services required.
		ta_serv = Services.getTaskService();
		ad_serv = Services.getAdminService();

		// initializing the DAOs required
		us_dao = Persistence.getUserDao();

		// checking if an admin account exist
		user = ad_serv.findUserById(id_admin);
		if (user == null) {
			Log.error("Does not exist an admin user with id 1");
			throw new BusinessException(
					"Does not exist an admin user with id 1");
		}

		// setting the list of users now in the db.
		tmp_usr_list = ad_serv.findAllUsers();
		// tmp_usr_list.remove(ad_serv.findUserById(id_admin)); // "admin1"
		// has
		// not
		// to
		// be
		// deleted!

		for (User var : tmp_usr_list) {
			System.out.println("Deleting User: " + var.getLogin());
			if (!var.getIsAdmin())
				ad_serv.deepDeleteUser(var.getId());
		}

		// clearing temporaney lists
		tmp_usr_list.clear();
		tmp_task_list.clear();
		tmp_category_list.clear();

		// registering the new users
		for (int i = 1; i <= 3; i++) {
			user = new User();
			user.setLogin("user" + i);
			user.setEmail("user" + i + "@uniovi.es");
			user.setPassword("user" + i);
			user.setStatus(UserStatus.ENABLED);
			user.setIsAdmin(false);
			us_dao.save(user);
		}

		// getting the new User IDs
		tmp_usr_list = ad_serv.findAllUsers();
		tmp_usr_list.remove(ad_serv.findUserById(id_admin));

		// creating the new categories
		for (User var : tmp_usr_list) {
			for (int i = 1; i <= 3; i++) {
				category = new Category();
				category.setName("categoría" + i );
				category.setUserId(var.getId());
				ta_serv.createCategory(category);
			}
			tmp_category_list
					.addAll(ta_serv.findCategoriesByUserId(var.getId()));

		}

		// Creating useful Date variables
		// Date today = new Date();
		Date today = DateUtil.today();
		// Date inSixDays = new Date(today.getTime() + (6 * 1000 * 60 * 60 *
		// 24));
		Date inSixDays = DateUtil.addDays(today, 6);
		// Date yesterday = new Date(today.getTime() - (1 * 1000 * 60 * 60 *
		// 24));
		Date yesterday = DateUtil.yesterday();

		// creating the new tasks (not categorized)
		for (User var : tmp_usr_list) {
			for (int i = 1; i <= 10; i++) {
				task = new Task();
				task.setTitle("Task " + i);
				task.setCreated(today);
				task.setUserId(var.getId());
				task.setComments("O.o!");
				task.setPlanned(inSixDays);
				ta_serv.createTask(task);
			}
		}

		// creating others 10 tasks executed.
		for (User var : tmp_usr_list) {
			for (int i = 1; i <= 10; i++) {
				task = new Task();
				task.setTitle("Completed Task "+i);
				task.setCreated(today);
				task.setUserId(var.getId());
				task.setComments("Done!");
				task.setPlanned(today);
				ta_serv.markTaskAsFinished(ta_serv.createTask(task));
			}
		}

		// creating other task categorized.
		for (User var : tmp_usr_list) {
			tmp_category_list.clear();
			tmp_category_list
					.addAll(ta_serv.findCategoriesByUserId(var.getId()));
			for (Category c : tmp_category_list) {
				for (int i = 1; i <= 4; i++) {
					task = new Task();
					task.setTitle("Cathegorized Task " + i);
					task.setCreated(today);
					task.setUserId(var.getId());
					task.setComments("O.o!");
					task.setPlanned(inSixDays);
					task.setCategoryId(c.getId());
					ta_serv.createTask(task);
				}
			}

			// creating old task
			for (@SuppressWarnings("unused") User var1 : tmp_usr_list) {
				for (int i = 1; i <= 10; i++) {
					task = new Task();
					task.setTitle("Old Task " + i);
					task.setCreated(today);
					task.setUserId(var.getId());
					task.setComments("Old!");
					task.setPlanned(yesterday);
					ta_serv.createTask(task);
				}
			}

		}
*/
		return null;
	}

}
