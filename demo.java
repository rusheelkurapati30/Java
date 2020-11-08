// public and private differences.

class demo1
{
	public static void main(String[] args)
	{
		test1 obj1 = new test1();
		obj1.sayHi();
		obj1.sayHello();
		//test1.sayHi();
		test1.sayHello();
		//obj1.welcome();
	}
}
class test1
{
	public void sayHi()
	{
		System.out.println("Hi");
		welcome();
	}
	private void welcome()
	{
		System.out.println("Welcome");
	}
	public static void sayHello()
	{
		System.out.println("Hello");
	}
}


































































