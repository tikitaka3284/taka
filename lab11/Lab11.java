
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;
import java.io.IOException;
import java.lang.String;
public class Lab11
{
  public static void main(String[] args) throws IOException
  {
    convertToWord("telephone.txt", "result.txt");
  }
  public static void convertToWord(String phoneFile, String resultFile)throws IOException
  {
    //String numTable[10]={"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYS"};
    File myfile = new File(phoneFile);
    if(!myfile.exists())
    {
      System.out.println("File"+phoneFile+"not found");
      return;
    }
    Scanner in = new Scanner(myfile);
    PrintWriter out = new PrintWriter(new File(resultFile));

    while(in.hasNext())
    {
      String line = in.nextLine();
      String[] second= line.split("\\s+");
      int n=1;
      String tmp;
      for(String sec : second){
        if(n==2)
        System.out.println(second);

        n++;

      }

    }

    in.close();
    out.close();

  }

}
