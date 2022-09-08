package main.java;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("**PRIME NUMBER CHECKER**");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a file path"); //C:\vzorek_dat.xlsx
        String path = sc.nextLine();

        List listOfPrimeNumbers = Programs.checkForPrimeNumbersInFile(path);

        if (listOfPrimeNumbers != null) {
            for (Object number : listOfPrimeNumbers) {
                System.out.println(number);
            }
        }

    }


}