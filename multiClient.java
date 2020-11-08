// // Java implementation for multithreaded chat client 
// // Save file as Client.java 

// import java.io.*; 
// import java.net.*; 
// import java.util.Scanner; 

// class Client 
// { 
//   final static int ServerPort = 1234; 

//   public static void main(String args[]) throws UnknownHostException, IOException 
//   { 
//     Scanner scn = new Scanner(System.in); 
//      String serverName = args[0];
//       int port = Integer.parseInt(args[1]);
//       //try 
//       //{
//          System.out.println("Connecting to " + serverName + " on port " + port);
//          Socket s = new Socket(serverName, port);
         
//          System.out.println("Just connected to " + s.getRemoteSocketAddress());
//          // OutputStream outToServer = client.getOutputStream();
    
//     DataInputStream dis = new DataInputStream(s.getInputStream()); 
//     DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     BufferedReader kr = new BufferedReader(new InputStreamReader(System.in));
//     // sendMessage thread 
//     // String msg = "", msgIn = "", msgOut = "";
//     Thread sendMessage = new Thread()
//     {
//       public void run() { 
//         while (true) { 

//           // read the message to deliver. 
//           String msg = scn.nextLine(); 
                      
//                     try { 
//                         // write on the output stream 
//                         dos.writeUTF(msg); 
//                     } catch (IOException e) { 
//                         e.printStackTrace(); 
//                     } 
//         } 
//       } 
//     };
    
//     // readMessage thread 
//     Thread readMessage = new Thread()
//     { 
//       // @Override
//       public void run() { 

//         while (true) { 
//            try { 
//                         // read the message sent to this client 
//                         String msg = dis.readUTF(); 
//                         System.out.println(msg); 
//                     } catch (IOException e) { 
  
//                         e.printStackTrace(); 
//                     } 
//         } 
//       } 
//     }; 

//     sendMessage.start(); 
//     readMessage.start(); 

//   } 
// } 































import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.lang.*;

class Client {
      boolean condition = true;
      DataInputStream in; 
      public static void main(String [] args)
       {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      try 
      {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);

         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         // receiveMessages t1 = new receiveMessages();
         Thread t1 = new Thread();
         t1.start();
         Scanner scan = new Scanner(System.in);
         while(true)
         {
            try
            {
               System.out.println("Type your message:");
               String message = scan.nextLine();
               out.writeUTF("Rusheel: " + message);
             }
             catch(Exception e)
             {
               System.out.println("Exception occured.");
             }
         }
        // System.out.println("Server says " + in.readUTF());
         // client.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   public class receiveMessages extends Thread
   {
    public void run()
    {
      while(true)
      {
         try
         {
            System.out.println("Server says " + in.readUTF());
         }
         catch(IOException e)
         {
            System.out.println("Exception occured");
         }
      }
    }
   }
}







// import java.net.*;
// import java.io.*;
// import java.util.Scanner;
// import java.lang.*;

// class Client
// {
//   boolean condition = true;
//   static DataInputStream dis;
//   static  DataOutputStream dos;
//   // Scanner scn = new Scanner(System.in);
//   public static void main(String [] args)
//   {
//     // Scanner scn = new Scanner(System.in);
//     String serverName = args[0];
//     int port = Integer.parseInt(args[1]);
//     try 
//     {
//       System.out.println("Connecting to " + serverName + " on port " + port);
//       Socket client = new Socket(serverName, port);

//       System.out.println("Just connected to " + client.getRemoteSocketAddress());
//       OutputStream outToServer = client.getOutputStream();
//       // DataOutputStream dos = new DataOutputStream(outToServer);

//       // InputStream inFromServer = client.getInputStream();
//       // DataInputStream dis = new DataInputStream(inFromServer);
//       DataInputStream dis = new DataInputStream(client.getInputStream()); 
//       DataOutputStream dos = new DataOutputStream(client.getOutputStream()); 
//       // receiveMessages t1 = new receiveMessages();
//       Thread receiveMessages = new Thread();
//       Thread sendMessage = new Thread();
//       receiveMessages.start();
//       sendMessage.start();
//       // Runnable r = new Runnable1();
//       Thread t = new Thread();
//       t.start();
//       // Runnable r2 = new Runnable2();
//       Thread t2 = new Thread();
//       t2.start();
//       Scanner scn = new Scanner(System.in);
//     } 
//     catch (IOException e)
//     {
//        e.printStackTrace();
//     }
  

// class t extends Thread
// {
//   public void run()
//   {
//     while(true)
//     {
//       try
//       { 
//       // read the message to deliver. 
//       Scanner scn = new Scanner(System.in);
//       System.out.println("Type your message:");
//       String msg = scn.nextLine();
//         // write on the output stream 
//         dos.writeUTF(msg); 
//       }
//       catch(IOException e)
//       { 
//         e.printStackTrace(); 
//       } 
//     } 
//   } 
// }
// class t2 extends Thread
// {
//  public void run()
//  {
//   while (true)
//   {
//     try
//     {  
//        // read the message sent to this client 
//         String msg = dis.readUTF(); 
//         System.out.println(msg); 
//     }
//     catch (IOException e)
//     {
//       e.printStackTrace(); 
//      } 
//     }
//   } 
// }


// }

// }




























   //       while(true)
   //       {
   //          try
   //          {
   //             System.out.println("Type your message:");
   //             String message = scan.nextLine();
   //             out.writeUTF("Rusheel: " + message);
   //           }
   //           catch(Exception e)
   //           {
   //             System.out.println("Exception occured.");
   //           }
   //       }
   //      // System.out.println("Server says " + in.readUTF());
   //       // client.close();
   //    } catch (IOException e) {
   //       e.printStackTrace();
   //    }
   // }
   // public class receiveMessages extends Thread
   // {
   //  public void run()
   //  {
   //    while(true)
   //    {
   //       try
   //       {
   //          System.out.println("Server says " + in.readUTF());
   //       }
   //       catch(IOException e)
   //       {
   //          System.out.println("Exception occured");
   //       }
   //    }
   //  }
   // }
//     } catch (IOException e) {
//      e.printStackTrace();
//   }
// }