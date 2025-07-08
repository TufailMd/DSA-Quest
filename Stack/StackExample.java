// package Stack;

// import java.util.*;
// public class StackCW{
    
//     public static void main(String[] args){
//         Stack stack = new Stack();
//         stack.push(1);
//         stack.push(2);
//         stack.push(3);
//         stack.push(4);
//         System.out.print("Stack: ");
//         stack.viewStack();
//         System.out.println("Pop: " + stack.pop());
//         System.out.print("Stack: ");
//         stack.viewStack();
//         System.out.println("Peek: " + stack.peek());
//         System.out.print("Stack: ");
//         stack.viewStack();
//     }
// }

// class Stack{
//     LinkedList<Integer> list = new LinkedList<Integer>();
//     public boolean isEmpty(){
//         return list.isEmpty();
//     }
//     public void push(int data){    
//         list.addLast(data);
//     }

//     public int pop(){
//         if (isEmpty()) {
//             System.out.println("Stack is Empty");
//             return 0;
//         }
//         return list.removeLast();
//     }
//     public int peek(){
//         return list.getLast();
//     }
//     public void viewStack(){
//         System.out.print(list+"\n");
//     }
// }

// optimized
package Stack;

import java.util.*;

public class StackExample {
    public static void main(String[] args) {
        // @SuppressWarnings("rawtypes")
        StackA stk = new StackA();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        System.out.print("Stack: ");
        stk.viewStack();
        System.out.println("Pop: " + stk.pop());
        System.out.print("Stack: ");
        stk.viewStack();
        System.out.println("Peek: " + stk.peek());
        System.out.print("Stack: ");
        stk.viewStack();
        System.out.println("Pop: " + stk.pop());
        System.out.println("Pop: " + stk.pop());
        System.out.println("Pop: " + stk.pop());
        System.out.println("Pop: " + stk.pop());
        stk.push(2);
        stk.viewStack();
    }
}

class StackA<T> {
    private LinkedList<T> list = new LinkedList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(T data) {
        list.addLast(data);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is Empty");
        }
        return list.removeLast();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is Empty");
        }
        return list.getLast();
    }

    public void viewStack() {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    static class EmptyStackException extends RuntimeException {
        public EmptyStackException(String message) {
            super(message);
        }
    }
}
