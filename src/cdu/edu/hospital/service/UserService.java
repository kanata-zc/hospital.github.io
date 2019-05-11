package cdu.edu.hospital.service;

import java.util.List;

import cdu.edu.hospital.entity.User;
import cdu.edu.hospital.entity.UserCode;

/**
 * 用户的服务接口
 * @author 毅
 *
 */
public interface UserService {
	//用户的登录
	public User login(String id,String password) throws NameOrPasswordException;
	//用户的注册
	public void register(User user);
	//用户的查询
	public User findUserById(String id);
	//用户的查询
	public List<User> userQuery(UserCode userCode);
	//用户的删除
	public void userDelete(String id);
	//修改密码
	public void updateUser(User user);
	//更新用户信息
	public void updateUserMessage(User user);
}
