// package Stack;
import java.util.*;
public class StackRivision{
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
    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> l = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (int i = n-1; i >= 0; i++) {
            if(i == n-1){
                l.add(i, -1);
            }
            else{
                while (s.isEmpty() && arr[i] >= arr[s.peek()]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    l.add(-1);
                }else{
                    l.add(arr[s.peek()]);
                }
                s.push(i);
            }
        }
        Collections.reverse(l);
        return l;
    }

    // Nearest smaller numbers on left side in an array
    public static ArrayList<Integer> nextSmallerElement(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            while (!s.isEmpty() && arr[s.peek()] >= curr) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans.add(-1);
            }else{
                ans.add(s.peek());
            }
            s.push(i);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String [] args){
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        StockSpanProblem(arr);
        int height[] = {1, 6, 4, 10, 2, 5};
        System.out.println(nextSmallerElement(height));

    }
}
