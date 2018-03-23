package ru.sbt.jschool.session1;


import java.util.HashSet;

public class AnotherProblems {

    //Первая задача
    public long binaryToDec(String binary)
    {
        if (binary=="" || binary==null)
            return 0;

        long result = 0;
        int power = 0;

        char[] chars = binary.toCharArray();

        try {
            for (int i = chars.length - 1; i >= 0; i--) {
                result += Character.getNumericValue(chars[i]) * Math.pow(2, power);
                power++;
            }
        }
        catch (Exception e)
        {
            System.out.println("Некорректный входной параметр.");
            return 0;
        }
        return result;
    }

    //Вторая задача
    public String sumOfBinary(String b1, String b2)
    {
        String result = "";
        try {
            long first = binaryToDec(b1);
            long second = binaryToDec(b2);

            long sum = first + second;

            StringBuilder line = new StringBuilder();

            long divident = sum, divider = 2;

            while (divident > 1) {
                line.append(divident % divider);
                divident = divident / divider;

            }

            line.append(divident);

             result = line.reverse().toString();
        }
        catch (Exception e)
        {
            System.err.println("Метод не может быть выполнен");
        }

        return result;
    }

    //Третья задача
    public long[] intersection(long[] arr1, long[] arr2)
    {
        /*создаю Сеты для уникализации элементов, что будет полезно при большом количестве повторений в массивах*/

        HashSet<Long> set1 = new HashSet<>();
        HashSet<Long> set2 = new HashSet<>();

        for (long l: arr1) {
            set1.add(l);
        }

        for (long l: arr2) {
            set2.add(l);
        }

        set1.retainAll(set2);

        long[] resultArray = new long[set1.size()];
        int i = 0;

        for (long l: set1) {
            resultArray[i] = l;
            i++;
        }


        return resultArray;
    }



    public static void main(String[] args) {

        AnotherProblems ap = new AnotherProblems();

        String key1 = "100101001", key2 = "101100101001"; //297, 2857

        long l1 = ap.binaryToDec(key1); long l2 = ap.binaryToDec(key2);
        String s = ap.sumOfBinary(key1, key2);

        System.out.println(key1+" -> "+l1);
        System.out.println(key2+" -> "+l2);
        System.out.println(s +" -> " +ap.binaryToDec(s));

        long[] longs1 = {1,2,3,6,5,2,2,5,7,1,3,3,6,7,4,9,6,8};
        long[] longs2 = {1,3,7,10,13,25,9,7,6,34,10,2,3,3,4,8,6,1};
        long[] result = ap.intersection(longs1,longs2);

        for (long l: result) {
            System.out.print(l+" ");
        }
    }
}
