package Finland.q2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayWriter {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        try {
        	//creating array file
            FileWriter writer = new FileWriter("H:\\SpringBoot\\project forder\\OnlineExamSystem\\src\\main\\resources\\static\\file/file.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            int lng=array.length;
            for(int i=0;i<lng;i++)
            {
            	for(int j=0;j<lng;j++)
            	{
            		
            		if(j==(lng-1))
            		{
            			bw.write(Integer.toString(array[i][j]));
            		}
            		else {
            			bw.write(Integer.toString(array[i][j])+",");
            		}
            		
            	}
            	 bw.newLine();
            }
            bw.close();
            
           // read data
            
            BufferedReader reader = new BufferedReader(new FileReader("H:\\SpringBoot\\project forder\\OnlineExamSystem\\src\\main\\resources\\static\\file/file.txt"));
            String line;
            int numRows = 0;
            int numCols = 0;
            

            while ((line = reader.readLine()) != null) {
                numRows++;
                String[] tokens = line.split(",");
                numCols = tokens.length;
            }
             reader.close();
		        reader = new BufferedReader(new FileReader("H:\\SpringBoot\\project forder\\OnlineExamSystem\\src\\main\\resources\\static\\file/file.txt"));
		        array = new int[numRows][numCols];
		        int row = 0;
		        while ((line = reader.readLine()) != null) {
		            String[] tokens = line.split(",");
		            for (int col = 0; col < tokens.length; col++) {
		                array[row][col] = Integer.parseInt(tokens[col]);
		            }
		            row++;
		        }
		        reader.close();
		       // System.out.println(Arrays.deepToString(array));
		      //print array
		        System.out.println("Element Of Array From File:");
		        for (int[] roww : array) {
		            for (int col : roww) {
		                System.out.print(col + ",");
		            }
		            System.out.println();
		        }
		        //calculate Sum
		        int sum=0;
		        for (int[] roww : array) {
		            for (int col : roww) {
		                sum=sum+col;
		            }
		        }
		        
		        System.out.println("The Sum Is : "+sum+"\n");

		        System.out.println("The Average Is : "+(sum)/(numRows*numCols)+"\n");
		        
		        //calculate max and min
		        
                 int max=-77655,min=9999999;
                 for (int[] roww : array) {
 		            for (int col : roww) {
 		                if(col>max)
 		                {
 		                	max=col;
 		                }
 		                if(col<min)
 		                {
 		                	min=col;
 		                }
 		            }
 		        }
                 System.out.println("The Max is : "+max+"\n");
                 System.out.println("The Min Is : "+min+"\n");
                 
                 // transpose the array
                 int[][] transposedArray = new int[numCols][numRows];
                 for ( row = 0; row < numRows; row++) {
                     for (int col = 0; col < numCols; col++) {
                         transposedArray[col][row] = array[row][col];
                     }
                 }
                 array = transposedArray;
                 System.out.println("The transpose array Is :");
                // System.out.println("The transpose array Is : "+Arrays.deepToString(array)+"\n");
                 for (int[] roww : array) {
 		            for (int col : roww) {
 		                System.out.print(col + ",");
 		            }
 		            System.out.println();
 		        }

                 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
