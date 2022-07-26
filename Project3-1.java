
//Jeseter O'Neil
//Project 3 

import java.io.*;
import java.util.Scanner;

 
class Project3 {
 
     
     public static int maxSum(int[] numArray, int lside, int rside)
     {
        
         if (rside == lside) {
             return numArray[lside];
         }
  
        
         int mid = (lside + rside) / 2;
  
         
         int lMax = Integer.MIN_VALUE;
         int sum = 0;

         for (int i = mid; i >= lside; i--)
         {
             sum += numArray[i];
             if (sum > lMax) {
                 lMax = sum;
             }
         }
  
         
         int rMax = Integer.MIN_VALUE;
         sum = 0;    
         for (int i = mid + 1; i <= rside; i++)
         {
             sum += numArray[i];
             if (sum > rMax) {
                 rMax = sum;
             }
         }
  
        
         int maxlsideRside = Integer.max(maxSum(numArray, lside, mid), maxSum(numArray, mid + 1, rside));
  
         
         return Integer.max(maxlsideRside, lMax + rMax);
     }
  
     
     public static int findMaximumSum(int[] numArray)
     {
         
         if (numArray == null || numArray.length == 0) {
             return 0;
         }
  
         return maxSum(numArray, 0, numArray.length - 1);
     }
  

  
 
    public static void main(String[] args) throws FileNotFoundException
    {
        File file=new File("input.txt"); 
        Scanner userInput = new Scanner(file);
            int x = userInput.nextInt();
            int numArray[]=new int[x];
         
            for(int i=0;i<x;i++) {
                numArray[i]=userInput.nextInt(); 
        }
        userInput.close();
        System.out.println(findMaximumSum(numArray));  

    }
}