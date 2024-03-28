package Recursion;

public class ArrayReverse {

    public void reverseArrray(int [] input,int left ,int right){
        if(left>right){
            return;
        }
        
        reverseArrray(input, left+1, right-1);
        swapValues(input, left, right);
    }

    public void swapValues(int []input,int l,int r){
        
        int temp=input[l];
        input[l]=input[r];
        input[r]=temp;
        
        System.out.println(l+" "+r);
    }

    public static void main(String[] args) {
        int [] input={1,2,3,4,5};
        ArrayReverse arrayReverse=new ArrayReverse();
        arrayReverse.reverseArrray(input, 0, input.length-1);
        for(int i=0;i<input.length;i++){
            System.out.println(input[i]);
        }
    }

}
