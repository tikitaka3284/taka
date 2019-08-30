public class Quiz8
{
  public static void main(String[] args)
  {
    char[] arr={'a','b','c','d','e'};
    System.out.println("After right Rotated :");
    rightRotate(arr,2);
    System.out.println();
    System.out.println("After left Rotated:");
    leftRotate(arr,3);
    System.out.println();

  }
  public static void rightRotate(char[] arr, int n)
  {
    char temp;
    for(int k=0; k<n; k++)
    {
      temp=arr[arr.length-1];
      for(int i=arr.length-1; i>0; i--)
      {
        arr[i]=arr[i-1];
      }
      arr[0]=temp;
    }
    for(int i=0; i<arr.length; i++)
    {
      System.out.print(arr[i]);
    }

  }
  public static void leftRotate(char[] arr, int n)
  {
    char temp;
    for(int k=0; k<n; k++)
    {
      temp=arr[0];
      for(int i=0; i<arr.length-1;i++)
      {
        arr[i]=arr[i+1];
      }
      arr[arr.length-1]=temp;
    }
    for(int i=0; i<arr.length; i++)
    {
      System.out.print(arr[i]);
    }
  }
}
