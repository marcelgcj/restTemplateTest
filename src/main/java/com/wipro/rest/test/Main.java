package com.wipro.rest.test;

import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

import com.google.gson.Gson;

@SpringBootApplication
public class Main {
	private static final Gson gson = new Gson();

	public static void main(String[] args) {

		RestTemplateBuilder restTemplate = new RestTemplateBuilder();
		GetMethod a = new GetMethod();
		a.RestService(restTemplate);
		Validation test = new Validation();
		Map<String, String> result;
		String url = "http://10.197.83.50:8080/healthCheck";

		try {
			result = GetMethod.changed(url);

			test.getMsgFromApp(gson.toJsonTree(result).getAsJsonObject().get("message").toString());
			result = GetMethod.changed(url + "/dataBase");
			test.getMsgFromDb(gson.toJsonTree(result).getAsJsonObject().get("message").toString());

		} catch (HttpServerErrorException e) {
			test.getMsgFromDbFail();
		} catch (RuntimeException e) {
			test.getMsgFromAppFail();
		}

	}

}
