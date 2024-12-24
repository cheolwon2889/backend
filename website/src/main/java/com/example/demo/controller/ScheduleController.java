package com.example.demo.controller;

import java.io.Console;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.ScheduleVO;
import com.example.demo.service.RewardService;
import com.example.demo.service.ScheduleService;
import com.example.demo.service.WeatherDataService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@GetMapping("/schedule")
	public List<ScheduleVO> showSchedule() {
		return scheduleService.getSchedule();
	}
}
