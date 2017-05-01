package uo.sdi.business.impl.admin;

import java.util.List;

import javax.ejb.Stateless;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.admin.command.DeepDeleteUserCommand;
import uo.sdi.business.impl.admin.command.DisableUserCommand;
import uo.sdi.business.impl.admin.command.EnableUserCommand;
import uo.sdi.business.impl.admin.command.ResetDBCommand;
import uo.sdi.dto.User;
import uo.sdi.persistence.Persistence;

@Stateless
public class EjbAdminService implements LocalAdminService, RemoteAdminService{

	@Override
	public void deepDeleteUser(Long id) throws BusinessException {
		new DeepDeleteUserCommand(id).execute();
	}

	@Override
	public void disableUser(Long id) throws BusinessException {
		new DisableUserCommand(id).execute();
	}

	@Override
	public void enableUser(Long id) throws BusinessException {
		new EnableUserCommand(id).execute();
	}

	@Override
	public List<User> findAllUsers() throws BusinessException {
		return Persistence.getUserDao().findAll();
	}

	@Override
	public User findUserById(final Long id) throws BusinessException {
		return Persistence.getUserDao().findById(id);
	}

	@Override
	public void resetDB() throws BusinessException {
		new ResetDBCommand().execute();
	}

}
