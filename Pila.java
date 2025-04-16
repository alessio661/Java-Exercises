package pilaordinata;

import java.util.*;

public class Pila {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        String s = "Get my string";

        reverse(queue);
        System.out.println(queue.toString());
        System.out.println(reverse(s));
    }

    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            Integer e = queue.remove();
            stack.push(e);
        }
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    public static String reverse(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
            stack.push(String.valueOf(s.charAt(i)));

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();
    }
}
