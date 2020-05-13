package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestList {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        LinkedList<Integer> link = new LinkedList<>();

        st.push(1);
        st.push(2);
        st.pop();

        q.add(1);
        q.offer(2);
        q.remove();
        q.poll();
//        q.peek();
//        q.element();

        link.add(1);
        link.offer(2);
        link.offerFirst(3);
        link.offerLast(4);
        link.push(5);
        link.push(6);

        link.remove();
        link.poll();
        link.pollFirst();
        link.pollLast();
        link.pop();


    }


}
