package ru.sbt.jschool.session1;

import java.util.Map;

public class Problem3 {
    public static void main(String[] args) {
        Map<String, String> mapVar = System.getenv();
        for (Map.Entry<String, String> pair: mapVar.entrySet()) {
            System.out.println(pair.getKey()+" = "+pair.getValue());
        }
    }
}
