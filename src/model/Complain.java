package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Complain {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/eletrogrid?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	
	public String insertComplain(String AccNO, String Complaint, String Name, String Address, String MobilePhone) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into complaintdb(`ComID`,`AccNO`,`Complaint`,`Name`,`Address`,`MobilePhone`)" + " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, AccNO);
			preparedStmt.setString(3, Complaint);
			preparedStmt.setString(4, Name);
			preparedStmt.setString(5, Address);
			preparedStmt.setString(6, MobilePhone);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the complaint.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readComplain() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Complaint ID</th><th>Account No</th><th>Complaint</th><th>Name</th><th>Address</th><th>Mobile Phone</th></tr>";
			String query = "select * from complaintdb";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String ComID = Integer.toString(rs.getInt("ComID"));
				String AccNO = rs.getString("AccNO");
				String Complaint = rs.getString("Complaint");
				String Name = rs.getString("Name");
				String Address = rs.getString("Address");
				String MobilePhone = rs.getString("MobilePhone");

				// Add into the html table
				output += "<tr><td>" + ComID + "</td>";
				output += "<td>" + AccNO + "</td>";
				output += "<td>" + Complaint + "</td>";
				output += "<td>" + Name + "</td>";
				output += "<td>" + Address + "</td>";
				output += "<td>" + MobilePhone + "</td>";
				
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the complaint.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateComplain(String ComID, String AccNO, String Complaint, String Name, String Address, String MobilePhone) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE complaintdb SET AccNO=?,Complaint=?,Name=?,Address=?,MobilePhone=?" + "WHERE ComID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, AccNO);
			preparedStmt.setString(2, Complaint);
			preparedStmt.setString(3, Name);
			preparedStmt.setString(4, Address);
			preparedStmt.setString(5, MobilePhone);
			preparedStmt.setInt(6, Integer.parseInt(ComID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the complaint.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deleteComplain(String ComID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from complaintdb where ComID =?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(ComID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the complaint.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
