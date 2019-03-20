package pl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DemoJDBC1 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Class.forName("org.h2.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","sa");
		Statement stament=con.createStatement();
		ResultSet result=stament.executeQuery("Select * from PRODUCT");
		ResultSetMetaData rsmd=result.getMetaData();
		int colCount=rsmd.getColumnCount();
		for(int count=1;count<=colCount;count++)
		{
			System.out.print(rsmd.getColumnName(count)+"\t");
		}
		System.out.println();
		
		while(result.next())
		{
			System.out.print(result.getInt(1)+"\t");
			System.out.print(result.getString(2)+"\t");
			System.out.print(result.getInt(3)+"\n");
		
	

	}
		stament.close();
		con.close();
	}


	}


