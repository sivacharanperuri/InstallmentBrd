package Brd3.files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbinsert1 {

	public static Connection connectdb()
	{
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		return  connection;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public static void insert(customer c) throws SQLException
	{
		Connection con=connectdb();
		PreparedStatement ps=con.prepareStatement("insert into char_customer values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,c.getCUSTOMERID( ));  
		ps.setString(2,c.getCUSTOMERCODE ( ));  
		ps.setString(3,c.getCUSTOMERNAME ( ));  
		ps.setString(4,c.getCUSTOMERADDRESS1 (  ));  
		ps.setString(5,c.getCUSTOMERADDRESS2 (  ));  
		ps.setString(6,c.getCUSTOMERPINCODE (  ));  
		ps.setString(7,c.getEMAILADDRESS (  ));  
		ps.setString(8,c.getCONTACTNUMBER (  ));  
		ps.setString(9,c.getPRIMARYCONTACTPERSON (  ));  
		ps.setString(10,c.getRECORDSTATUS (  ));  
		ps.setString(11,c.getFLAG (  ));  
		ps.setString(12,c.getCREATEDATE ( ));  
		ps.setString(13,c.getCREATEDBY (  ));  
		ps.setString(14,c.getMODIFIEDDATE ( ));  
		ps.setString(15,c.getMODIFIEDBY ( ));  
		ps.setString(16,c.getAUTHORIZEDDATE ( ));  
		ps.setString(17,c.getAUTHORIZEDBY (  ));  
		int i=ps.executeUpdate();  
	}
}
