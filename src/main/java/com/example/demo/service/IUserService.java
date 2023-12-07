package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface IUserService {
	
	public int inserUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(Integer id);
	
	public List<User> selectAllUser(User user);
	
	public List<User> selectAllUserByName(String name);
	
	public User selectCheckLogin(@Param("user_name") String user_name, @Param("user_password") String user_password);
	
	public User selectUserById(Integer id);


}
