public class Quiz9
{
  public static void main(String[] args)
  {
    System.out.println("Test cases (Part A)");
		String str= "and this another test for our quiz";
		System.out.println(countSymbol(str,'t'));
		System.out.println(countSymbol(str,' '));

		System.out.println("Test cases (Part B)");
		String strb1= "cpsc1150 quiz 9";
		String strb2= "112+38 = 150";
		System.out.println(sumOfDigits(strb1));
		System.out.println(sumOfDigits(strb2));


		System.out.println("Test cases (Part C)");
		String[] arr1 = {"this is a test", "another test", "and more"};
		System.out.println(countSymbol(arr1,'t'));
		System.out.println(countSymbol(arr1,' '));
    System.out.println(countSymbol(arr1,'v'));

    String[] arr2 = {"", "another test", " "};
		System.out.println(countSymbol(arr2,'o'));
		System.out.println(countSymbol(arr2,'r'));
    /*String str="This is a text";
    char x=' ';
    String str1="CPSC1150 sec 2";

    String[] arr={"this is a test", "this is another one","is this a quiz?"};
    char x1='r';
    System.out.println(countSymbol(str,x));
    System.out.println(sumOfDigits(str1));
    System.out.println(countSymbol(arr,x1));*/
  }
  public static int countSymbol(String str, char x)//method to count the specific symbol
  {
    int counter=0;
    for(int i=0; i<str.length(); i++)
    {
      if(str.charAt(i)==x)//if it matches to the char x, increment the counter
      counter++;

    }
    return counter;
  }
  public static int sumOfDigits(String str)//method to sum up the digits in the text
  {
    int findInt;
    int sum=0;
    for(int i=0; i<str.length(); i++)
    {
      findInt=(int)(str.charAt(i)-'0');
      if(findInt>0&&findInt<10)//if the number is between 1 to 9, store the number in sum
      sum=sum+findInt;

    }
    return sum;

  }
  public static int countSymbol(String[] arr, char x)
  {
    int sum=0;
    for(int i=0; i<arr.length; i++)
    {
      sum=sum+countSymbol(arr[i],x);//use the method of countSymbol(String str,char x)
    }
    return sum;

  }
}
