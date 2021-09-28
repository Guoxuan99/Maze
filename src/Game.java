
package Maze;

import java.io.*;
import sun.audio.*;


public class Game extends Map {
    public static void main(String[] args) {
        int i=0;
     try{
        String gongFile = "D:/WID180017/AssignmentMaze/src/Sounds/Misty-Bog_Looping wav.wav";
        InputStream in = new FileInputStream(gongFile);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
        MazeRunner maze =new MazeRunner();
        AudioPlayer.player.stop(audioStream);
        
    }catch (Exception e){e.printStackTrace();}
        
    
       
    }
    }
  

