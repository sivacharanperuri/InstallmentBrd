package Brd2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class DataV {

	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		Object objm;
//		String sp;
//		System.out.println("Enter the field:");
//		objm=sc.nextLine();
//		DataType(objm,"int");
//		System.out.println(DataLength(objm,(byte)15));
//		System.out.println("Enter the restricted special characters:");
//		sp=sc.nextLine();
//		System.out.println(ValidSpecialChar(objm,sp));
//		List<String> values = new ArrayList<String>();
/*		values.add("monday");
		values.add("tuesday");
		String s ="thursday";
		System.out.println(DomainValue(s,values));*/
		
//		System.out.println(EmailValidation("perurisivacharan@gmail.com"));
		

	}
	/*
	static boolean DataType(Object obj,String ds)
  	{  
		boolean b = false;
  	    
		
		return b;
	}*/
	static boolean DataLength(Object obj, byte length)
	{
		boolean b=false;
		if(((String) obj).length()<=length)
			b=true;
		System.out.println(obj);
		return b;
		
	}
	static boolean ValidSpecialChar(Object obj,String sp)

	{
		boolean b=true;
		byte l1,l2;
		l1=(byte)((String) obj).length();
		l2=(byte)sp.length();
		for(byte i=0;i<l1;i++)
			for(byte j=0;j<l2;j++)
				if(((String) obj).charAt(i)==sp.charAt(j))
					return false;
		return b;
	}
	static boolean DomainValue(Object obj, List<String> values)
	{
		boolean b=false;
		byte l1=(byte) values.size();
		for(byte i=0;i<l1;i++ )
			if(values.get(i)==obj) return true;
		return b;
	}
	static boolean FormatValidation()
	{
		boolean b=false;
		
		return b;
	}
	static boolean EmailValidation(String email)
{
	 
	return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
}
}
