//1
import java.io.*;
import java.net.*;

class server
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Setup server...");
			ServerSocket ss = new ServerSocket(4502);
			System.out.println("\nSocket Created");
			Socket s = ss.accept();

			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String msgIn = "", msgOut = "";

			while(!msgIn.equals("end"))
			{
				msgIn = in.readUTF();
				System.out.println("Client > " + msgIn);
				msgOut = br.readLine();
				out.writeUTF(msgOut);
				out.flush();
			}
			s.close();
		}
		catch(Exception e)
		{

		}
	}
}






//2
// import java.io.*;
// import java.net.*;


// class server2
// {
// 	public static void main(String[] args) throws Exception
// 	{
// 		ServerSocket ss = new ServerSocket(1234);
// 		Socket s = ss.accept();
// 		System.out.println("Connection established");

// 		PrintStream ps = new PrintStream(s.getOutputStream());

// 		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

// 		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

// 		while(true)
// 		{
// 			String msgIn = "", msgOut = "";

// 			while((msgIn = br.readLine()) != null)
// 			{
// 				System.out.println("Client > " + msgIn);
// 				msgOut = kb.readLine();
// 				ps.println(msgOut);
// 			}
// 			ps.close();
// 			br.close();
// 			kb.close();
// 			ss.close();
// 			s.close();
// 			System.exit(0);
// 		}
// 	}
// }