public class Quiz7
{
  public static void main(String[] args)
  {
    int[] arr={3,5,2,4}; //integer in an arrray
    System.out.print("integers in the array: ");
    printArray(arr);
    System.out.println();
    System.out.println("average of integers: "+average(arr));//print average by using method
    System.out.println("minimum integer in the array: "+min(arr));//print minimum by using method

  }
  public static void printArray(int [] arr)
  {
    for(int i=0; i<arr.length;i++)
    {
      System.out.print(arr[i]+" ");
    }

  }
  public static double average(int [] arr)
  {
    double sum=0;
    double ave;
    for(int i=0; i<arr.length;i++)
    {
      sum=sum+arr[i];//sum up the integers

    }
    ave=sum/arr.length;

    return ave;

  }
  public static int min(int [] arr)
  {
    int minimum;
    minimum=arr[0];//initialize as first array
    for(int i=1; i<arr.length; i++)//forloop to compare the integers in the array
    {
      if(arr[i]<minimum)
      {
        minimum=arr[i];
      }

    }
    return minimum;
  }
}
