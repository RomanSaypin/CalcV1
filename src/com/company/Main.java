package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите выражение:");
            String input = sc.nextLine();
            System.out.println(clac(input));
            sc.close();
    }

    public static String clac(String input) throws Exception {
        new DataProcessor(input);
        DataProcessor.splittingTheIntroductoryLine();
        return Output.getRes();
    }
}
