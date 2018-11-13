package Brd3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class dbinsert 
{
	public static  void insertdb(int valid,String[] record)
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			Statement statement = connection.createStatement();
		//	for(String temp:record)System.out.println(temp);
			PreparedStatement ps=connection.prepareStatement("insert into char_customer values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,valid);  
			ps.setString(2,record[0]);  
			ps.setString(3,record[1]);  
			ps.setString(4,record[2]);  
			ps.setString(5,record[3]);  
			ps.setString(6,record[4]);  
			ps.setString(7,record[5]);  
			ps.setString(8,record[6]);  
			ps.setString(9,record[7]);  
			ps.setString(10,record[8]);  
			ps.setString(11,record[9]);  
			ps.setString(12,record[10]);  
			ps.setString(13,record[11]);  
			ps.setString(14,record[12]);  
			ps.setString(15,record[13]);  
			ps.setString(16,record[14]);  
			ps.setString(17,record[15]);  
			int i=ps.executeUpdate(); 
			
			connection.close();
	
			
		} catch (ClassNotFoundException exception) {
			System.out.println(exception);
		} catch (SQLException exception) {
			System.out.println(exception);
		}
	}
}