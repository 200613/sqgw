package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.example.demo.mapper.IUserDao;
import com.example.demo.pojo.User;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	@Override
	public int inserUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.inserUser(user);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.updateUser(user);
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return this.userDao.deleteUser(id);
	}

	@Override
	public List<User> selectAllUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.selectAllUser(user);
	}

	@Override
	public List<User> selectAllUserByName(String name) {
		// TODO Auto-generated method stub
		return this.userDao.selectAllUserByName(name);
	}

	@Override
	public User selectCheckLogin(String user_name, String user_password) {
		// TODO Auto-generated method stub
		return this.userDao.selectCheckLogin(user_name, user_password);
	}

	@Override
	public User selectUserById(Integer id) {
		// TODO Auto-generated method stub
		return this.userDao.selectUserById(id);
	}
}
