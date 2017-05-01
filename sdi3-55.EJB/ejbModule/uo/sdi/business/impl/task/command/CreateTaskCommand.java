package uo.sdi.business.impl.task.command;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.util.TaskCheck;
import uo.sdi.dto.Task;
import uo.sdi.persistence.Persistence;
import alb.util.date.DateUtil;

public class CreateTaskCommand {

	private Task task;

	public CreateTaskCommand(Task task) {
		this.task = task;
	}

	public Long execute() throws BusinessException {
		TaskCheck.userExists( task );
		TaskCheck.userIsNotDisabled( task );
		TaskCheck.userIsNotAdmin( task );
		TaskCheck.titleIsNotNull( task );
		TaskCheck.titleIsNotEmpty( task );
		if ( task.getCategoryId() != null ) {
			TaskCheck.categoryExists( task );
		}
		
		task.setCreated( DateUtil.today() );
		task.setFinished( null );
		return Persistence.getTaskDao().save( task );
	}

}
