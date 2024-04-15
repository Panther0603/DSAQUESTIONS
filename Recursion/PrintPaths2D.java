package Recursion;

import java.util.Arrays;

public class PrintPaths2D {

    private static void  printPath2Direction(int row,int col,int n,String path){

        if(row>=n|| col>=n){
            return;
        }

        if(row == n-1 && col ==n-1){
            System.out.println(path);
        }

        printPath2Direction(row+1,col,n,path+"D");
        printPath2Direction(row,col+1,n,path+"R");
    }

    private static int  countPath2Direction(int row,int col,int n){

        if(row>=n || col>=n){
            return  0;
        }
        if(row == n-1 && col ==n-1){
            return  1;
        }
        return  countPath2Direction(row+1,col,n)+countPath2Direction(row,col+1,n);
    }

    private static void printPath4Direction(int row,int col,int n,String path,boolean [][] isVisited){

        if(row<0 || col<0 || row >=n || col>=n || isVisited[row][col]){
            return;
        }
        if(row == n-1 && col == n-1){
            System.out.println(path);
            return;
        }
        isVisited[row][col]=true;
        printPath4Direction(row+1,col,n,path+"D",isVisited);
        printPath4Direction(row-1,col,n,path+"T",isVisited);
        printPath4Direction(row,col+1,n,path+"R",isVisited);
        printPath4Direction(row,col-1,n,path+"L",isVisited);
        isVisited[row][col]=false;
    }

    private static int countPath4Direction(int row,int col,int n,boolean [][] isVisited){

        if(row<0 || col<0 || row >=n || col>=n || isVisited[row][col]){
            return 0;
        }
        if(row == n-1 && col == n-1){
            return 1;
        }
        isVisited[row][col]=true;
         int totalWays = countPath4Direction(row+1,col,n,isVisited)
        +countPath4Direction(row-1,col,n,isVisited)
        +countPath4Direction(row,col+1,n,isVisited)
        +countPath4Direction(row,col-1,n,isVisited);
        isVisited[row][col]=false;

        return totalWays;
    }

    public static void main(String[] args) {
//         printing in 2 direction
//         printPath2Direction(0,0,3,"");
//
//         counting the number of path 2 different path
//        int totalPath = countPath2Direction(0,0,3);
//        System.out.println(totalPath);

//        printing the path 4 directions
        int n=4;
//        printPath4Direction(0,0,n,"",new boolean[n][n]);

//        count the direction from 4 directions
        int totalWays = countPath4Direction(0,0,n,new boolean[n][n]);
        System.out.println(totalWays);
    }




}
