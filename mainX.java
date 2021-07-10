
import java.io.*;
import java.util.*;
import java.io.File;

public class Test1
{
    static void RecursivePrint(File[] arr,int index,int level)throws IOException
{
        String file= new String();
        String file1= new String();

        // terminate condition
        if(index == arr.length)
            return;

        // tabs for internal levels
        for (int i = 0; i < level; i++)
           System.out.println("\t");

        // for files
        if(arr[index].isFile())
       {  file=arr[index].getName();
          file1=arr[index].getPath();
          System.out.print("\t\t"+file.length()+"mb\t\t"+arr[index].getName());
          System.out.println("");
        }
        // for sub-directories
        else if(arr[index].isDirectory())
        {
          file=arr[index].getName();
          file1=arr[index].getPath();
          System.out.print("\t\t<DIR>\t\t"+arr[index].getName()+"   ");      
          System.out.println("");
         }
         // recursion for main directory
        RecursivePrint(arr,++index, level);

}
    
    
    
    
static void getFolderSize(File[] arr) 
{
    long length1 = 0,length2=0;
    long count1=0,count2=0;
 
    for (int i = 0; i <arr.length; i++)
    {
        if (arr[i].isFile()) 
        {
          count1++;
          length1 += arr[i].length();
        }
        else if(arr[i].isDirectory())
        {
           count2++;
           length2 += arr[i].length();
        }
    }
    System.out.println(""+count1+" files(s):"+length1+"bytes");
    System.out.println(""+count2+" directory(s):"+length2+"bytes");
}




// Driver Method
    public static void main(String[] args) throws IOException
{
        // Provide full path for directory(change accordingly)
        Scanner test = new Scanner(System.in);
        System.out.println("Enter a Directory :");
        String maindirpath = test.nextLine();

        // File object
        File maindir = new File(maindirpath);

        if(maindir.exists() && maindir.isDirectory())
        {
            // array for files and sub-directories
            // of directory pointed by maindir
            File arr[] = maindir.listFiles();

            System.out.println("****************");
            System.out.println("Files from directory : " + maindir);
            System.out.println("****************");

            // Calling recursive method
            RecursivePrint(arr,0,0);
            getFolderSize(arr);
        }
    }
}
