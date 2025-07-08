// package Stack;
import java.util.*;
public class StackPQ{
    public static void StockSpanProblem(int arr[]){
        Stack<Integer> s = new Stack<>();
        int arr2[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            
            while (!s.isEmpty() && arr[i]>= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                arr2[i] = i+1;
            }else{
                arr2[i] = i - s.peek();
            }
            s.push(i);
        }

        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
    public static void main(String [] args){
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        StockSpanProblem(arr);

    }
}
