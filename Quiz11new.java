
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

public class Quiz11new
{
  public static void main(String[] args)throws IOException
  {
    readWrite("input.txt", "output1.txt", "Java", "JAVA");
    readWrite("input.txt", "output2.txt", " of ", " at ");

  }
  public static void readWrite(String srcFileName,String dstFileName,String oldStr,String newStr)throws IOException
  {
    File myfile=new File(srcFileName);
    if(!myfile.exists())
    {
      System.out.println("File"+ srcFileName + " not found");
    }
    Scanner in = new Scanner(myfile);
    PrintWriter out = new PrintWriter(new File(dstFileName));
    while(in.hasNext()){
      String line = in.nextLine();
      line=line.replaceAll(oldStr,newStr);
      out.println(line);
    }
    in.close();
    out.close();
  }

}
