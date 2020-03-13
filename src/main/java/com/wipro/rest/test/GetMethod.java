package com.wipro.rest.test;

import java.net.http.HttpHeaders;
import java.time.Duration;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

public class GetMethod {

	private static RestTemplate restTemplate;

	public void RestService(RestTemplateBuilder restTemplateBuilder) {
		GetMethod.restTemplate = restTemplateBuilder.build();
	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> changed(String url) {
		Map<String, String> result = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Map.class).getBody();
		return result;
	}

	public static HttpStatus httpCode(String url) {
		return restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Map.class).getStatusCode();
	}

}