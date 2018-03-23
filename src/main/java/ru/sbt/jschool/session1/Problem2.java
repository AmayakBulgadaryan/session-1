package ru.sbt.jschool.session1;

import java.util.Properties;

public class Problem2 {
    public static void main(String[] args) {
        Properties systemVar = System.getProperties();
        systemVar.list(System.out);

    }

}
