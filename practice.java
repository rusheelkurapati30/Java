import java.io.*;
import java.util.*;

class read
{
	public static void main(String args[])
	{
		try
		{
			File file = new File("databaseName.cfg");
			Scanner sc = new Scanner(file);
			String dbName;
			dbName = sc.next();
			System.out.println(dbName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}