package com.soumen.RestEasyClient;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class RestEasyClientPost {

	public static void main(String[] args) {

	  try {
		  
		  
		  String httpPostURL = "http://localhost:10000/RestEasy-XML-JSON-IO/resteasy/customerservice/addcustomer";
  		

		ClientRequest request = new ClientRequest(httpPostURL);
		request.accept("application/json");

		String requestStringInJson = "{"
		          +                   " \"customerId\": 45011, "
		          +                   " \"name\": \"Shin Chan\","
		          +                   "\"age\": 25 "
		          +               "}";
		  String requestStringInXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
		          +                   "<CustomerType>"
		          +                       "<customerId>45021</customerId>"
		          +                       "<name>Nobita</name>"
		          +                       "<age>26</age>"
		          +                   "</CustomerType>";
		  
		request.body("application/json", requestStringInJson);
			
		ClientResponse<String> response = request.post(String.class);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			new ByteArrayInputStream(response.getEntity().getBytes())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

	  } catch (MalformedURLException e) {

		e.printStackTrace();
			
	  } catch (IOException e) {

		e.printStackTrace();

	  } catch (Exception e) {

		e.printStackTrace();

	  }

	}

}

