package com.atguigu.task.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

	@Scheduled(cron = "* * * * * ?")
	public void schedule() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(LocalDateTime.now().format(formatter) + " --> scheduling......");
	}
}
