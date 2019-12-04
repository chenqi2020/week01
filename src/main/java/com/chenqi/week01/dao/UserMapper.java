package com.chenqi.week01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.internal.util.privilegedactions.GetAnnotationAttribute;

import com.chenqi.week01.domain.Shop;
import com.chenqi.week01.domain.Users;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

public interface UserMapper {

	List<User> findlist(@Param("uname")String uname);
	
	List getShop();
	
	void adduse(Users users);
	
	void addsc(@Param("uid")int uid,@Param("sid")int sid);
	
	void deleuse(@Param("uid")String uid);
	
	void delesc(@Param("uid")String uid);
	
	Users getUsers(@Param("uid")int uid);
	
	List getsc(@Param("sid")int sid);
	
	
}
