package com.example.mybatisStudent.controller;

import java.util.ArrayList;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mybatisStudent.dto.RequestUserDto;
import com.example.mybatisStudent.dto.ResponseUserDto;
import com.example.mybatisStudent.model.UserBean;
import com.example.mybatisStudent.service.UserDao;

@Controller
@RequestMapping("/user")
public class UserController {

	List<ResponseUserDto> resUserDtoList = new ArrayList<>();
	
	String confirmPassword;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RequestUserDto requestUserDto;
	@Autowired
	private ResponseUserDto responseUserDto;
	
	@GetMapping("/view")
	public ModelAndView userView(ModelMap model) {
		resUserDtoList = userDao.selectAll();
		model.addAttribute("resUserDtoList", resUserDtoList);
		return new ModelAndView("userView","userBean",new UserBean());
	}
	
	@GetMapping("/register")
	public ModelAndView registerView() {
		return new ModelAndView("userRegister","userBean",new UserBean());
	}
	
	@PostMapping("/add")
	public String addUser(@ModelAttribute("userBean") UserBean userBean, ModelMap model) {
		requestUserDto.setEmail(userBean.getEmail());
		requestUserDto.setPassword(userBean.getPassword());
		confirmPassword = userBean.getConfirmPassword();
		
		if(requestUserDto.getPassword().equals(confirmPassword)) {
			userDao.createUser(requestUserDto);
			return "redirect:/user/view";
		}
		else {
			model.addAttribute("error","Something is wrong in email and password.");
			return "redirect:/user/register";
		}
	}
	
	@GetMapping("/updateView/{updateId}")
	public ModelAndView fetchUserToUpdate(@PathVariable("updateId") String updateId, Model model) {
		requestUserDto.setId(Integer.valueOf(updateId));
		responseUserDto = userDao.selectOneById(requestUserDto);
		model.addAttribute("fetchedUserData",responseUserDto);
		UserBean userBean =new UserBean();
		userBean.setId(String.valueOf(responseUserDto.getId()));
		userBean.setEmail(responseUserDto.getEmail());
		userBean.setPassword(responseUserDto.getPassword());
		return new ModelAndView("userUpdate","userBean",userBean);
	}
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute("userBean") UserBean userBean, ModelMap model){
		
		requestUserDto.setId(Integer.valueOf(userBean.getId()));
		requestUserDto.setEmail(userBean.getEmail());
		requestUserDto.setPassword(userBean.getPassword());
		userDao.updateByUserId(requestUserDto);
		return "redirect:/user/view";
	}
	
	@GetMapping("/delete/{deleteId}")
	public String deleteUser(@PathVariable("deleteId")String deleteId) {
		requestUserDto.setId(Integer.valueOf(deleteId));
		userDao.deleteByUserId(requestUserDto);
		return "redirect:/user/view";
	}
	
	@GetMapping("/search")
	public ModelAndView searchUser(@ModelAttribute("userBean") UserBean userBean, ModelMap model) {
		ResponseUserDto responseUserDto = null;
		if(userBean.getId()!="") {
			requestUserDto.setId(Integer.valueOf(userBean.getId()));
			responseUserDto = userDao.selectOneById(requestUserDto);
			model.addAttribute("searchedUserDto", responseUserDto);
			}
		
		else if(userBean.getEmail()!=""){
			requestUserDto.setEmail(userBean.getEmail());
			responseUserDto = userDao.selectOneByEmail(requestUserDto);
			model.addAttribute("searchedUserDto", responseUserDto);
			}
		
		else {
			model.addAttribute("error", "Fill the blank to search");
		}
		return new ModelAndView("userSearched","userBean",userBean);
	}
}