package com.mtz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBDemo {

	public static void main(String[] args) {
	
		try{  
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/usa","root","@Mohammad786s");  
			
			Statement stmt=con.createStatement();  
			
			ResultSet rs=stmt.executeQuery("select eid,ename,sal from employee");  
			float sal,netSal=0;
			float tax;
			Employee emp = null;
			while(rs.next()) {
			
				emp = new Employee();
				emp.setEid(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setSal(rs.getInt(3));
				
				sal= rs.getInt(3);
				if(sal > 25000) {
					tax = sal * 0.1f;
					netSal = sal - tax;
				}
				System.out.println(emp.getEid()+"  "+
			emp.getEname()+"  "+emp.getSal()+ "   "+netSal);  
					
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);
			}  
			  
		
	}

}
