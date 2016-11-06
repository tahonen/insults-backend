package com.tahonen.ocp.demos.insults;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/insults")
public class InsultsService {
	@Inject
	private InsultsRepo ir;

	@GET
	@Path("/")
	@Produces("application/json;charset=UTF-8")
	public Response list() {
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("content", ir.getInsult());
			return Response.status(Response.Status.OK).entity(data).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	}

}