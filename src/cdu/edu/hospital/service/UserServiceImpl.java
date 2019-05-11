package cdu.edu.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cdu.edu.hospital.dao.UserDao;
import cdu.edu.hospital.entity.User;
import cdu.edu.hospital.entity.UserCode;
import cdu.edu.hospital.service.NameOrPasswordException;
import cdu.edu.hospital.service.UserService;


/**
 * 业务层实现类
 * @Service 与组件扫描配合, 扫描到cdu.edu.hospital.impl
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired //注入的组件ID是 userDao
	private UserDao userDao;
	
	@Transactional
	public User login(String name, String password) throws NameOrPasswordException {
		//检查入口参数!!! 
		if(name==null||name.trim().isEmpty()){
			throw new NameOrPasswordException(1, "用户为空");
		}
		if(password==null||password.trim().isEmpty()){
			throw new NameOrPasswordException(2, "密码为空");
		}
		name = name.trim();
		password = password.trim();
		User useryz = new User();
		useryz.setId(name);
		User user = userDao.findUserById(name);
		if(user==null){
			throw new NameOrPasswordException(1, "用户不存在");
		}
		/*if(! name.equals(user.getName())){
			throw new NameOrPasswordException(1,"名字错误");
		}*/
		if(user!=null&&password.equals(user.getPassword())){
			//登录成功
			return user;
		}
		System.out.println("密码错误");
		throw new NameOrPasswordException(2, "密码错误");
	}

	/**
	 * 用户注册
	 */
	@Override
	public void register(User user) {
		userDao.saveUser(user);
	}
	/**
	 * 用户查询
	 */
	@Override
	public User findUserById(String id) {
		return userDao.findUserById(id);
	}
	/**
	 * 用户的查询
	 */
	@Override
	public List<User> userQuery(UserCode userCode) {
		return userDao.userQuery(userCode);
	}
	/**
	 * 用户的删除
	 */
	@Override
	public void userDelete(String id) {
		 userDao.userDelete(id);
	}
	/**
	 * 修改密码
	 */
	@Override
	public void updateUser(User user) {
		 userDao.updateUser(user);
	}
	/**
	 * 修改用户信息
	 */
	@Override
	public void updateUserMessage(User user) {
		 userDao.updateUserMessage(user);
	}
	
}



