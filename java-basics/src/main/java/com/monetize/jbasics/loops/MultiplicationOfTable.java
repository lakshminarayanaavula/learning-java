package com.monetize.jbasics.loops;
import java.util.Scanner;

public class MultiplicationOfTable {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the num: ");
    int num = sc.nextInt();
    printTable(num);
  }
  private static void printTable(int num){
      for(int i=1;i<=10;i++){
        System.out.println(num+" * "+ i+ " = "+(num*i));
      }
  }
}
