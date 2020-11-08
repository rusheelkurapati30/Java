import java.util.Scanner;

class hi extends Thread
{
	public void run(String name)
	{
		System.out.println(name);
		for(int i = 0; i < 5; i++)
		{
			System.out.println("Hi");
			try { Thread.sleep(1000); } catch(Exception e){}
		}
	}
}
class hello extends Thread
{
	public void run()
	{
		for(int i = 0; i < 5; i++)
		{
			System.out.println("Hello");
			try { Thread.sleep(1000); } catch(Exception e){}
		}	
	}
}
class threadDemo
{
	String name = "";
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		name = sc.nextLine();
		System.out.println(name);
		hi obj1 = new hi();
		hello obj2 = new hello();
		try
		{
			obj1.start(name);
			// obj1.join();
			// try { Thread.sleep(10); } catch(Exception e){}
			obj2.start();
			obj2.join();
		}
		catch(Exception e)
		{

		}
	}
}
