import java.util.*;// import library
import java.io.*;
public class Lab10// class name
{

	public static void main (String[] args)throws FileNotFoundException{ //main method
		String sFileName = "unsorted.txt";//file name

		File myInFile = new File(sFileName); //access to the file
		if (!myInFile.exists()){ //boolean expression
			System.out.println("File"+ sFileName + " not found");
			return;
		}
		Scanner input = new Scanner(myInFile); //scan the file

		printFile(input);//print the void method

		input.close();//close the file

	}



	//-------
	public static void printFile(Scanner input)throws FileNotFoundException{ //
		
		String tmp ="";
		int count=0;
		String[] arr=new String[620];
		System.out.println("This is original:");
		int k=0;
		while(input.hasNext()){
			tmp=input.next();
			arr[k]=tmp;
			k++;
		}




		/*int k=0;
		while(input.hasNext()){
			tmp=input.next();
			arr[k]=tmp;
			k++;
		}
		*/
		String a="";
		for(int i=0; i<arr.length-1; i++)
		{
			for(int j=0; j<arr.length-1; j++)
			{
				if((arr[j].compareTo(arr[j+1]))>0)
				{
					a=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=a;
				}
			}

		}
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}

	}
}
