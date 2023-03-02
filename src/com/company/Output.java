package com.company;

public class Output {
    private static String res;

    public Output(String res) {
        Output.res = res;
    }

    public static String getRes() {
        return res;
    }
}
