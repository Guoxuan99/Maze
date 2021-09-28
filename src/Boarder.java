package Maze;

import java.util.Scanner;

public class Boarder extends Map{

    public Boarder() {
        
        array[0][0] = "┌";                        //upper left boundary
        array[0][arraySize-1] = "┐";              //upper right boundary
        array[arraySize-1][0] = "└";              //lower left boundary
        array[arraySize-1][arraySize-1] ="┘";     // Lower right boundary
 
        for (int row = 0; row < arraySize; row++) {

            for (int col = 0; col < arraySize; col++) {

                if ((row >= 1 && row < arraySize-1) && (col == 0)) {
                    array[row][col] = "│";                                  //Vertical boundary
                    System.out.print(array[row][col]);
                }
                else if ((row == 0 || row == arraySize -1) &&(col>0 && col<arraySize -1) ) {
                    array[row][col] = "─";                                  //Horizontal boundary
                    System.out.print(array[row][col]);
                }
                else if ((row >= 1 && row < arraySize-1 ) && (col == (arraySize - 1))) {
                    array[row][col] = "│";
                    System.out.print(array[row][col]);}
                else {
                    System.out.print(array[row][col]);
                }

            }
            System.out.println();

        }
       
        

    }

}
