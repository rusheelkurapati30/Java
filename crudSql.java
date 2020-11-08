//Java program to perform CRUD operations using JDBC Connectivity(SQLite).

import java.sql.*;
import java.io.*;
import java.util.Scanner;
import java.lang.*;

// class jdbcConnection
// {
// 	public static Connection connect()
// 	{
// 		Connection con = null;
// 		try
// 		{
// 			String url = "jdbc:mysql://165.22.14.77/dbRusheel?useSSL=false";	
// 			String user="rusheel";
// 			String password = "rusheel";
// 			Class.forName("com.mysql.jdbc.Driver");
// 			con = DriverManager.getConnection(url, user, password);
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}
// 		return con;
// 	}
// }

class jdbcConnection
{
	public static Connection connect()
	{
		Connection con = null;
		try
		{
			String url = "jdbc:sqlite:D:\\Training\\sqlite\\dbRusheel1.db";
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}

class crud
{
	Connection con;
	public crud()
	{
		con = jdbcConnection.connect();
	}

	public void insert()
	{
		try
		{
			while(true)
			{
				String query = "INSERT INTO  Item VALUES(?,?,?,?,?,?)";
				PreparedStatement ps = prepareStatement(query);
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter Status: ");
				ps.setString(1, sc.next());
				System.out.print("Enter Item ID: ");
				ps.setString(2, sc.next());
				System.out.print("Enter Item Description: ");
				ps.setString(3, sc.next());
				System.out.print("Enter Unit Price: ");
				ps.setFloat(4, sc.nextFloat());
				System.out.print("Enter Stock Quantity: ");
				ps.setInt(5, sc.nextInt());
				System.out.print("Enter Supplier ID: ");
				ps.setString(6, sc.next());
				ps.executeUpdate();
				ps.close();
				System.out.print("Do you want to continue? [Y/N]");
				char choice = sc.next().charAt(0);
				char check = Character.toUpperCase(choice);
				if(check != 'Y')
				{
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public void display()
	{
		try
		{
			int recordFound = 0;
			String query = "select * from Item where Status = 'Active'";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				recordFound++;
				printColumnNames(recordFound);
				String Item_ID = rs.getString("Item_ID");
				String Item_Description = rs.getString("Item_Description");
				int Unit_Price = rs.getInt("Unit_Price");
				int Stock_Quantity = rs.getInt("Stock_Quantity");
				String Supplier_ID = rs.getString("Supplier_ID");
				System.out.println(Item_ID + "\t " + Item_Description + " \t\t\t   " + Unit_Price + " \t\t " + Stock_Quantity + " \t\t" + Supplier_ID);
			}
			ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	


	public void update()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Item ID to update: ");
			String Item_ID = sc.next(); 
			System.out.println("\n1. To Update Item Description");
			System.out.println("2. To Update Unit Price");
			System.out.println("3. To Update Stock Quantity");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			if(choice == 1)
			{
				String query = "UPDATE Item SET Item_Description = ? WHERE Item_ID = ? and Status = 'Active'";
				PreparedStatement ps = con.prepareStatement(query);
				System.out.print("\nEnter Item Description: ");
				ps.setString(1, sc.next());
				ps.setString(2, Item_ID);
				ps.executeUpdate();
				ps.close();
			}
			if(choice == 2)
			{
				String query = "UPDATE Item SET Unit_Price = ? WHERE Item_ID = ? and Status = 'Active'";
				PreparedStatement ps = con.prepareStatement(query);
				System.out.print("\nEnter Unit Price: ");
				ps.setFloat(1, sc.nextFloat());
				ps.setString(2, Item_ID);
				ps.executeUpdate();
				ps.close();
			}
			if(choice == 3)
			{
				String query = "UPDATE Item SET Stock_Quantity = ? WHERE Item_ID = ? and Status = 'Active'";
				PreparedStatement ps = con.prepareStatement(query);
				System.out.print("\nEnter Stock Quantity: ");
				ps.setInt(1, sc.nextInt());
				ps.setString(2, Item_ID);
				ps.executeUpdate();
				ps.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}		

	public void search()
	{
		try
		{
			int recordFound = 0;
			String query = "select * from Item where Status = 'Active' and Item_ID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			Scanner sc = new Scanner(System.in);
			System.out.print("\nEnter Item ID to Search: ");
			ps.setString(1, sc.next());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				recordFound++;
				printColumnNames(recordFound);
				String Item_ID = rs.getString("Item_ID");
				String Item_Description = rs.getString("Item_Description");
				int Unit_Price = rs.getInt("Unit_Price");
				int Stock_Quantity = rs.getInt("Stock_Quantity");
				String Supplier_ID = rs.getString("Supplier_ID");
				System.out.println(Item_ID + " \t\t" + Item_Description + "\t\t " + Unit_Price + " \t\t" + Stock_Quantity + " \t\t" + Supplier_ID);
			}
			ps.close();
			if(recordFound == 0)
			{
				System.out.println("No record found");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void printColumnNames(int recordFound)
	{
		if(recordFound == 1)
		{
			System.out.println("Item_ID\t\tItem_Description\t\tUnit_Price\tStock_Quantity\tSupplier_ID\n");
		}
	}

	public void delete()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Item ID to Delete: ");
		String Item_ID = sc.next(); 
		try
		{
			String query = "UPDATE Item SET Status = 'Inactive' WHERE Item_ID = ? and Status = 'Active'";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Item_ID);
			ps.executeUpdate();
			ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void exit()
	{
		try
		{
			con.close();
			System.exit(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		crud obj = new crud();
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
}





















































// //Java program to perform CRUD operations using JDBC Connectivity(Mysql).

// import java.sql.*;
// import java.io.*;
// import java.util.Scanner;
// import java.lang.*;

// class jdbcConnection
// {
// 	public static Connection connect()
// 	{
// 		Connection con = null;
// 		try
// 		{
// 			String url = "jdbc:mysql://165.22.14.77/dbRusheel?useSSL=false";
// 			String user="rusheel";
// 			String password = "rusheel";
// 			Class.forName("com.mysql.jdbc.Driver");
// 			con = DriverManager.getConnection(url, user, password);
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}
// 		return con;
// 	}
// }
// class crud
// {
// 	public static void insert()
// 	{
// 		try
// 		{
// 			Connection con = jdbcConnection.connect();
// 			while(true)
// 			{
// 				String query = "INSERT INTO  Item VALUES(?,?,?,?,?,?)";
// 				PreparedStatement ps = con.prepareStatement(query);
// 				Scanner sc = new Scanner(System.in);
// 				System.out.print("Enter Status: ");
// 				ps.setString(1, sc.next());
// 				System.out.print("Enter Item ID: ");
// 				ps.setString(2, sc.next());
// 				System.out.print("Enter Item Description: ");
// 				ps.setString(3, sc.next());
// 				System.out.print("Enter Unit Price: ");
// 				ps.setFloat(4, sc.nextFloat());
// 				System.out.print("Enter Stock Quantity: ");
// 				ps.setInt(5, sc.nextInt());
// 				System.out.print("Enter Supplier ID: ");
// 				ps.setString(6, sc.next());
// 				ps.executeUpdate();
// 				ps.close();
// 				System.out.print("Do you want to continue? [Y/N]");
// 				char choice = sc.next().charAt(0);
// 				char check = Character.toUpperCase(choice);
// 				if(check != 'Y')
// 				{
// 					break;
// 				}
// 			}
// 			// con.close();
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}
// 	}


// 	public static void display()
// 	{
// 		try
// 		{
// 			Connection con =jdbcConnection.connect();
// 			String query = "select * from Item where Status = 'Active'";
// 			PreparedStatement ps = con.prepareStatement(query);
// 			ResultSet rs = ps.executeQuery();
// 			System.out.println("Item_ID\tItem_Description\t\tUnit_Price\t\tStock_Quantity\t\tSupplier_ID\n");
// 			while(rs.next())
// 			{
// 				// String Status = rs.getString("Status");
// 				String Item_ID = rs.getString("Item_ID");
// 				String Item_Description = rs.getString("Item_Description");
// 				int Unit_Price = rs.getInt("Unit_Price");
// 				int Stock_Quantity = rs.getInt("Stock_Quantity");
// 				String Supplier_ID = rs.getString("Supplier_ID");
// 				System.out.println(Item_ID + "\t " + Item_Description + " \t\t\t   " + Unit_Price + " \t\t " + Stock_Quantity + " \t\t" + Supplier_ID);
// 			}
// 			ps.close();
// 			// con.close();
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}
// 	}	


// 	public static void update()
// 	{
// 		try
// 		{
// 			Connection conn = jdbcConnection.connect();
// 			Scanner sc = new Scanner(System.in);
// 			System.out.print("Enter Item ID to update: ");
// 			String Item_ID = sc.next(); 
// 			System.out.println("\n1. To Update Item Description");
// 			System.out.println("2. To Update Unit Price");
// 			System.out.println("3. To Update Stock Quantity");
// 			System.out.print("Enter your choice: ");
// 			int choice = sc.nextInt();
// 			if(choice == 1)
// 			{
// 				String query = "UPDATE Item SET Item_Description = ? WHERE Item_ID = ? and Status = 'Active'";
// 				PreparedStatement ps = con.prepareStatement(query);
// 				System.out.print("\nEnter Item Description: ");
// 				ps.setString(1, sc.next());
// 				ps.setString(2, Item_ID);
// 				ps.executeUpdate();
// 				ps.close();
// 			}
// 			if(choice == 2)
// 			{
// 				String query = "UPDATE Item SET Unit_Price = ? WHERE Item_ID = ? and Status = 'Active'";
// 				PreparedStatement ps = con.prepareStatement(query);
// 				System.out.print("\nEnter Unit Price: ");
// 				ps.setFloat(1, sc.nextFloat());
// 				ps.setString(2, Item_ID);
// 				ps.executeUpdate();
// 				ps.close();
// 			}
// 			if(choice == 3)
// 			{
// 				String query = "UPDATE Item SET Stock_Quantity = ? WHERE Item_ID = ? and Status = 'Active'";
// 				PreparedStatement ps = con.prepareStatement(query);
// 				System.out.print("\nEnter Stock Quantity: ");
// 				ps.setInt(1, sc.nextInt());
// 				ps.setString(2, Item_ID);
// 				ps.executeUpdate();
// 				ps.close();
// 			}
// 			// con.close();
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}
// 	}		

// 	public static void search()
// 	{
// 		try
// 		{
// 			Connection con = jdbcConnection.connect();
// 			String query = "select * from Item where Status = 'Active' and Item_ID = ?";
// 			PreparedStatement ps = con.prepareStatement(query);
// 			Scanner sc = new Scanner(System.in);
// 			System.out.print("\nEnter Item ID to Search: ");
// 			ps.setString(1, sc.next());
// 			ResultSet rs = ps.executeQuery();
// 			System.out.println("Item_ID\t\tItem_Description\t\tUnit_Price\tStock_Quantity\tSupplier_ID\n");
// 			while(rs.next())
// 			{
// 				// String Status = rs.getString("Status");
// 				String Item_ID = rs.getString("Item_ID");
// 				String Item_Description = rs.getString("Item_Description");
// 				int Unit_Price = rs.getInt("Unit_Price");
// 				int Stock_Quantity = rs.getInt("Stock_Quantity");
// 				String Supplier_ID = rs.getString("Supplier_ID");
// 				System.out.println(Item_ID + " \t\t" + Item_Description + "\t\t " + Unit_Price + " \t\t" + Stock_Quantity + " \t\t" + Supplier_ID);
// 			}
// 			ps.close();
// 			// con.close();
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}
// 	}

// 	public static void delete()
// 	{
// 		try
// 		{
// 			Connection con = jdbcConnection.connect();
// 			Scanner sc = new Scanner(System.in);
// 			System.out.println("Connection established");
// 			System.out.print("Enter Item ID to Delete: ");
// 			String Item_ID = sc.next(); 
// 			String query = "UPDATE Item SET Status = 'Inactive' WHERE Item_ID = ? and Status = 'Active'";
// 			PreparedStatement ps = con.prepareStatement(query);
// 			ps.setString(1, Item_ID);
// 			ps.executeUpdate();
// 			ps.close();
// 			// con.close();
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}
// 	}

// 	public static void exit()
// 	{
// 		try
// 		{
// 			Connection con = jdbcConnection.connect();
// 			con.close();
// 			System.exit(0);
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}
// 	}

// 	public static void main(String[] args)
// 	{
// 		while(true)
// 		{
// 			System.out.println("\n--------------Big Bazar Item Details--------------");
// 			System.out.println("\nPlease choose: \n1. Add New item\n2. Show all items\n3. Update an item\n4. Delete an item\n5. Search an item\n6. exit\n");
// 			System.out.println("----------------------------------------------------");
// 			System.out.print("Enter your choice: ");
// 			Scanner sc = new Scanner(System.in);
// 			int choice = sc.nextInt();
// 			if(choice == 1)
// 			{
// 				insert();
// 			}
// 			if(choice == 2)
// 			{
// 				display();
// 			}
// 			if(choice == 3)
// 			{
// 				update();
// 			}
// 			if(choice == 4)
// 			{
// 				delete();
// 			}
// 			if(choice == 5)
// 			{
// 				search();
// 			}
// 			if(choice == 6)
// 			{
// 				exit();
// 			}
// 		}
// 	}	
// }





















































// //INSERT
// import java.sql.*;
// import java.io.*;
// import java.util.Scanner;
// import java.lang.*;

// class crud
// {
// 	public static void main(String[] args)
// 	{
// 		try
// 		{
// 			String url = "jdbc:mysql://165.22.14.77/dbRusheel?useSSL=false";
// 			String user="rusheel";
// 			String password = "rusheel";
// 			Class.forName("com.mysql.jdbc.Driver");
// 			Connection con = DriverManager.getConnection(url, user, password);
// 			System.out.println("Connection established");
// 			String query = "INSERT INTO  Item VALUES(?,?,?,?,?,?)";
// 			// PreparedStatement ps = con.ps(query);
// 			PreparedStatement ps = con.prepareStatement(query);
// 			Scanner sc = new Scanner(System.in);
// 			System.out.print("Enter Status: ");
// 			ps.setString(1, sc.next());
// 			System.out.print("Enter Item ID: ");
// 			ps.setString(2, sc.next());
// 			// sc.flush();
// 			System.out.print("Enter Item Description: ");
// 			ps.setString(3, sc.nextLine());
// 			System.out.print("Enter Unit Price: ");
// 			ps.setFloat(4, sc.nextFloat());
// 			System.out.print("Enter Stock Quantity: ");
// 			ps.setInt(5, sc.nextInt());
// 			System.out.print("Enter Supplier ID: ");
// 			ps.setString(6, sc.next());
// 			ps.executeUpdate();
// 			ps.close();
// 			con.close();
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}
// 	}		
// }




// //Update
// import java.sql.*;
// import java.io.*;
// import java.util.Scanner;
// import java.lang.*;

// class crud
// {
// 	public static void main(String[] args)
// 	{
// 		try
// 		{
// 			String url = "jdbc:mysql://165.22.14.77/dbRusheel?useSSL=false";
// 			String user="rusheel";
// 			String password = "rusheel";
// 			Class.forName("com.mysql.jdbc.Driver");
// 			Connection con = DriverManager.getConnection(url, user, password);
// 			Scanner sc = new Scanner(System.in);
// 			System.out.println("Connection established");
// 			System.out.print("Enter Item ID to update: ");
// 			String Item_ID = sc.next(); 
// 			System.out.println("\n1. To Update Item Description");
// 			System.out.println("2. To Update Unit Price");
// 			System.out.println("3. To Update Stock Quantity");
// 			System.out.print("Enter your choice: ");
// 			int choice = sc.nextInt();
// 			if(choice == 1)
// 			{
// 				String query = "UPDATE Item SET Item_Description = ? WHERE Item_ID = ? and Status = 'Active'";
// 				PreparedStatement ps = con.prepareStatement(query);
// 				System.out.print("\nEnter Item Description: ");
// 				ps.setString(1, sc.next());
// 				ps.setString(2, Item_ID);
// 				ps.executeUpdate();
// 				ps.close();
// 			}
// 			if(choice == 2)
// 			{
// 				String query = "UPDATE Item SET Unit_Price = ? WHERE Item_ID = ? and Status = 'Active'";
// 				PreparedStatement ps = con.prepareStatement(query);
// 				System.out.print("\nEnter Unit Price: ");
// 				ps.setFloat(1, sc.nextFloat());
// 				ps.setString(2, Item_ID);
// 				ps.executeUpdate();
// 				ps.close();
// 			}
// 			if(choice == 3)
// 			{
// 				String query = "UPDATE Item SET Stock_Quantity = ? WHERE Item_ID = ? and Status = 'Active'";
// 				PreparedStatement ps = con.prepareStatement(query);
// 				System.out.print("\nEnter Stock Quantity: ");
// 				ps.setInt(1, sc.nextInt());
// 				ps.setString(2, Item_ID);
// 				ps.executeUpdate();
// 				ps.close();
// 			}
// 			con.close();
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}
// 	}		
// }


//Search
// import java.sql.*;
// import java.io.*;
// import java.util.Scanner;
// import java.lang.*;

// class crud
// {
// 	public static void main(String[] args)
// 	{
// 		try
// 		{
// 			String url = "jdbc:mysql://165.22.14.77/dbRusheel?useSSL=false";
// 			String user="rusheel";
// 			String password = "rusheel";
// 			Class.forName("com.mysql.jdbc.Driver");
// 			Connection con = DriverManager.getConnection(url, user, password);
// 			System.out.println("Connection established");
// 			Scanner sc = new Scanner(System.in);
// 			String query = "select * from Item where Status = 'Active' and Item_ID = ?";
// 			PreparedStatement ps = con.prepareStatement(query);
// 			System.out.print("\nEnter Item ID to Search: ");
// 			ps.setString(1, sc.next());
// 			ResultSet rs = ps.executeQuery();
// 			while(rs.next())
// 			{
// 				String Status = rs.getString("Status");
// 				String Item_ID = rs.getString("Item_ID");
// 				String Item_Description = rs.getString("Item_Description");
// 				int Unit_Price = rs.getInt("Unit_Price");
// 				int Stock_Quantity = rs.getInt("Stock_Quantity");
// 				String Supplier_ID = rs.getString("Supplier_ID");
// 				System.out.println(Status + " " + Item_ID + " " + Item_Description + " " + Unit_Price + " " + Stock_Quantity + " " + Supplier_ID);
// 			}
// 			ps.close();
// 			con.close();
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}
// 	}		
// }



//Delete
// import java.sql.*;
// import java.io.*;
// import java.util.Scanner;
// import java.lang.*;

// class crud
// {
// 	public static void main(String[] args)
// 	{
// 		try
// 		{
// 			String url = "jdbc:mysql://165.22.14.77/dbRusheel?useSSL=false";
// 			String user="rusheel";
// 			String password = "rusheel";
// 			Class.forName("com.mysql.jdbc.Driver");
// 			Connection con = DriverManager.getConnection(url, user, password);
// 			Scanner sc = new Scanner(System.in);
// 			System.out.println("Connection established");
// 			System.out.print("Enter Item ID to Delete: ");
// 			String Item_ID = sc.next(); 
// 			String query = "UPDATE Item SET Status = 'Inactive' WHERE Item_ID = ? and Status = 'Active'";
// 			PreparedStatement ps = con.prepareStatement(query);
// 			ps.setString(1, Item_ID);
// 			ps.executeUpdate();
// 			ps.close();
// 			con.close();
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}
// 	}		
// }































// import java.sql.*;
// import java.io.*;
// import java.util.Scanner;
// import java.lang.*;

// public class crud
// {
// 	String url = "jdbc:mysql://165.22.14.77/dbRusheel?useSSL=false";
// 	String user="rusheel";
// 	String password = "rusheel";
		
// 	public static void insert()
// 	{
		
// 		System.out.println("hi");
// 	}
// 	public static void display()
// 	{
		
// 		Connection con = DriverManager.getConnection(url, user, password);
// 		String query = "select * from Items";
// 		Statement st = con.createStatement();
// 		ResultSet rs = st.executeQuery(query);
// 		// st.executeQuery(query);
// 		while(rs.next())
// 		{
// 			String Item_ID = rs.getString("Item_ID");
// 			String Item_Description = rs.getString("Item_Description");
// 			int Unit_Price = rs.getInt("Unit_Price");
// 			int Stock_Quantity = rs.getInt("Stock_Quantity");
// 			String Supplier_ID = rs.getString("Supplier_ID");
// 			System.out.println(Item_ID + " " + Item_Description + " " + Unit_Price + " " + Stock_Quantity + " " + Supplier_ID);
// 		}
// 		System.out.println("Created Platform");
// 		System.out.println("executed query");
// 		st.close();
// 		// con.close();
// 		System.out.println("Closed Connection");
// 			// System.out.println("display");
// 		}
	




// 	public static void main(String[] args)
// 	{
// 		try
// 		{
// 			Class.forName("com.mysql.jdbc.Driver");
// 			Connection con = DriverManager.getConnection(url, user, password);
// 			System.out.println("Connection established");
// 		}
// 		catch(Exception e)
// 		{
// 			e.printStackTrace();
// 		}

// 		while(true)
// 		{
// 			System.out.println("\n--------------Big Bazar Item Details--------------");
// 			System.out.println("\nPlease choose: \n1. Add New item\n2. Show all items\n3. Update an item\n4. Delete an item\n5. Search an item\n6. exit\n");
// 			System.out.println("----------------------------------------------------");
// 			System.out.print("Enter your choice: ");
// 			Scanner sc = new Scanner(System.in);
// 			int choice = sc.nextInt();
// 			if(choice == 1)
// 			{
// 				insert();
// 			}
// 			if(choice == 2)
// 			{
// 				display();
// 			}
// 			// if(choice == 3)
// 			// {
// 			// 	update();
// 			// }
// 			// if(choice == 4)
// 			// {
// 			// 	delete();
// 			// }
// 			// if(choice == 5)
// 			// {
// 			// 	search();
// 			// }
// 			if(choice == 6)
// 			{
// 				System.exit(0);
// 			}
// 		}
// 	}	
// }

















