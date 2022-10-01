package rest.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import rest.entities.Employe;

@Path("/employes")
public class GestionEmploye {
	
	public static  List<Employe> employes=new ArrayList<Employe>();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // or @Consumes("application/json") --------- chnuwa el web service iconsommi 
	@Produces(MediaType.TEXT_PLAIN) // or @Consumes("text/plain") ------------- chnuwa el web service i5arej
	public Response ajouterEmploye(Employe employe) {
		// if(employes.add(employe))
		// return "Add Successful";
		// return "Echec"; // bech iraj3elna el status 200 OK (radina el reuturn type response)
		 if(employes.add(employe))
			 return Response.status(Status.CREATED).entity("Add Successful").build();
		 return Response.status(Status.NOT_FOUND).entity("Add Failed").build();
	}
	/*
	{
    	"cin" : 1223,
	    "nom" : "omar",
	    "prenom" : "g"
	}
	*/
	// http://localhost:8088/GestionEmploye/rest/employes
	// JSON
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  Response displayEmployeesList() {
		if(employes.size()!=0)
			return Response.status(Status.FOUND).entity(employes).build();
		else
			return Response.status(Status.NO_CONTENT).build();
	}
	// http://localhost:8088/GestionEmploye/rest/employes
	// JSON (pas besoin?)
	
	@GET
	@Path("{ id }")
	@Produces(MediaType.APPLICATION_XML)
	public Response getEmploye(@PathParam(value = "id")int cin) {
		for (Employe info:employes) {
	       if(info.getCin()==cin) {
	    	   return Response.status(Status.FOUND)
						.entity(info)
						.build(); 
	       }
		}
		return  Response.status(Status.NOT_FOUND).build();		
	}
	// http://localhost:8088/GestionEmploye/rest/employes/1223
	// XML (pas besoin?)
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateEmploye(Employe e) {
		int index= this.getIndexByCin(e.getCin());
		if (index!=-1) {
			employes.set(index, e);
			return Response.status(Status.OK).entity("update successful").build();
			
		}
		return Response.status(Status.NOT_FOUND).entity("update unsuccessful").build();
	
	}
	/*
	<employe>
	    <cin>123</cin> 
	    <nom>omran</nom>
	    <prenom>ghalilo</prenom>
	</employe>
	*/
	// http://localhost:8088/GestionEmploye/rest/employes
	// XML
	
	@DELETE
	@Path("{ var }")
	// @Produces(MediaType.TEXT_PLAIN) // yefhem wa7du true or false
	public Response deleteEmpl(@PathParam(value = "var")int cin){
		int index= getIndexByCin(cin);
		
		if (index!=-1) {
			employes.remove(index);
			return Response.status(Status.OK).entity(true).build();
			// return true;
		}else 
			return Response.status(Status.NOT_ACCEPTABLE).entity(false).build();
			// return false;
    }
	// http://localhost:8088/GestionEmploye/rest/employes/123
	
	public int getIndexByCin(int cin) {
		for(Employe emp: employes) {
			if (emp.getCin()==cin)
				return employes.indexOf(emp);
		}
		return -1;
	}
	
		
}
