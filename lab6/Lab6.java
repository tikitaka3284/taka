import java.util.Scanner;// set for scanner
public class Lab6 //class name
{
  public static void main(String[]args)//main
  {
    int num;//for key
    String message="cpsc1150 ? Is my course!";//String of message
    int numOfstring=0;//amount of string
    String temp="";// temporary string for the binary

    Scanner in = new Scanner(System.in);// scanner
    System.out.println("message:"+message);//print message

    System.out.print("Enter the integer number:");
    num = in.nextInt();// input for key number

    System.out.println("Key:"+num);

    for(int i=0; i<message.length(); i++)//to get the binary of message
    {
      numOfstring = (int)message.charAt(i)+num;
      temp=temp+ascii2binary(numOfstring);//add the binary in a row.

    }
    System.out.println(temp);//print binary

    for(int i=0; i<message.length(); i++)//for-loop  for printing the message as every each line
    {
      System.out.println(message.charAt(i));//print each character
    }




  }
  public static String ascii2binary(int n)// method for acii to binary
  {

    String binary="";//set string of binary
    binary = Integer.toBinaryString(n);
    if(binary.length()<8)//if the length of binary is less than 8bits add"0"
    {
      while(binary.length()!=8)
      {
        binary="0"+binary;
      }
    }

    return binary;//return


  }

}
