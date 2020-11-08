
import java.io.*;
import java.net.*;
import java.util.Scanner; 

class client
{
	// String msgIn, msgOut;
	public static void main(String[] args)
	{
		// boolean condition = true;
		Scanner scn = new Scanner(System.in);
		try
		{
			System.out.println("\nClient Server...");
			Socket s = new Socket("127.0.0.1", 4502);
			// Socket s = new Socket("192.168.0.125", 1234);
			// socket s = ss.accept();
			System.out.println("Connected...\n");
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			DataInputStream in = new DataInputStream(s.getInputStream());

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String msgIn = "", msgOut = "";
			// String msgIn, msgOut;

			// System.out.println("Enter your name: ");
			// String clientName = scn.nextLine();
			// out.writeUTF(clientName);
			// out.flush();
			// msgIn = in.readUTF();
   //          System.out.println(msgIn);
		 	//System.out.println("Server > " + msgIn);
			// while(true)
			while(!msgIn.equals("end"))
			{
				msgIn = in.readUTF();
				System.out.println("Server > " + msgIn);
				msgOut = br.readLine();
				out.writeUTF(msgOut);
				out.flush();
			}
			// 	// System.out.println("type: ");
			// 	// clientName = scn.nextLine();
			// 	// out.writeUTF(clientName);
			// 	// out.flush();
			// }
			// s.close();
		}
		catch(Exception e)
		{
			
		}
	}
}













// //2

// import java.io.*;
// import java.net.*;

// class client2
// {
// 	public static void main(String[] args) throws Exception
// 	{
// 		Socket s = new Socket("localhost", 1234);

// 		DataOutputStream out = new DataOutputStream(s.getOutputStream());

// 		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

// 		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

// 		String msgIn = "", msgOut = "";

// 		while(!(msgOut = kb.readLine()).equals("exit"))
// 		{
// 		 	out.writeBytes(msgOut + "\n");

// 		 	msgIn = br.readLine();
// 		 	System.out.println("Server > " + msgIn);
// 		}
// 		out.close();
// 		kb.close();
// 		br.close();
// 		s.close();
// 	}
// }




//3
/*import java.io.*;
import java.net.*;
import java.util.Scanner;

class client
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println("\nClient Server...");
			Socket s = new Socket("127.0.0.1", 7412);
			// socket s = ss.accept();
			System.out.println("Connected...\n");
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String msgIn = "", msgOut = "";
			// System.out.println("Enter your name: ");
			// msgOut = br.readLine();
			// out.writeUTF(msgOut);
			// msgIn = in.readUTF();
			// // out.writeUTF(msgOut);
			// System.out.println(msgOut + " has been joined...");
			// boolean condition = true;
			// while(condition == true)
			// {
				 Scanner scan = new Scanner(System.in);
         while(true)
         {
               System.out.println("Type your message:");
               String message = scan.nextLine();
               out.writeUTF("Rusheel: " + message);
               System.out.println("Server says " + in.readUTF());
             }


             catch(Exception e)
             {
               System.out.println("Exception occured.");
             }
         }
				// else
				// {
				// }
			// }
			// s.close();
		}
		catch(Exception e)
		{
			
		}
	}
}
*/




// import java.net.*;
// import java.io.*;
// import java.util.Scanner;
// import java.lang.*;

// class Client {
//       boolean condition = true;
//       DataInputStream in; 
//       public static void main(String [] args)
//        {
//       String serverName = args[0];
//       int port = Integer.parseInt(args[1]);
//       try 
//       {
//          System.out.println("Connecting to " + serverName + " on port " + port);
//          Socket client = new Socket(serverName, port);
         
//          System.out.println("Just connected to " + client.getRemoteSocketAddress());
//          OutputStream outToServer = client.getOutputStream();
//          DataOutputStream out = new DataOutputStream(outToServer);

//          InputStream inFromServer = client.getInputStream();
//          DataInputStream in = new DataInputStream(inFromServer);
//          // receiveMessages t1 = new receiveMessages();
//          Thread t1 = new Thread();
//          t1.start();
//          Scanner scan = new Scanner(System.in);
//          while(true)
//          {
//             try
//             {
//                System.out.println("Type your message:");
//                String message = scan.nextLine();
//                out.writeUTF("Rusheel: " + message);
//              }
//              catch(Exception e)
//              {
//                System.out.println("Exception occured.");
//              }
//          }
//         // System.out.println("Server says " + in.readUTF());
//          // client.close();
//       } catch (IOException e) {
//          e.printStackTrace();
//       }
//    }
//    public class receiveMessages extends Thread
//    {
//     public void run()
//     {
//       while(true)
//       {
//          try
//          {
//             System.out.println("Server says " + in.readUTF());
//          }
//          catch(IOException e)
//          {
//             System.out.println("Exception occured");
//          }
//       }
//     }
//    }
// }






























