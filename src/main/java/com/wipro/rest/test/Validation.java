package com.wipro.rest.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

@Component
public class Validation {

	@Value("${message}")
	private String message;

	@Value("${messagedb}")
	private String messagedb;

	public void getMsgFromApp(String result) {
		assertEquals(result, "\"UP and Running\"");
		System.out.println("Application test: OK!");
	}

	public void getMsgFromDb(String result) {
		assertEquals(result, "\"UP and Running DATA BASE\"");
		System.out.println("Data base test: OK!");
	}

	public void getMsgFromAppFail() {
		System.out.println("Server Down!");
	}

	public void getMsgFromDbFail() {
		System.out.println("Data base Down!");
	}

}
