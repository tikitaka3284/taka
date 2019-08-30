import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
public class Quiz10{

public static void main(String[] args) throws FileNotFoundException{

		// Test cases
		readWrite("test1.txt", "out1.txt");
    readWrite("test2.txt", "out2.txt");


}
public static void readWrite(String srcfileName, String dstfileName) throws FileNotFoundException {

    File myfile = new File("srcfileName");
    if(!myfile.exists())
    {
      System.out.println("File"+ srcfileName + " not found");
    }
    Scanner in = new Scanner(myfile);
    PrintWriter out = new PrintWriter(new File(dstfileName));
    double sum=0;
    while(in.hasNext()){
      String line = in.nextLine();
      double d = Double.parseDouble(line);
      sum = sum+d;
      out.println(line);

    }
    out.println("Sum is:"+ sum);
    in.close();
    out.close();



	}
}
