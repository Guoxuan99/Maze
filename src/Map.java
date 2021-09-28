package Maze;

import java.util.Random;
import java.util.Scanner;

public class Map {
    protected int End;
    protected int Life, Level;
    protected int ItemNumberLeft, Move, T, arraySize;
    protected String array[][];
    protected String fire, name,wall, Item, Char, Path, Exit, Blackout, TorchLight;
    protected int row1, col1;

    public Map() {
        End = 0;
        Life = 3;
        Move = 0;
        T = 0;
        ItemNumberLeft = 3;
        fire = "🔥";
        wall = "█";
        Path = "░";
        Item = "♣";
        TorchLight = "🔦";
        Char = "♂";
        Exit = "◫";
        Blackout = "▓";
        Random r = new Random();

        Scanner s = new Scanner(System.in);
        System.out.println("----------------------------");                   //print the instruction
        System.out.println("INSTRUCTION:");
        System.out.println("1.♂ is YOU");
        System.out.println("2.💕 is your remaining life");
        System.out.println("3.█ is wall");
        System.out.println("4.♣ is item and you must collect ALL 3 items.");
        System.out.println("5.🔦 is the most useful item that can light up the maze for the next 3 steps.");
        System.out.println("6.🔥 is fire and once you step on it, you will lost one of your life.");
        System.out.println("7.◫ is the exit of the maze");
        System.out.println("----------------------------");
        System.out.println("Please enter your name.");
        name = s.nextLine();
        System.out.println("Please enter the map size.");
        arraySize = s.nextInt() + 2;
        System.out.println("Please enter the level number. (easy =1 , intermediate =2, hard=3, other number = super hard) ");
        Level = s.nextInt();

        array = new String[arraySize][arraySize];

        for (int row = 1; row < arraySize - 1; row++) {       //this is for the map with horizontal and vertical line

            for (int col = 1; col < arraySize - 1; col++) {

                int rand = r.nextInt(2) + 1;
                if (rand == 1) {
                    array[row][col] = wall;

                } else if (rand == 2) {
                    array[row][col] = wall;
                }
            }
        }
        int middle = ((arraySize - 2) / 2);
        array[middle][middle] = Path;

        int random = r.nextInt(2) + 1;
        int row = (arraySize - 2) / 2;
        int col = (arraySize - 2) / 2;

        //upperLeft
        for (int i = 0; i < 3; i++) {                       
            while (row > 1 && col > 1) {

                if (random == 1) {
                    col--;
                    array[row][col] = Path;
                } else if (random == 2) {
                    row--;
                    array[row][col] = Path;
                }
                random = r.nextInt(2) + 1;
            }
            row = (arraySize - 2) / 2;
            col = (arraySize - 2) / 2;
        }

        //upperRight
        row = (arraySize - 2) / 2;
        col = (arraySize - 2) / 2;

        for (int i = 0; i < 3; i++) {
            while (row > 1 && col < arraySize - 2) {

                if (random == 1) {
                    col++;
                    array[row][col] = Path;
                } else if (random == 2) {
                    row--;
                    array[row][col] = Path;
                }
                random = r.nextInt(2) + 1;
            }
            row = (arraySize - 2) / 2;
            col = (arraySize - 2) / 2;
        }

        //lowerLeft
        row = (arraySize - 2) / 2;
        col = (arraySize - 2) / 2;

        for (int i = 0; i < 3; i++) {
            while (row < arraySize - 2 && col > 1) {

                if (random == 1) {
                    col--;
                    array[row][col] = Path;
                } else if (random == 2) {
                    row++;
                    array[row][col] = Path;
                }
                random = r.nextInt(2) + 1;
            }
            row = (arraySize - 2) / 2;
            col = (arraySize - 2) / 2;
        }

        //lowerRight
        row = (arraySize - 2) / 2;
        col = (arraySize - 2) / 2;

        for (int i = 0; i < 3; i++) {
            while (row < arraySize - 2 && col < arraySize - 2) {

                if (random == 1) {
                    col++;
                    array[row][col] = Path;
                } else if (random == 2) {
                    row++;
                    array[row][col] = Path;
                }
                random = r.nextInt(2) + 1;
            }
            row = (arraySize - 2) / 2;
            col = (arraySize - 2) / 2;
        }

        //items + character + exits
        row1 = r.nextInt(arraySize - 2) + 1;
        col1 = r.nextInt(arraySize - 2) + 1;
        int row2 = r.nextInt(arraySize - 2) + 1;
        int col2 = r.nextInt(arraySize - 2) + 1;

        array[(arraySize - 2) / 2][(arraySize - 2) / 2] = Char;

        boolean a = true;
        for (int i = 0; i < 3; i++) {                             //print 3 items CLOVER
            a = true;
            while (a) {
                if (array[row1][col1].equals(Path)) {
                    array[row1][col1] = Item;
                    a = false;
                } else {
                    row1 = r.nextInt(arraySize - 2) + 1;
                    col1 = r.nextInt(arraySize - 2) + 1;
                }
            }
        }

        boolean c = true;
        for (int i = 0; i < 3; i++) {                             //print 3 items Fire
            c = true;
            while (c) {
                if (array[row1][col1].equals(Path)) {        //if row1 col1 wont be path, then it will proceed to else.

                    array[row1][col1] = fire;
                    c = false;
                } else {
                    row1 = r.nextInt(arraySize - 2) + 1;
                    col1 = r.nextInt(arraySize - 2) + 1;
                }
            }
        }

        boolean b = true;                                      // torchlight depending on level
        if (Level == 1) {

            for (int i = 0; i < 10; i++) {
                while (b) {
                    if (array[row1][col1].equals(Path)) {
                        array[row1][col1] = TorchLight;
                        b = false;
                    } else {
                        row1 = r.nextInt(arraySize - 2) + 1;
                        col1 = r.nextInt(arraySize - 2) + 1;
                    }
                }
                b = true;
            }

        } else if (Level == 2) {

            for (int i = 0; i < 5; i++) {
                while (b) {
                    if (array[row1][col1].equals(Path)) {
                        array[row1][col1] = TorchLight;
                        b = false;
                    } else {
                        row1 = r.nextInt(arraySize - 2) + 1;
                        col1 = r.nextInt(arraySize - 2) + 1;
                    }
                }
                b = true;
            }

        } else if (Level == 3) {

            for (int i = 0; i < 1; i++) {
                while (b) {
                    if (array[row1][col1].equals(Path)) {
                        array[row1][col1] = TorchLight;
                        b = false;
                    } else {
                        row1 = r.nextInt(arraySize - 2) + 1;
                        col1 = r.nextInt(arraySize - 2) + 1;
                    }
                }
                b = true;
            }

        }else{
           
        }
        a = true;                                              //Exit
        while (a) {
            if (array[1][col2].equals(Path)) {
                array[1][col2] = Exit;
                a = false;

            } else if (array[row2][1].equals(Path)) {
                array[row2][1] = Exit;
                a = false;
            } else {
                row2 = r.nextInt(arraySize - 2) + 1;
                col2 = r.nextInt(arraySize - 2) + 1;

            }
        }
    }
}
