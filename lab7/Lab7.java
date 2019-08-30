import java.lang.Math;//import Math for initialize method of random numbers
public class Lab7// class name of Lab7 and file name
{
  public static void main(String[] args)//main method
  {
    int [] arr=initialize(10,20,40);//set the size, lowerbound and upperbound
    System.out.println("Show the all number in the array");
    printArray(arr);
    System.out.println();
    System.out.println("After the all element are reversed: ");
    reverse(arr);
    System.out.println();
    System.out.println("After the array is sorted: ");
    sort(arr);
    System.out.println();
    count(arr);
    System.out.println("if it is valid, a number would be inserted");
    System.out.println(insert(arr,33,7));
    System.out.println();
    System.out.println("After a number is inserted: ");
    printArray(arr);
  }
  public static int [] initialize(int size, int lowerBound, int upperBound)//create an array which has numbers between lower to upper bound
  {
    int [] arr;
    arr=new int[size];
    for(int i=0; i<size; i++)
    {
      arr[i]=(int)(Math.random()*upperBound+lowerBound);// get the random numebr in each element
    }

    return arr;
  }
  public static void printArray(int[] arr) //method to print the array
  {
    for(int i=0; i<arr.length; i++)//use for-loop to print all the elements
    {
      System.out.print(arr[i]+" ");
    }
  }
  public static void reverse(int [] arr)//method to reverse the origianl array
  {
    int [] newArray = new int[arr.length];//create the new array
    int n=arr.length;
    for(int i=0; i<arr.length; i++)//for-loop to put the numbers in the elements as reversive order
    {
      newArray[n-1]=arr[i];
      n=n-1;
    }
    System.out.println("Reverse array is :");
    for(int j=0; j<arr.length;j++)//just print the reversive array from original
    {
      System.out.print(newArray[j]+" ");
    }
  }
  public static void sort(int [] arr)
  {
    for(int i=0; i<arr.length;i++)
    {
      for(int j=0; j<arr.length; j++)
      {
        if(arr[i]<arr[j])
        {
          int temp=arr[i];//temp is set to swap the number arr[i] to arr[j] if arr[j] is greater than arr[i]
          arr[i]=arr[j];
          arr[j]=temp;
        }
      }

    }
    System.out.print("Ascending order: ");
    for(int i=0; i<arr.length; i++)//for-loop to print the array which is sorted
    {
      System.out.print(arr[i]+" ");
    }
  }
  public static void count(int [] arr)
  {
    int []temp = new int[arr.length];//create an array of temp
    int visit=-1;


    for(int i=0; i<arr.length; i++)
    {
      int count=1;
      for(int j=i+1; j<arr.length; j++)
      {
        if(arr[i]==arr[j])//if a element is equal to another element
        {
          count++;//increment the counter
          temp[j]=visit;
        }
      }
      if(temp[i]!=visit)
      {
        temp[i]=count;//temp receives counter incremented by couting the occurrence of repeated numbers
      }
    }
    for(int i=0; i<temp.length; i++)//for-loop to print how many times it occurs in the array
    {
      if(temp[i]!=visit)
      System.out.println(arr[i]+" occurs = "+ temp[i]);

    }
  }
  public static boolean insert(int[] arr, int n, int index)//method to insert a number on specific place and the method judges whether it is valid or not
  {
    boolean judge;//set to know either true or false
    if(index<=arr.length-1)//to judge whether it is valid or not, that should be 0 to arr.length-1 always
    {
      for(int i=arr.length-1; i>index; i--)//to shift the numbers on the place to next index for inserting
      {
        arr[i]=arr[i-1];
      }
      arr[index]=n;//insert n on specific place of index
      judge=true;// if it is valid, return true
    }
    else
    {
      judge=false;//if it is invalid, rerturn false, and then nothing inserts in the array
    }
    return judge;

  }

}
