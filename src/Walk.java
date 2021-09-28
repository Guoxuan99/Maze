package Maze;

import java.util.Scanner;

public class Walk extends Boarder {

    protected String NextMove;
    int row = (arraySize - 2) / 2;
    int col = (arraySize - 2) / 2;
    boolean Guoxuan = true;

    public Walk() {

        TerminateGame:
        {
            while (Guoxuan) {
                Scanner in = new Scanner(System.in);
                System.out.println("Please enter w,s,d,a for the next move.");      //Request user movement
                NextMove = in.nextLine();

                if (NextMove.equalsIgnoreCase("W") && !array[row - 1][col].equals(wall) && !array[row - 1][col].equals("─")) { //move upward         //W

                    if (array[row - 1][col].equals(Item)) {
                        array[row - 1][col] = Path;                                                     //collected item replace with path.
                        ItemNumberLeft--;
                        if (ItemNumberLeft > 0) {
                            System.out.println("Congratulation!" + name + " have collected 1 of the item."); 
                            System.out.println("There is " + ItemNumberLeft + " item left");            //Display item left
                        } else if (ItemNumberLeft == 0) {
                            System.out.println("Congratulation! " + name + " have collected all of the item.");
                        }
                    } else if (array[row - 1][col].equals(Exit)) {
                        array[row - 1][col] = Path;
                        if (ItemNumberLeft != 0) {
                            System.out.println("" + name + " is the disgrace to the Maze Runner’s community."); // not collect all items
                            End = 1;
                            break TerminateGame;
                        } else {
                            System.out.println("Congratulation! " + name + " have escaped from the maze!");     //collected all the item
                            End = 1;        
                            break TerminateGame;
                        }
                    } else if (array[row - 1][col].equals(TorchLight)) {        //torchlight brighten the whole map
                        T = 1;
                        Move = 0;
                        array[row - 1][col] = Path;
                        System.out.println("Congratulation! " + name + " have collected the Torch Light. Your map will be show for the next 3 steps."); //collected item replace with path.
                    } else if (array[row - 1][col].equals(fire)) {      //fire reduce the player's life by 1
                        array[row - 1][col] = Path;
                        System.out.println(name + " just lost 1 life."); //collected item replace with path.
                        Life--;
                    }
                    String temp = array[row][col];
                    array[row][col] = array[row - 1][col]; // swap
                    array[row - 1][col] = temp;
                    row = row - 1;

                } else if (NextMove.equalsIgnoreCase("A") && !array[row][col - 1].equals(wall) && !array[row][col - 1].equals("│")) {          //A

                    if (array[row][col - 1].equals(Item)) {
                        array[row][col - 1] = Path;
                        ItemNumberLeft--;
                        if (ItemNumberLeft > 0) {
                            System.out.println("Congratulation!" + name + " have collected 1 of the item."); 
                            System.out.println("There is " + ItemNumberLeft + " item left");
                        } else if (ItemNumberLeft == 0) {
                            System.out.println("Congratulation! " + name + " have collected all of the item.");
                        }
                    } else if (array[row][col - 1].equals(Exit)) {
                        array[row][col - 1] = Path;
                        if (ItemNumberLeft != 0) {
                            System.out.println("" + name + " is the disgrace to the Maze Runner’s community."); // not collect all
                            End = 1;
                            break TerminateGame;
                        } else {
                            System.out.println("Congratulation! " + name + " have escaped from the maze!");
                            End = 1;
                            break TerminateGame;
                        }
                    } else if (array[row][col - 1].equals(TorchLight)) {   //torchlight brighten the map
                        T = 1;
                        Move = 0;
                        array[row][col - 1] = Path;
                        System.out.println("Congratulation! " + name + " have collected the Torch Light. Your map will be show for the next 3 steps."); //collected item replace with path.
                    } else if (array[row][col - 1].equals(fire)) {
                        array[row][col - 1] = Path;
                        System.out.println(name + " just lost 1 life."); //collected item replace with path.
                        Life--;
                    }
                    String temp = array[row][col];
                    array[row][col] = array[row][col - 1];
                    array[row][col - 1] = temp;
                    col = col - 1;

                } else if (NextMove.equalsIgnoreCase("S") && !array[row + 1][col].equals(wall) && !array[row + 1][col].equals("─")) {       //S

                    if (array[row + 1][col].equals(Item)) {
                        array[row + 1][col] = Path;
                        ItemNumberLeft--;
                        if (ItemNumberLeft > 0) {
                            System.out.println("Congratulation!" + name + " have collected 1 of the item."); 
                            System.out.println("There is " + ItemNumberLeft + " item left");
                        } else if (ItemNumberLeft == 0) {
                            System.out.println("Congratulation! " + name + " have collected all of the item.");
                        }
                    } else if (array[row + 1][col].equals(Exit)) {
                        array[row + 1][col] = Path;
                        if (ItemNumberLeft != 0) {
                            System.out.println("" + name + " is the disgrace to the Maze Runner’s community."); // not collect all
                            End = 1;
                            break TerminateGame;
                        } else {
                            System.out.println("Congratulation! " + name + " have escaped from the maze!");
                            End = 1;
                            break TerminateGame;
                        }
                    } else if (array[row + 1][col].equals(TorchLight)) {
                        T = 1;
                        Move = 0;
                        array[row + 1][col] = Path;
                        System.out.println("Congratulation! " + name + " have collected the Torch Light. Your map will be show for the next 3 steps."); //collected item replace with path.
                    } else if (array[row + 1][col].equals(fire)) {
                        array[row + 1][col] = Path;
                        System.out.println(name + " just lost 1 life."); //collected item replace with path.
                        Life--;
                    }
                    String temp = array[row][col];
                    array[row][col] = array[row + 1][col];
                    array[row + 1][col] = temp;
                    row = row + 1;
                } else if (NextMove.equalsIgnoreCase("D") && !array[row][col + 1].equals(wall) && !array[row][col + 1].equals("│")) {
                    if (array[row][col + 1].equals(Item)) {
                        array[row][col + 1] = Path;
                        ItemNumberLeft--;
                        if (ItemNumberLeft > 0) {
                            System.out.println("Congratulation!" + name + " have collected 1 of the item."); 
                            System.out.println("There is " + ItemNumberLeft + " item left");
                        } else if (ItemNumberLeft == 0) {
                            System.out.println("Congratulation! " + name + " have collected all of the item.");
                        }
                    } else if (array[row][col + 1].equals(Exit)) {
                        array[row][col + 1] = Path;
                        if (ItemNumberLeft != 0) {
                            System.out.println("" + name + " is the disgrace to the Maze Runner’s community."); // not collect all
                            End = 1;
                            break TerminateGame;
                        } else {
                            System.out.println("Congratulation! " + name + " have escaped from the maze!");
                        }
                        End = 1;
                        break TerminateGame;
                    } else if (array[row][col + 1].equals(TorchLight)) {
                        T = 1;
                        Move = 0;
                        array[row][col + 1] = Path;
                        System.out.println("Congratulation! " + name + " have collected the Torch Light. Your map will be show for the next 3 steps."); //collected item replace with path.
                    } else if (array[row][col + 1].equals(fire)) {
                        array[row][col + 1] = Path;
                        System.out.println(name + " just lost 1 life."); //collected item replace with path.
                        Life--;
                    }
                    String temp = array[row][col];
                    array[row][col] = array[row][col + 1];
                    array[row][col + 1] = temp;
                    col = col + 1;
                } else {
                    System.out.println("Please try again.");
                }

//print Bright Map if the player really cannot solve the maze
/*
                for (int i = 0; i < arraySize; i++) {
                    for (int j = 0; j < arraySize; j++) {
                        System.out.print(array[i][j]);
                    }
                    System.out.println();
                }
                 */
                //print BrightMap when you get torchlight
                BrightMap:
                {
                    if (T == 1) {
                        Move++;
                        if (Move == 4) {
                            Move = 0;
                            T = 0;
                            break BrightMap;
                        }
                        for (int i = 0; i < arraySize; i++) {
                            for (int j = 0; j < arraySize; j++) {
                                System.out.print(array[i][j]);
                            }
                            System.out.println();
                        }

                    }
                }
                //lives of the player

                System.out.print(name + " : ");
                if (Life == 0) {
                    System.out.print("☻");
                }
                for (int i = Life; i > 0; i--) {
                    System.out.print("💕");

                }
                System.out.println();

                if (Life == 0) {
                    System.out.println("Game Over.");
                    End = 1;
                    break TerminateGame;
                }

                if (T == 0) {                       

                    for (int i = 0; i < arraySize; i++) {
                        for (int j = 0; j < arraySize; j++) {

                            if ((i == row - 2 && j == col) || (i == row - 1 && j == col)) { //up 2
                                if (!array[row - 1][col].equals(wall)) {
                                    System.out.print(array[i][j]);
                                } else if (array[row - 1][col].equals(wall)) {
                                    if (i == row - 2 && j == col) {
                                        System.out.print(Blackout);
                                    } else {
                                        System.out.print(wall);
                                    }
                                } else {
                                    System.out.print(Blackout);
                                }
                            } else if ((i == row - 2 && j == col - 1) || (i == row - 2 && j == col - 2) || (i == row - 1 && j == col - 2) || (i == row - 1 && j == col - 1)) { //upper left 4
                                if (!array[row - 1][col - 1].equals(wall)) {
                                    System.out.print(array[i][j]);
                                } else if (array[row - 1][col - 1].equals(wall)) {
                                    if ((i == row - 2 && j == col - 1) || (i == row - 2 && j == col - 2) || (i == row - 1 && j == col - 2)) {
                                        System.out.print(Blackout);
                                    } else {
                                        System.out.print(wall);
                                    }
                                } else {
                                    System.out.print(Blackout);
                                }
                            } else if ((i == row && j == col - 2) || (i == row && j == col - 1)) { // left 2
                                if (!array[row][col - 1].equals(wall)) {
                                    System.out.print(array[i][j]);
                                } else if (array[row][col - 1].equals(wall)) {
                                    if ((i == row && j == col - 2)) {
                                        System.out.print(Blackout);
                                    } else {
                                        System.out.print(wall);
                                    }
                                } else {
                                    System.out.print(Blackout);
                                }
                            } else if ((i == row + 1 && j == col - 2) || (i == row + 1 && j == col - 1) || (i == row + 2 && j == col - 2) || (i == row + 2 && j == col - 1)) { //lower left 4
                                if (!array[row + 1][col - 1].equals(wall)) {
                                    System.out.print(array[i][j]);
                                } else if (array[row + 1][col - 1].equals(wall)) {
                                    if ((i == row + 1 && j == col - 2) || (i == row + 2 && j == col - 2) || (i == row + 2 && j == col - 1)) {
                                        System.out.print(Blackout);
                                    } else {
                                        System.out.print(wall);
                                    }
                                } else {
                                    System.out.print(Blackout);
                                }
                            } else if ((i == row + 1 && j == col) || (i == row + 2 && j == col)) { //low 2
                                if (!array[row + 1][col].equals(wall)) {
                                    System.out.print(array[i][j]);
                                } else if (array[row + 1][col].equals(wall)) {
                                    if ((i == row + 2 && j == col)) {
                                        System.out.print(Blackout);
                                    } else {
                                        System.out.print(wall);
                                    }
                                } else {
                                    System.out.print(Blackout);
                                }
                            } else if ((i == row + 1 && j == col + 1) || (i == row + 1 && j == col + 2) || (i == row + 2 && j == col + 1) || (i == row + 2 && j == col + 2)) { //lower right 4
                                if (!array[row + 1][col + 1].equals(wall)) {
                                    System.out.print(array[i][j]);
                                } else if (array[row + 1][col + 1].equals(wall)) {
                                    if ((i == row + 1 && j == col + 2) || (i == row + 2 && j == col + 1) || (i == row + 2 && j == col + 2)) {
                                        System.out.print(Blackout);
                                    } else {
                                        System.out.print(wall);
                                    }
                                } else {
                                    System.out.print(Blackout);
                                }
                            } else if ((i == row && j == col + 1) || (i == row && j == col + 2)) { //right 2
                                if (!array[row][col + 1].equals(wall)) {
                                    System.out.print(array[i][j]);
                                } else if (array[row][col + 1].equals(wall)) {
                                    if ((i == row && j == col + 2)) {
                                        System.out.print(Blackout);
                                    } else {
                                        System.out.print(wall);
                                    }
                                } else {
                                    System.out.print(Blackout);
                                }
                            } else if ((i == row - 1 && j == col + 1) || (i == row - 2 && j == col + 1) || (i == row - 2 && j == col + 2) || (i == row - 1 && j == col + 2)) { //upper right 4
                                if (!array[row - 1][col + 1].equals(wall)) {
                                    System.out.print(array[i][j]);
                                } else if (array[row - 1][col + 1].equals(wall)) {
                                    if ((i == row - 2 && j == col + 1) || (i == row - 2 && j == col + 2) || (i == row - 1 && j == col + 2)) {
                                        System.out.print(Blackout);
                                    } else {
                                        System.out.print(wall);
                                    }
                                } else {
                                    System.out.print(Blackout);
                                }
                            } else if (i == row && j == col) {
                                System.out.print(array[i][j]);
                            } else {
                                System.out.print(Blackout);
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
