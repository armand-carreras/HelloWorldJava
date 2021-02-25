package com.netmind.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;

import com.netmind.model.Student;

public class HttpClient {
	// 1 instance for reuse
	private final String URI = "http://localhost:3000/students";
	private final CloseableHttpClient httpClient = HttpClients.createDefault();

	private void close() throws IOException {
		httpClient.close();
	}

	private String get() {
		HttpGet request = new HttpGet(URI);
		String result = "Nothing from entity";
		request.addHeader(HttpHeaders.ACCEPT, "application/json");
		try (CloseableHttpResponse response = httpClient.execute(request)) {
			System.out.println(response.getStatusLine().toString());

			HttpEntity entity = response.getEntity();
			Header headers = entity.getContentType();
			System.out.println(headers);
			result = EntityUtils.toString(entity);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private String post(Student student) throws Exception {
		boolean done = false;
		HttpPost request = new HttpPost(URI);
		JSONObject obj = new JSONObject();
		obj.put("idStudent", student.getIdStudent());
		obj.put("name", student.getName());
		obj.put("surname", student.getSurname());
		obj.put("age", student.getAge());
		obj.put("dateOfBirth", student.getDateOfBirth());
		StringEntity jsonEntity = (new StringEntity(obj.toJSONString()));
		jsonEntity.setContentType("application/json");
		request.setEntity(jsonEntity);
		HttpResponse response = httpClient.execute(request);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output;
		StringBuffer totalOutput = new StringBuffer();
		System.out.println("Output from server...");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
			totalOutput.append(output);
		}
		return totalOutput.toString();
	}
}
