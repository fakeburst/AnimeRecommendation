package com.google.training.helloworld;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloClass {
	public String message = "Hello World";

	public HelloClass() {
	}

	public HelloClass(String anime) {
		// this.message = "Hello " + name + "!";
		try {
			sendGet(anime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HelloClass(String login, String password) {
		//TODO VLAD ACHTUNG ACHTUNG ACHTUNG ACHTUNG login
		this.message = "Hello " + login + " " + password+ "!";
	}

	public HelloClass(int i) {
		try {
			// sendGet();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HelloClass(String anime, int rating) {
		//TODO VLAD ACHTUNG ACHTUNG ACHTUNG ACHTUNG add anime
		this.message = anime;
	}

	public HelloClass(String[] values) {
		//TODO VLAD ACHTUNG ACHTUNG ACHTUNG ACHTUNG register
		this.message = values[0];
	}

	public HelloClass(String login, boolean b) {
		//TODO VLAD ACHTUNG ACHTUNG ACHTUNG ACHTUNG recommend
	}

	// HTTP GET request
	private void sendGet(String anime) throws Exception {

		// String url = "http://thecatapi.com/api/images/get?format=html";
		String url = "http://hummingbird.me/api/v1/search/anime?query=" + anime;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		this.message = response.toString();

	}

	public String getMessage() {
		return message;
	}
}
