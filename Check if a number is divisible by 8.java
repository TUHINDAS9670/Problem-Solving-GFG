// Java program to find if a number is 
// divisible by 8 or not 
import java.io.*; 
class IsDivisible 
{ 
	// Function to find that number divisible by 
	// 8 or not 
	static boolean check(String str) 
	{ 
		int n = str.length(); 
	
		// Empty string 
		if (n == 0) 
			return false; 
	
		// If there is single digit 
		if (n == 1) 
			return ((str.charAt(0)-'0')%8 == 0); 
	
		// If there is double digit 
		if (n == 2) 
			return (((str.charAt(n-2)-'0')*10 + (str.charAt(n-1)-'0'))%8 == 0); 
	
		// If number formed by last three digits is 
		// divisible by 8. 
		int last = str.charAt(n-1) - '0'; 
		int second_last = str.charAt(n-2) - '0'; 
		int third_last = str.charAt(n-3) - '0'; 
	
		return ((third_last*100 + second_last*10 + last) % 8 == 0); 
	} 
	
	// main function 
	public static void main (String[] args) 
	{ 
		String str = "76952"; 
		if(check(str)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 
