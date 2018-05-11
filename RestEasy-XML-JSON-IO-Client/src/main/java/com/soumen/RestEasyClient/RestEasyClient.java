package com.soumen.RestEasyClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.example.customer.CustomerListType;
import org.example.customer.CustomerType;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
 

public class RestEasyClient {

	public static void main(String[] args) throws Exception{
		
				while (true) {
						System.out.println("Enter your choice");
						System.out.println("1 For getCustomerJsonById");
						System.out.println("2 For getAllCustomerJson");
						System.out.println("3 For getCustomerXmlById");
						System.out.println("4 For getAllCustomerXml");
						System.out.println("5 For Exit");
						Scanner in = new Scanner(System.in);
						int a = in.nextInt();
				        System.out.println("You entered choice "+a);
				        String httpGetURL = null;
				        String responseStringGet = null;
				        String responseXmlStringGet = null;
				        String fileName="src/main/resources/xml/generatedcustomer.xml";
				        switch(a){
							case 1: httpGetURL="http://localhost:10000/RestEasy-XML-JSON-IO/resteasy/customerservice/getcustomer/45001";
								System.out.println("Invoking and executing getCustomer JSON service for customer id 45001");
								responseStringGet = getCustomerServiceRequest(httpGetURL,MediaType.APPLICATION_JSON);
						        System.out.println("GET >> Response String : " + responseStringGet);
						        JSONParser customerParser=new JSONParser();
						        Object customerObj = customerParser.parse(responseStringGet);
						        JSONObject customerJo = (JSONObject) customerObj;
						        long customerid = (Long) customerJo.get("customerId");
						        String name = (String)customerJo.get("name");
						        long age = (Long)customerJo.get("age");
						        System.out.println("Customet id:"+customerid+" name:"+name+" age:"+age);
						        System.out.println("Reading Json successfully");
						        break;
						        
							case 2: httpGetURL="http://localhost:10000/RestEasy-XML-JSON-IO/resteasy/customerservice/getallcustomer";
								System.out.println("Invoking and executing getAllCustomer JSON service");
								responseStringGet = getCustomerServiceRequest(httpGetURL,MediaType.APPLICATION_JSON);
						        System.out.println("GET >> Response String : " + responseStringGet);	
								JSONParser parser=new JSONParser();
						        Object obj = parser.parse(responseStringGet);
						        JSONObject jo = (JSONObject) obj;
						        JSONArray ja = (JSONArray) jo.get("CustomerType");
						        Iterator itr = ja.iterator();		         
						        while (itr.hasNext()) 
						        {
						        	Iterator itr1 = ((Map) itr.next()).entrySet().iterator();
						            while (itr1.hasNext()) {
						                Map.Entry pair = (Entry) itr1.next();
						                System.out.println(pair.getKey() + " : " + pair.getValue());
						            }
						        }
						        System.out.println("Reading Json successfully");
								break;
								
							case 3:httpGetURL="http://localhost:10000/RestEasy-XML-JSON-IO/resteasy/customerservice/getcustomer/45001";
								System.out.println("Invoking and executing getCustomer XML service for customer id 45001");
								responseXmlStringGet = getCustomerServiceRequest(httpGetURL, MediaType.APPLICATION_XML);
						        System.out.println("GET >> Response String : " + responseXmlStringGet);
						        // Parse the given input
						        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
						        DocumentBuilder builder = factory.newDocumentBuilder();
						        Document doc = builder.parse(new InputSource(new StringReader(responseXmlStringGet)));
	
						        // Write the parsed document to an xml file
						        TransformerFactory transformerFactory = TransformerFactory.newInstance();
						        Transformer transformer = transformerFactory.newTransformer();
						        DOMSource source = new DOMSource(doc);
	
						        StreamResult result =  new StreamResult(new File(fileName));
						        transformer.transform(source, result);
						     
						        JAXBContext ctx=JAXBContext.newInstance(CustomerType.class);
								Unmarshaller um=ctx.createUnmarshaller();
								CustomerType cs=(CustomerType)um.unmarshal(new FileInputStream(fileName));
								System.out.println("customer id:"+cs.getCustomerId()+" name:"+cs.getName()+" age:"+cs.getAge());
								System.out.println("Reading Xml successfully");
								break;
								
							case 4: httpGetURL="http://localhost:10000/RestEasy-XML-JSON-IO/resteasy/customerservice/getallcustomer";
								System.out.println("Invoking and executing getAllCustomer XML service");
								responseXmlStringGet = getCustomerServiceRequest(httpGetURL, MediaType.APPLICATION_XML);
						        System.out.println("GET >> Response String : " + responseXmlStringGet);
						        // Parse the given input
						        DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
						        DocumentBuilder builder2 = factory2.newDocumentBuilder();
						        Document doc2 = builder2.parse(new InputSource(new StringReader(responseXmlStringGet)));
	
						        // Write the parsed document to an xml file
						        TransformerFactory transformerFactory2 = TransformerFactory.newInstance();
						        Transformer transformer2 = transformerFactory2.newTransformer();
						        DOMSource source2 = new DOMSource(doc2);
	
						        StreamResult result2 =  new StreamResult(new File(fileName));
						        transformer2.transform(source2, result2);
						     
						        JAXBContext ctx2=JAXBContext.newInstance(CustomerListType.class);
								Unmarshaller um2=ctx2.createUnmarshaller();
								
								CustomerListType custs=(CustomerListType)um2.unmarshal(new FileInputStream(fileName));
								List<CustomerType> cust=custs.getCustomerType();
								for(CustomerType c:cust){
									System.out.println("customer id:"+c.getCustomerId()+" name:"+c.getName()+" age:"+c.getAge());
								}
								System.out.println("Reading Xml successfully");
								break;
								
							case 5: System.out.println("Exiting from application");
								System.exit(0);
								break;
								
							case 6: // setting & invoking second service addCustomer with XML/JSON request
						        System.out.println("\n\nInvoking and executing addCustomer service with request");
						        
						        String httpPostURL = "http://localhost:10000/RestEasy-XML-JSON-IO/resteasy/customerservice/addcustomer";
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
						        String responseStringPost = testCustomerServiceForPostRequest(httpPostURL, requestStringInJson);
						        System.out.println("POST >> Response String : " + responseStringPost);
						        break;
							default: System.exit(0); 
					}
				}
		 
		       }
		 
