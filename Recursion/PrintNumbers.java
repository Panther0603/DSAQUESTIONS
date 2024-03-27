package Recursion;

public class PrintNumbers {

    // print the number in the format 1,2,3,4,5,6,7
    public  void printForward(int n){
        
        if(n<=0){
            return;
        }
        printForward(n-1);
        System.out.print(n+" ");
    }
    
    public void printReverse(int n){
        if(n<=0){
            return;
        }
       System.out.print(n +" ");
       printReverse(n-1);
    }

    public static void main(String[] args) {
        PrintNumbers printNumbers= new PrintNumbers();
        System.out.println("in the forward order");
        printNumbers.printForward(5);
        System.out.println( "\nin the reverse order");
        printNumbers.printReverse(5);
    }
}
