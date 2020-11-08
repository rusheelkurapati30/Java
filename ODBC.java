// Java program to perform CRUD operations using ODBC Connectivity.
import java.sql.*;
import java.io.*;
import java.util.Scanner;
import java.lang.*;
import ODBC_PACKAGE.dbMySql;
import ODBC_PACKAGE.dbSqlite;

class ODBC
{
	public static void main(String args[])
	{
		try
		{
			File myObj = new File("databaseName.cfg");
			Scanner myReader = new Scanner(myObj);
			String className = myReader.next();
			myReader.close();
			iDB obj = (iDB)Class.forName(className).newInstance();
			while(true)
			{
				System.out.println("\n--------------Big Bazar Item Details--------------");
				System.out.println("\nPlease choose: \n1. Add New item\n2. Show all items\n3. Update an item\n4. Delete an item\n5. Search an item\n6. exit\n");
				System.out.println("----------------------------------------------------");
				System.out.print("Enter your choice: ");
				Scanner sc = new Scanner(System.in);
				int choice = sc.nextInt();
				if(choice == 1)
				{
					obj.insert();
				}
				if(choice == 2)
				{
					obj.display();
				}
				if(choice == 3)
				{
					obj.update();
				}
				if(choice == 4)
				{
					obj.delete();
				}
				if(choice == 5)
				{
					obj.search();
				}
				if(choice == 6)
				{
					obj.exit();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}




