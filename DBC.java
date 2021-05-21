package programs_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBC
{

	public static void main(String[] args)
	{
		Connection ObCon = null;
		Statement ObStmt = null;
		ResultSet ObjRes = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			ObCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/msccs","root", "");
			ObStmt = ObCon.createStatement();
			String strQuery = "select * from java_t1";

			ObjRes = ObStmt.executeQuery(strQuery);

			while (ObjRes.next())
			{

				System.out.println("Reg No : " + ObjRes.getInt(1) + " Name : " + ObjRes.getString(2)+"   " + " Dept : "
						+ ObjRes.getString(3) + "  "+ " Branch : " + ObjRes.getString(4));

			}
			

		}
		catch (Exception e)
		{

			e.printStackTrace();
		}
		finally
		{
			try
			{
				ObjRes.close();
				ObStmt.close();
				ObCon.close();
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
			catch (NullPointerException ec)
			{
				ec.printStackTrace();	
		    }

	}
	}
}