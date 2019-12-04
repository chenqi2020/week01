package com.chenqi.week01.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chenqi.week01.domain.Shop;
import com.chenqi.week01.domain.Users;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

public interface UserService {

	List<User> findlist(String uname);
	
	void add(Users users,int[] sid) ;
	
	List getShop();
	
	void dele(String uid);
	
	Users getUsers(int uid);
	
	List getsc(int sid);
	
	
	
}
