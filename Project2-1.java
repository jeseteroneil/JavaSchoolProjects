// Jeseter O'Neil
//Comp 482
//Project 2

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Project2 {

    public static void main(String args[]) throws FileNotFoundException{

        File temp = new File("input.txt");
        Scanner getInput = new Scanner(temp);

        int input= getInput.nextInt();
        ArrayList<Integer> ratings= new ArrayList<Integer>(input);
        ArrayList<Integer> adjustedRatings= new ArrayList<Integer>(input);

        // read from file and place values in array
        for (int x = 0; x < input; x++){
            ratings.add(getInput.nextInt());
            adjustedRatings.add(1);
        }
        getInput.close();

        // calculate values from input
        for(int x = 0; x < input; x++) {

            for(int i = x; i >= 0; i--) {

                if(i - 1 >= 0) {
                    if(ratings.get(i)> ratings.get(i-1))
                        adjustedRatings.set(i,Math.max(adjustedRatings.get(i), adjustedRatings.get(i - 1) + 1));
                }
                if( i + 1 < input) {
                    if(ratings.get(i)>ratings.get( i + 1))
                        adjustedRatings.set(i,Math.max(adjustedRatings.get(i), adjustedRatings.get(i + 1) + 1));
                }
            }
        }


        //output
        int sum= 0;
        for(int i= 0; i < input; i++) {
            sum+= adjustedRatings.get(i);
        }
        System.out.println(sum);
    }
}
