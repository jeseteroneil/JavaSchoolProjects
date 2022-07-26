//Jeseter O'Neil
//Project 4

import java.io.*;
import java.util.Scanner;

class MaximumSum
{
    
    public static int largestNonConsecutiveSubsetOfArray(int[] numArray)
    {
       
        int arrlength= numArray.length;
        
        if (arrlength == 0) {
            return 0;
        }
 
      
        if (arrlength == 1) {
            return numArray[0];
        }
 
        int[] subPrblms = new int[arrlength];
 
        subPrblms[0] = numArray[0];
        subPrblms[1] = Integer.max(numArray[0], numArray[1]);
 
        
        for (int x = 2; x < arrlength; x++)
        {
            
            subPrblms[x] = Integer.max(subPrblms[x - 1], subPrblms[x - 2] + numArray[x]);
             subPrblms[x] = Integer.max(subPrblms[x], numArray[x]);
        }
 
        return subPrblms[arrlength - 1];
    }
 
    public static void main(String[] args) throws FileNotFoundException
    {
        
        File file=new File("input.txt"); 
        Scanner userInput = new Scanner(file);
        int x = userInput.nextInt();
        int numArray[]=new int[x];
        
         
            for(int i = 0;i < x; i++) {
                numArray[i]=userInput.nextInt(); 
        }
        userInput.close();
          System.out.print("The maximum sum is " + largestNonConsecutiveSubsetOfArray(numArray));
    }
}