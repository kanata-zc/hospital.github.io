package cdu.edu.hospital.dao;


import java.util.List;

import cdu.edu.hospital.entity.User;
import cdu.edu.hospital.entity.UserCode;

/**
 * 用户管理
 * @author 毅
 *
 */
public interface UserDao {
	/**
	 * 用户的查询
	 * @param user
	 * @return
	 */
	public User findUser(User user);
	/**
	 * 用户的注册
	 * @param user
	 * @return
	 */
	public void saveUser(User user);
	/**
	 * 用户的查询
	 * @param id
	 * @return
	 */
	public User findUserById(String id);
	/**
	 * 用户的查询
	 * @param userCode
	 * @return
	 */
	public List<User> userQuery(UserCode userCode);
	/**
	 * 用户的删除
	 * @param id
	 */
	public void userDelete(String id);
	/**
	 * 修改密码
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * 更新用户信息
	 * @param user
	 */
	public void updateUserMessage(User user);
}
