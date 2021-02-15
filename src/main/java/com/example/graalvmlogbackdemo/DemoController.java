package com.example.graalvmlogbackdemo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DemoController {

	private static final Logger logger = LoggerFactory.getLogger("DEMO");
	
	@GetMapping("/log")
	public void log() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> logMap = getLogMap();
		logger.info(mapper.writeValueAsString(logMap));
	}

	private Map<String, Object> getLogMap() {
        Map<String, Object> logMap = new HashMap<>();
        logMap.put("METHOD", "log");
        logMap.put("SERVICE", "graalvm-logback-demo");
        return logMap;
    }
	
}
