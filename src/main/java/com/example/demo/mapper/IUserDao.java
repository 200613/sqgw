package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface IUserDao {
	
	int inserUser(User user);
	
	int updateUser(User user);
	
	int deleteUser(Integer id);
	
	List<User> selectAllUser(User user);
	
	List<User> selectAllUserByName(String name);
	
	User selectUserById(Integer id);
	
	User selectCheckLogin(@Param("user_name") String user_name, @Param("user_password") String user_password);

}
