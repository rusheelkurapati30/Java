// package pkg1;
// public class two
// {
// 	public void anotherProg()
// 	{
// 		System.out.println("This message is from another file.");
// 	}
// }


// package myproject.package1;
// import com.utility.Utility;
 
// class StartPoint{ 
// 	public static void main(String[] args){ 
// 		Utility utilityObj=new Utility(); 
// 		utilityObj.method1(); 
// 	} 
// } 

import com.programiz.Helper;

class UseHelper {
    public static void main(String[] args) {

        double value = 99.5;
        String formattedValue = Helper.getFormattedDollar(value);
        System.out.println("formattedValue = " + formattedValue);
    }
}