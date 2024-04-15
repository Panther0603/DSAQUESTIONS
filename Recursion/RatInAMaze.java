package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInAMaze {

    public static void printRatPath(int row,int col,int [][] maze,String path,boolean [][] isCovered){

       // System.out.println(path+" "+row+" "+col);
        if(row<0 || col<0 || row  >= maze.length || col >=maze[0].length || isCovered[row][col] || maze[row][col] == 0){
            return;
        }

        if((row == maze.length - 1 && col == maze[0].length-1)){
            System.out.println(path);
            return;
        }

        isCovered[row][col] =true;
        printRatPath(row+1,col,maze,path+"D",isCovered);
        printRatPath(row-1,col,maze,path+"U",isCovered);
        printRatPath(row,col+1,maze,path+"R",isCovered);
        printRatPath(row,col-1,maze,path+"L",isCovered);
        isCovered[row][col]=false;
    }

    public static ArrayList<String> getAllMazePath(int row,int col,int [][] maze,String path,boolean [][] isCovered,ArrayList<String> allPath){

        if(row <0 || col<0 || row >= maze.length || col >= maze[0].length || maze[row][col] == 0 || isCovered[row][col]){
            return  allPath;
        }
        if(row == maze.length-1 && col == maze[0].length-1){
            allPath.add(path);
            return  allPath;
        }
        isCovered[row][col]=true;
        allPath=getAllMazePath(row+1,col,maze,path+"D",isCovered,allPath);
        allPath=getAllMazePath(row-1,col,maze,path+"U",isCovered,allPath);
        allPath=getAllMazePath(row,col+1,maze,path+"R",isCovered,allPath);
        allPath=getAllMazePath(row,col-1,maze,path+"L",isCovered,allPath);

        isCovered[row][col]=false;
        return allPath;
    }


    public static void main(String[] args) {
        int n = 4;
       int  maze[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};

       //printRatPath(0,0,maze,"",new boolean[n][n]);

       ArrayList<String> allMazePath=getAllMazePath(0,0,maze,"",new boolean[n][n],new ArrayList<>());
        System.out.println(allMazePath);
    }
}
