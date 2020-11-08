//Python server to Java client single server-single client 
// import java.io.*;
// import java.net.*;
// import java.util.Scanner; 

// class client
// {
// 	// String msgIn, msgOut;
// 	public static void main(String[] args)
// 	{
// 		Scanner scn = new Scanner(System.in);
// 		try
// 		{
// 			System.out.println("\nClient Server...");
// 			Socket s = new Socket("192.168.0.125", 5000);
// 			System.out.println("Connected...\n");
// 			DataInputStream in = new DataInputStream(s.getInputStream());
// 			DataOutputStream out = new DataOutputStream(s.getOutputStream());

// 			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// 			String msgIn = "", msgOut = "";
// 			while(true)
// 			{
// 				System.out.print("Client > ");
// 				msgOut = br.readLine();
// 				out.writeUTF(msgOut);
// 				msgIn = in.readUTF();
// 				System.out.println("Server > " + msgIn);
// 				out.flush();
// 			}
// 			// s.close();
// 		}
// 		catch(Exception e)
// 		{
			
// 		}
// 	}
// }



import java.io.*;
import java.net.*;
import java.util.Scanner; 


class client
{
	DataInputStream in;
	DataOutputStream out;
	// Socket s;
	static String clientName = "";
	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		String nameMsg = "";
		Scanner scn = new Scanner(System.in);
		System.out.println("\nClient Server...");
		Socket s = new Socket("192.168.0.125", 3233);
		System.out.println("Connected...\n");
		DataInputStream in = new DataInputStream(s.getInputStream());
		DataOutputStream out = new DataOutputStream(s.getOutputStream());

		System.out.print(">> Enter your name: ");
		clientName = scn.nextLine();
		System.out.println(clientName);
		out.writeUTF(clientName);
		String connected = in.readUTF();
		System.out.println(connected);
		// receive obj1 = new receive();
		// send obj2 = new send();

		// obj1.start();
		// obj2.start();
	}
}

class receive extends Thread
{
	public void run()
	{
		// Socket s = new Socket("192.168.0.125", 3233);
		// DataInputStream in = new DataInputStream(s.getInputStream());
		// DataOutputStream out = new DataOutputStream(s.getOutputStream());
		while(true)
		{
			// String message = in.readUTF();
			// System.out.println(message);	
		}

	}
}

// class send extends Thread
// {
// 	public void run()
// 	{
// 		// DataInputStream in = new DataInputStream(s.getInputStream());
// 		DataOutputStream out = new DataOutputStream(s.getOutputStream());
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		while(true)
// 		{
// 			// System.out.print("Client > ");
// 			String msgOut = br.readLine();
// 			out.writeUTF(msgOut);	
// 		}

// 	}
// }

