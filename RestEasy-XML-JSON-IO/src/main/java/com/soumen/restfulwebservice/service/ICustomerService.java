package com.soumen.restfulwebservice.service;


 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.example.customer.CustomerListType;
import org.example.customer.CustomerType;
 
@Path("/customerservice")
public interface ICustomerService {
 
    // Basic CRUD operations for Customer Service
 
    // <a class="vglnk" href="http://localhost:8080/RestEasy-XML-JSON-IO/resteasy/customerservice/addcustomer" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>RestEasy</span><span>-</span><span>XML</span><span>-</span><span>JSON</span><span>-</span><span>IO</span><span>/</span><span>resteasy</span><span>/</span><span>customerservice</span><span>/</span><span>addcustomer</span></a>  - Tomcat 7.0.x
    // <a class="vglnk" href="http://localhost:9090/RestEasy-XML-JSON-IO/resteasy/customerservice/addcustomer" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>9090</span><span>/</span><span>RestEasy</span><span>-</span><span>XML</span><span>-</span><span>JSON</span><span>-</span><span>IO</span><span>/</span><span>resteasy</span><span>/</span><span>customerservice</span><span>/</span><span>addcustomer</span></a>  - JBoss AS7
    @POST
    @Path("addcustomer")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_FORM_URLENCODED})
    public String createOrSaveNewCustomerInfo(CustomerType customerType);
 
    // <a class="vglnk" href="http://localhost:8080/RestEasy-XML-JSON-IO/resteasy/customerservice/getcustomer/10001" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>RestEasy</span><span>-</span><span>XML</span><span>-</span><span>JSON</span><span>-</span><span>IO</span><span>/</span><span>resteasy</span><span>/</span><span>customerservice</span><span>/</span><span>getcustomer</span><span>/</span><span>10001</span></a>  - Tomcat 7.0.x
    // <a class="vglnk" href="http://localhost:9090/RestEasy-XML-JSON-IO/resteasy/customerservice/getcustomer/10001" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>9090</span><span>/</span><span>RestEasy</span><span>-</span><span>XML</span><span>-</span><span>JSON</span><span>-</span><span>IO</span><span>/</span><span>resteasy</span><span>/</span><span>customerservice</span><span>/</span><span>getcustomer</span><span>/</span><span>10001</span></a>  - JBoss AS7
    @GET
    @Path("getcustomer/{id}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CustomerType getCustomerInfo(@PathParam("id") int customerId);
 
    // <a class="vglnk" href="http://localhost:8080/RestEasy-XML-JSON-IO/resteasy/customerservice/updatecustomer" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>RestEasy</span><span>-</span><span>XML</span><span>-</span><span>JSON</span><span>-</span><span>IO</span><span>/</span><span>resteasy</span><span>/</span><span>customerservice</span><span>/</span><span>updatecustomer</span></a>  - Tomcat 7.0.x
    // <a class="vglnk" href="http://localhost:9090/RestEasy-XML-JSON-IO/resteasy/customerservice/updatecustomer" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>9090</span><span>/</span><span>RestEasy</span><span>-</span><span>XML</span><span>-</span><span>JSON</span><span>-</span><span>IO</span><span>/</span><span>resteasy</span><span>/</span><span>customerservice</span><span>/</span><span>updatecustomer</span></a>  - JBoss AS7
    @PUT
    @Path("updatecustomer")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_FORM_URLENCODED})
    public String updateCustomerInfo(CustomerType Customer);
 
    // <a class="vglnk" href="http://localhost:8080/RestEasy-XML-JSON-IO/resteasy/customerservice/deletecustomer" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>RestEasy</span><span>-</span><span>XML</span><span>-</span><span>JSON</span><span>-</span><span>IO</span><span>/</span><span>resteasy</span><span>/</span><span>customerservice</span><span>/</span><span>deletecustomer</span></a>  - Tomcat 7.0.x
    // <a class="vglnk" href="http://localhost:9090/RestEasy-XML-JSON-IO/resteasy/customerservice/deletecustomer" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>9090</span><span>/</span><span>RestEasy</span><span>-</span><span>XML</span><span>-</span><span>JSON</span><span>-</span><span>IO</span><span>/</span><span>resteasy</span><span>/</span><span>customerservice</span><span>/</span><span>deletecustomer</span></a>  - JBoss AS7
    @DELETE
    @Path("deletecustomer")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_FORM_URLENCODED})
    public String deleteCustomerInfo(CustomerType Customer);
 
    // <a class="vglnk" href="http://localhost:8080/RestEasy-XML-JSON-IO/resteasy/customerservice/getallcustomer" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>RestEasy</span><span>-</span><span>XML</span><span>-</span><span>JSON</span><span>-</span><span>IO</span><span>/</span><span>resteasy</span><span>/</span><span>customerservice</span><span>/</span><span>getallcustomer</span></a>  - Tomcat 7.0.x
    // <a class="vglnk" href="http://localhost:9090/RestEasy-XML-JSON-IO/resteasy/customerservice/getallcustomer" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>9090</span><span>/</span><span>RestEasy</span><span>-</span><span>XML</span><span>-</span><span>JSON</span><span>-</span><span>IO</span><span>/</span><span>resteasy</span><span>/</span><span>customerservice</span><span>/</span><span>getallcustomer</span></a>  - JBoss AS7
    @GET
    @Path("getallcustomer")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CustomerListType getAllCustomerInfo();
}
