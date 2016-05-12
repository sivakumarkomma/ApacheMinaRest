package com.sample.server;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sample.injector.FileUtilInjector;
import com.sample.util.FileUtilService;
 
@Path("/checkmd5")
public class RestService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String name) {
		
		String fileName = "C://Users//sivak_000//Pictures//BFTScreen1//"+name;		
		Injector injector = Guice.createInjector(new FileUtilInjector()); 
		FileUtilService app = injector.getInstance(FileUtilService.class);        
        String result = app.getMD5ForFile(fileName);    
		return Response.status(200).entity(result).build();
 
	}
	
	
}