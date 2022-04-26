package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Complain;

@Path("/Complain")
public class ComplainManage {
	Complain ComplainObj = new Complain();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readComplain() {
		return ComplainObj.readComplain();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertComplain(@FormParam("AccNO") String AccNO,		
	 @FormParam("Complaint") String Complaint,
	 @FormParam("Name") String Name,
	 @FormParam("Address") String Address,
	 @FormParam("MobilePhone") String MobilePhone)
	{
	 String output = ComplainObj.insertComplain(AccNO, Complaint, Name, Address, MobilePhone);
	return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateComplain(String complaintData)
	{
	//Convert the input string to a JSON object
	 JsonObject complaintObject = new JsonParser().parse(complaintData).getAsJsonObject();
	//Read the values from the JSON object
	 String ComID = complaintObject.get("ComID").getAsString();
	 String AccNO = complaintObject.get("AccNO").getAsString();
	 String Complaint = complaintObject.get("Complaint").getAsString();
	 String Name = complaintObject.get("Name").getAsString();
	 String Address = complaintObject.get("Address").getAsString();
	 String MobilePhone = complaintObject.get("MobilePhone").getAsString();
	 String output = ComplainObj.updateComplain(ComID, AccNO, Complaint, Name, Address, MobilePhone);
	return output;
	} 
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteComplain(String complaintData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(complaintData, "", Parser.xmlParser());

	//Read the value from the element <>
	 String ComID = doc.select("ComID").text();
	 String output = ComplainObj.deleteComplain(ComID);
	return output;
	}
	
}
