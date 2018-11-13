package Brd3;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilesR 
{
	public static void main(String[] args) throws IOException, SQLException 
	{
		BufferedReader b = null;
		FileReader f = null;
		FileValidation valid=new FileValidation();
		try {
			f = new FileReader(
					"C:\\Users\\siva\\git\\repository\\Installment\\BusinessReqDoc1\\src\\Brd3\\files\\File1.txt");
			b = new BufferedReader(f);
			int j = 0,validrecordnumber=0;
			ArrayList<Character> statusDomain = new ArrayList<Character>();
			ArrayList<Character> flagDomain = new ArrayList<Character>();
			statusDomain.add('N');	statusDomain.add('M');	statusDomain.add('D');	statusDomain.add('A');	statusDomain.add('R');
			flagDomain.add('A');	flagDomain.add('I');
			String st;
			while ((st = b.readLine()) != null) {j++;}
			int custid[] = new int[j];
			String[] record=new String[16];
			for(int lc=0;lc<j;lc++)
			 {
				
				String lineno = Files.readAllLines(Paths.get(
						"C:\\Users\\siva\\git\\repository\\Installment\\BusinessReqDoc1\\src\\Brd3\\files\\File1.txt"))
						.get(lc);
		//		System.out.println(lineno);
				lineno+='~';
				char characters[] = lineno.toCharArray();
				String field="";
				int recordcount=0;
				for (int ctr = 0; ctr < characters.length; ctr++)
					{
					  if(characters[ctr]=='~')
					 {
		//		    System.out.println(characters[ctr]);
					  if(field=="")
					  {
					   record[recordcount++]="";
					   }
					  else
					  {
					  record[recordcount++]=field;
					  field="";
					  }
					 }
					 else
					 {
						 field+=characters[ctr];
						
					 }
					}
				byte validcount=0;
				if(valid.isNumeric(record[4]))  validcount++;	
				if(valid.isNumeric(record[6]))  validcount++;
			    if(valid.DataLength(record[4],(byte)6))  validcount++;	
				
				if(valid.EmailValidation(record[5]))  validcount++;
				
				if(valid.CustomerNameValidation(record[1]))  validcount++;
				
				if(valid.DomainValue(record[8].charAt(0),statusDomain))  validcount++;
				
				if(valid.DomainValue(record[9].charAt(0),flagDomain))  validcount++;
				
				if(valid.Mandatory(record))  validcount++;
				
				if(validcount==8) 
				{ 
					validrecordnumber++;
			//		for(String temp:record)System.out.println(temp);
					
					dbinsert.insertdb(validrecordnumber,record);
		
				}
			 }
			
	     } catch (FileNotFoundException e) {

		e.printStackTrace();
	}

}

}