package main;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            double d = in.nextDouble();
            System.out.println(String.format("%.2f", d));
        }
    }

}
