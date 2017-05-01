package uo.sdi.dto.util;

import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;


public class Cloner {

	public static User clone(User u) {
		User tmp = new User();
		tmp.setId(u.getId());
		tmp.setEmail(u.getEmail());
		tmp.setIsAdmin(u.getIsAdmin());
		tmp.setLogin(u.getLogin());
		tmp.setPassword(u.getPassword());
		tmp.setStatus(u.getStatus());
		return tmp;
	}
	
	public static Task clone(Task t) {
		Task tmp = new Task();
		tmp.setId(t.getId());
		tmp.setCategoryId(t.getCategoryId());
		tmp.setComments(t.getComments());
		tmp.setCreated(t.getCreated());
		tmp.setFinished(t.getFinished());
		tmp.setPlanned(t.getPlanned());
		tmp.setTitle(t.getTitle());
		tmp.setUserId(t.getUserId());
		return tmp;
	}

	public static Category clone(Category c) {
		Category tmp = new Category();
		tmp.setName(c.getName());
		tmp.setUserId(c.getUserId());
		return tmp;
	}

}
