package com.chenqi.week01.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenqi.week01.domain.Shop;
import com.chenqi.week01.domain.Users;
import com.chenqi.week01.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping("list")
	public String findlist(Model model,@RequestParam(defaultValue = "1")int pageNum,String uname) {
		PageHelper.startPage(pageNum, 2);
		List list = service.findlist(uname);
		PageInfo info = new PageInfo<>(list);
		model.addAttribute("list", list);
		model.addAttribute("info", info);
		return "list";
	}
	@RequestMapping("toAdd")
	public String getShop(Model model) {
		List shop = service.getShop();
		model.addAttribute("shop", shop);
		model.addAttribute("users", new Users());
		return "add";
		
	}
	@RequestMapping("add")
	public String add(@Valid @ModelAttribute("users")Users users,BindingResult result,Model model,int[] sid) {
	
		int count=0;
		
		List<Shop> sh = users.getShop();
		for (Shop shop : sh) {
			if(null != shop.getSid()) {
				count++;
			}
		}
		if(count == 0) {
			result.rejectValue("shop", "", "商品不能为空");
		}
		if(result.hasErrors()) {
			List shop = service.getShop();
			model.addAttribute("shop", shop);
			return "add";
		}
		service.add(users,sid);
		return "redirect:list";
	}
	
	@RequestMapping("dele")
	public String dele(String uid) {
		
		service.dele(uid);
		return "redirect:list";
		
		
	}
	
	@RequestMapping("get")
	public String getUers(int uid,Model model,String uname) {
		
		Users users = service.getUsers(uid);
		List shop = service.getShop();
		List<User> list = service.findlist(uname);
		model.addAttribute("list", list);
		model.addAttribute("users", users);
		model.addAttribute("shop", shop);
		return "look";
		
	}
	@ResponseBody
	@RequestMapping("getsc")
	public Object getsc(int sid,Model model) {
		List getsc = service.getsc(sid);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("getsc", getsc);
		return map;
		
		
	}
	
}
