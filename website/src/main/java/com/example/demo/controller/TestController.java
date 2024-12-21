package com.example.demo.controller;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OpenURLService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TestController {
	
	@Autowired
	private OpenURLService openUService;
	
	@GetMapping("/")
	public void main() {
		System.out.println("main 실행");
	}
	
	@GetMapping("/hello")
	public void hello() {
		System.out.println("hello 실행");
	}
	
	@GetMapping("/weather")
	public void weatherGET() {
		openUService.getWeather();
	}
	
	

}
