// package Stack;
import java.util.*;
public class StackRevision{
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
            System.out.print(arr2[i]+" ");
        }
        System.out.println("");
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
    public static ArrayList<Integer> nextSmallerLeft(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            while (!s.isEmpty() && arr[s.peek()] >= curr) {
                s.pop();
                System.out.println(i);
            }
            if (s.isEmpty()) {
                ans.add(-1);
            }else{
                ans.add(s.peek());
            }
            s.push(i);
        }
        // Collections.reverse(ans);
        return ans;
    }

    public static ArrayList<Integer> nextSmallerRight(int[] arr) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = arr.length-1; i >= 0; i--) {
            
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans.add(n);
            }else{
                ans.add(s.peek());
            }
            s.push(i);
        }
        Collections.reverse(ans);
        return ans;
    }
    public static int maxArea(int height[], int nsl[], int nsr[]){
        int ans = 0;
        for (int i = 0; i < nsr.length; i++) {
            int length = height[i];
            int width = nsr[i] - nsl[i] -1;
            int max = length * width;
    
            ans = Math.max(ans, max);
        }
        return ans;
        }

    // Assignment
    public static boolean isPalimdrome(LinkedList<Character> ll){
        LinkedList<Character> l = new LinkedList<>(ll);
        Stack<Character> s = new Stack<>();
        int n = l.size();
        for (int i = 0; i < n/2; i++) {
            char c = l.removeFirst();
            s.push(c);
        }
        if (n/2 != 0) {
            l.removeFirst();
        }

        for (int i = 0; i < n/2; i++) {
            if (l.removeFirst() != s.pop()) {
                return false;
            }
        }

        return true;
    }
    // 
    public static String simplifyPath(String path) {
        String [] arr = path.split("/");
        Stack<String> s = new Stack<>();

        for (String str : arr) {
            if (str.equals("..") && !s.isEmpty()) {
                s.pop();
            }else if (!str.equals("") && !str.equals(".") && !str.equals("\"..\"")) {
                s.push(str);
            }
        }

        StringBuilder str = new StringBuilder();
        for (String string : s) {
            str.append("/");
            str.append(string);
            
        }

        return (str.length() != 0)? str.toString(): "/";
    }

    // Q3
    // Input: s = "2[abc]3[cd]ef"
    // Output: "abcabccdcdcdef"
    
    public static String decodeString(String s) {
        // StringBuilder str = new StringBuilder();
        Stack<Character> ch = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char chars = s.charAt(i);
            if (chars != ']') {
                ch.push(chars);
            } else {
                StringBuilder currStr = new StringBuilder();
                
                // Extract the encoded substring
                while (!ch.isEmpty() && ch.peek() != '[') {
                    currStr.insert(0, ch.pop());
                }
                
                // Remove the opening bracket '['
                if (!ch.isEmpty()) {
                    ch.pop();
                }
                
                // Extract the number (k)
                int num = 0;
                int base = 1;
                while (!ch.isEmpty() && Character.isDigit(ch.peek())) {
                    num = (ch.pop() - '0') * base + num;
                    base *= 10;
                }
                
                // Repeat the string
                String repeatedStr = currStr.toString().repeat(num);

                // Push the expanded string back into the stack
                for (char c : repeatedStr.toCharArray()) {
                    ch.push(c);
                }
            }
        }
        
        // Build the final result
        StringBuilder result = new StringBuilder();
        while (!ch.isEmpty()) {
            result.insert(0, ch.pop());
        }
        
        return result.toString();
    }
    public static void main(String [] args){
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        StockSpanProblem(arr);
        int height[] = {2, 1, 5, 6, 2, 3};
        int nsl[]= nextSmallerLeft(height).stream().mapToInt(i -> i).toArray();
        int nsr[]= nextSmallerRight(height).stream().mapToInt(i -> i).toArray();  
        System.out.println("Max Area: "+maxArea(height,nsl,nsr));   

        // assignment
        LinkedList<Character> l = new LinkedList<>();

        l.addLast('A');
        l.addLast('B');
        l.addLast('C');
        l.addLast('B');
        l.addLast('A');
        System.out.println(l);
        // System.out.println(l.removeLast());
        System.out.println("Is the linked list Palimdrome? "+ isPalimdrome(l));

        System.out.println(l);

        // Q2
        System.out.println(simplifyPath("/home//user/Documents/../Pictures"));
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString(s));
        
    }
}
        
    