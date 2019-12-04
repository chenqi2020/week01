package com.chenqi.week01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenqi.week01.dao.UserMapper;
import com.chenqi.week01.domain.Shop;
import com.chenqi.week01.domain.Users;
import com.chenqi.week01.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	@Autowired 
	private UserMapper userMapper;

	@Override
	public List findlist(String uname) {
		// TODO Auto-generated method stub
		return userMapper.findlist(uname);
	}

	@Override
	public void add(Users users,int[] sid) {
		// TODO Auto-generated method stub
		userMapper.adduse(users);
		List<Shop> shop = users.getShop();
		for (Shop sho : shop) {
			if(null!=sho.getSid()) {
				userMapper.addsc(users.getUid(), sho.getSid());
			}
		}
	}

	@Override
	public List getShop() {
		// TODO Auto-generated method stub
		return userMapper.getShop();
	}

	@Override
	public void dele(String uid) {
		// TODO Auto-generated method stub
		userMapper.delesc(uid);
		userMapper.deleuse(uid);
		
	}

	@Override
	public Users getUsers(int uid) {
		// TODO Auto-generated method stub
		return userMapper.getUsers(uid);
	}

	@Override
	public List getsc(int sid) {
		// TODO Auto-generated method stub
		return userMapper.getsc(sid);
	}

	
}