		    /**
		     * using ClientRequest and ClientResponse classes from org.jboss.resteasy.client
		     * @param httpURL
		     * @return responseString
		     * @throws Exception
		     */
		    @SuppressWarnings("deprecation")
		    public static String getCustomerServiceRequest(String httpURL, String mediaType) throws Exception {
		 
		        // local variables
		        ClientRequest clientRequest = null;
		        ClientResponse<String> clientResponse = null;
		        int responseCode;
		        String responseString = null;
		 
		        try{
		            clientRequest = new ClientRequest(httpURL);
		            clientRequest.setHttpMethod(HttpMethod.GET);
		            clientRequest.header("Content-Type", MediaType.APPLICATION_FORM_URLENCODED);
		            clientRequest.accept(mediaType);//MediaType.APPLICATION_XML or MediaType.APPLICATION_JSON
		            clientResponse = clientRequest.get(String.class);
		 
		            responseCode = clientResponse.getResponseStatus().getStatusCode();
		            System.out.println("Response code: " + responseCode);
		 
		            if(clientResponse.getResponseStatus().getStatusCode() != 200) {
		                throw new RuntimeException("Failed with HTTP error code : " + responseCode);
		            }
		 
		            System.out.println("ResponseMessageFromServer: " + clientResponse.getResponseStatus().getReasonPhrase());
		            responseString = clientResponse.getEntity();
		        }
		        catch(Exception ex) {
		            ex.printStackTrace();
		        }
		        finally{
		            // release resources, if any
		            clientResponse.close();
		            clientRequest.clear();
		        }
		        return responseString;
		    }
		 
		    /**
		     * using ResteasyClient, ResteasyWebTarget and Response classes from org.jboss.resteasy.client
		     * @param httpURL
		     * @param requestString
		     * @return
		     */
		    public static String testCustomerServiceForPostRequest(String httpURL, String requestString)  throws Exception {
		 
		        // local variables
		        ResteasyClient resteasyClient = null;
		        ResteasyWebTarget resteasyWebTarget = null;
		        Response response = null;
		        int responseCode;
		        String responseString = null;
		 
		        try{
		            resteasyClient = new ResteasyClientBuilder().build();
		            resteasyWebTarget = resteasyClient.target(httpURL);
		            //          resteasyWebTarget.property("Content-Type", MediaType.APPLICATION_FORM_URLENCODED);
		            //          resteasyWebTarget.property("accept", MediaType.APPLICATION_JSON);
		            response = resteasyWebTarget.request(MediaType.APPLICATION_FORM_URLENCODED).post(Entity.entity(requestString, MediaType.APPLICATION_JSON));
		 
		            responseCode = response.getStatus();
		            System.out.println("Response code: " + responseCode);
		 
		            if (response.getStatus() != 200) {
		                throw new RuntimeException("Failed with HTTP error code : " + responseCode);
		            }
		 
		            System.out.println("ResponseMessageFromServer: " + response.getStatusInfo().getReasonPhrase());
		            responseString = response.readEntity(String.class);
		        }
		        catch(Exception ex){
		            ex.printStackTrace();
		        }
		        finally{
		            // release resources, if any
		        	if(Objects.nonNull(response)) {
		        		response.close();
		        	}
		        }
		        return responseString;
		    }
		}

