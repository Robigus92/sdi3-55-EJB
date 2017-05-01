package uo.sdi.business.impl.task.command;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.persistence.Persistence;

public class DeleteCategoryCommand {

	private Long catId;

	public DeleteCategoryCommand(Long catId) {
		this.catId = catId;
	}

	public Void execute() throws BusinessException {
		Persistence.getTaskDao().deleteAllFromCategory( catId );
		Persistence.getCategoryDao().delete( catId );
		return null;
	}

}
