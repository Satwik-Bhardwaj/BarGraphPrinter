package com.company;

import java.util.Scanner;

public class Main {

    // function which return triple starts to print, if matrix has a star at that place
    public static String graphOrg(int x, int y, char arr[][]){
        if(arr[x][y] == '*'){
            return "***        ";
        } else{
            return "           ";
        }
    }

    public static void main(String[] args) {
        // using a scanner class
        Scanner sc = new Scanner(System.in);

        // defining variables which program will need further
        int x_count, y_count, unit_x, unit_y, x_start, y_start;

        // asking for no of bars to print
        System.out.println("Enter values count you want on x-axis");
        x_count = sc.nextInt();

        // asking for no of units of y to print
        System.out.println("Enter values count you want on y-axis");
        int line_count = y_count = sc.nextInt();

        // asking for values difference on x-axis and y-axis respectively
        System.out.println("Enter single unit of x-axis");
        unit_x = sc.nextInt();

        System.out.println("Enter single unit of y-axis");
        unit_y = sc.nextInt();

        // asking for the values from which all other values will start on x-axis and y-axis respectively
        System.out.println("Enter starting value on x-axis");
        x_start = sc.nextInt();

        System.out.println("Enter starting value on y-axis");
        y_start = sc.nextInt();

        // an integer array to store values of each bar
        int A[] = new int[x_count];

        // asking for values of each bar
        for(int i = 0; i<x_count; i++){
            System.out.println("Enter value of bar at x of " + Integer.toString(i+1) + " :");
            A[i] = (sc.nextInt()+unit_y-y_start)/unit_y;
        }

        // a matrix which store '*' character for making bars
        char graph[][] = new char[y_count][x_count];

        // '*' is allocating in matrix
        for (int i = 0; i<x_count; i++){
            for (int j = y_count-A[i]; j<y_count; j++){
                graph[j][i] = '*';
            }
        }

        // code which prints vertical line and bars
        for (int i = 0; i < y_count; i++) {
            String print_val = String.format("%10s",Integer.toString((line_count * unit_y)-(unit_y-y_start)));
            System.out.print(print_val + " |   ");
            for (int j = 0; j < x_count; j++) {
                System.out.print(graphOrg(i,j,graph));

            }
            line_count--;
            System.out.print("\n");
        }

        // code prints last horizontal line with 0 (zero)
        System.out.print(String.format("%10s", "0") + " |");
        for (int i = 0; i < x_count; i++) {
            System.out.print("-----------");
        }

        // code prints number under horizontal line
        System.out.print("\n" + String.format("%10s", "") + " |");
        System.out.print("   ");
        int num = x_start;
        String num_s = Integer.toString(num);
        for (int i = 0; i < x_count; i++) {

            System.out.print(num_s);

            num+=unit_x;
            num_s = String.format("%11s", num);
        }
    }
}