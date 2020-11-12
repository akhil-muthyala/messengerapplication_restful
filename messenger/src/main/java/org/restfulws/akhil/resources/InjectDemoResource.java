package org.restfulws.akhil.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations")
	public String passinannotaion(@MatrixParam("name")String name,
								  @HeaderParam("headervalue")String header,
								  @CookieParam("name")String cookie) {
		return "Matrix param is : " +name +" **Header value : " +header + " **Cookiee value : "+cookie;
		
	}
	
	@GET
	@Path("context")
	public String contextannotaion(@Context UriInfo uriinfo,@Context HttpHeaders httpheader) {
		return "Uri Info is :"+ uriinfo.getAbsolutePath().toString()+ " **HttpHeader cookies is : "+ httpheader.getCookies().toString()+" **HttpHaeder value is: "+ httpheader.getMediaType();
		
	}
}
