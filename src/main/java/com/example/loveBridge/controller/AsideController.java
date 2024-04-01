package com.example.LoveBridge.controller;

import java.util.Map;     

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.LoveBridge.util.AsideUtil;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/aside")
public class AsideController {
	@Autowired
	private AsideUtil asideUtil; // AsideUtil 클래스의 인스턴스 생성

	@ResponseBody // 데이터 바로 보냄
	@GetMapping("/stateMsg")
	public String changeStateMsg(String stateMsg, HttpSession session, Model model) {
		System.out.println(stateMsg);
		session.setAttribute("stateMsg", stateMsg);
		
		return "return message"; // 데이터 바로 보냄
	}
	
}	


