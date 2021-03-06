package uo.sdi.business.impl.task.command;

import java.util.List;

import uo.sdi.business.exception.BusinessCheck;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;
import uo.sdi.dto.util.Cloner;
import uo.sdi.persistence.CategoryDao;
import uo.sdi.persistence.Persistence;
import uo.sdi.persistence.TaskDao;

public class DuplicateCategoryCommand {

	private Long origId;

	public DuplicateCategoryCommand(Long id) {
		this.origId = id;
	}

	public Long execute() throws BusinessException {
		Long copyId = duplicateCategory( origId );
		duplicateTasks( origId, copyId );
		
		return copyId;
	}

	private Long duplicateCategory(Long id) throws BusinessException {
		CategoryDao cDao = Persistence.getCategoryDao();
		
		Category original = cDao.findById(id);
		BusinessCheck.isNotNull( original, "The category does not exist");
		checkUserNotDisabled( original );
		
		Category copy = Cloner.clone(original);
		copy.setName( copy.getName() + " - copy");
		return cDao.save( copy );
	}

	private void checkUserNotDisabled(Category c) throws BusinessException {
		User u = Persistence.getUserDao().findById( c.getUserId() );
		BusinessCheck.isTrue( u.getStatus().equals( UserStatus.ENABLED ),
				"User disables, category cannot be duplicated.");
	}

	private void duplicateTasks(Long catId, Long copyId) {
		TaskDao tDao = Persistence.getTaskDao();
		Task tmp = new Task();

		List<Task> tasks = tDao.findTasksByCategoryId( catId );
		for(Task t: tasks) {
			tmp = Cloner.clone(t);
			tmp.setCategoryId( copyId );
			Task copy = tmp;
			tDao.save( copy );
		}
	}

}
