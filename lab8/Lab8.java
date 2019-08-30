
import java.util.Scanner;
public class Lab8
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);

    String str1;
    String str2;
    System.out.print("Input first number: ");
    str1=in.next();
    System.out.print("Input second number: ");
    str2=in.next();
    System.out.println("The number added is:");
    String print1=reverse(str1);
    String print2=reverse(str2);
    /*tring sub1;
    String sub2;
    for(int i=0; i<str1.length(); i++)
    {
      sub1=print1.charAt(i);
      if(i%3==0)
      sub1=","+sub1;

    }
    System.out.print(sub1);
    for(int k=0; k<str2.length(); k++)
    {
      sub2=print2.charAt(k);
      if(k%3==0)
      sub2=","+sub2;
    }
    System.out.print(sub2);
    {

    }*/

    System.out.println(str1+"  +  ");
    System.out.println(str2);
    System.out.println("-------------------");
    System.out.println(findSum(str1, str2));


  }
  public static String reverse(String str)
  {
    String reverse = "";


		for(int i = str.length() - 1; i >= 0; i--)
		{
			reverse = reverse + str.charAt(i);
		}
    return reverse;
  }
  public static String findSum(String str1, String str2)
  {
      // Before proceeding further, make sure length
      // of str2 is larger.
      if (str1.length() > str2.length()){
          String t = str1;
          str1 = str2;
          str2 = t;
      }


      // Take an empty String for storing result
      String str = "";

      // Calculate length of both String
      int n1 = str1.length(), n2 = str2.length();

      // Reverse both of Strings
      String rev1=reverse(str1);
      String rev2=reverse(str2);
      int carry = 0;
      for (int i = 0; i < n1; i++)
      {
          // Do school mathematics, compute sum of
          // current digits and carry
          int sum = ((int)(rev2.charAt(i) - '0') +
                      (int)(rev1.charAt(i) - '0') + carry);
          str += (char)(sum % 10 + '0');

          // Calculate carry for next step
          carry = sum / 10;
      }

      // Add remaining digits of larger number
      for (int i = n1; i < n2; i++)
      {
          int sum = ((int)(rev2.charAt(i) - '0') + carry);
          str += (char)(sum % 10 + '0');
          carry = sum / 10;
      }

      // Add remaining carry
      if (carry > 0)
          str += (char)(carry + '0');

      // reverse resultant String


      return reverse(str);
    }
}
