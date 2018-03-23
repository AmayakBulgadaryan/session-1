package ru.sbt.jschool.session1;


import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

public class Problem4 {

    public static void main(String[] args) {

        String key = "JSCHOOl1_COUNT", key2 = "JSCHOOL1_PROPERTIES_FILE";
        String[] strings = {};
        Properties properties = System.getProperties();
        Map<String , String> map = System.getenv();

        // 1 пункт:

            for (String line : args) {

                strings = line.split("=");

                if (strings.length == 2) {

                    if (strings[0].equals(key)) {
                            try {

                                for (int i = 0; i < Integer.parseInt(strings[1]); i++) {
                                    System.out.println("Hello, World!");
                                }
                                return;
                            }
                            catch (NumberFormatException e)
                            {

                            }
                    }
                }

            }

        System.out.println("Допустимые параметры отсутствуют. Поиск по системным переменным...");

            // 2 пункт:
            try {

                String value = properties.getProperty(key);

                for (int i = 0; i < Integer.parseInt(value); i++) {
                    System.out.println("Hello, World!");
                }
                return;

            }
            catch (NumberFormatException e)
            {
                System.out.println("Необходимая системная переменная отсутствует или имеет некорректное значение." +
                        " Поиск по переменным окружения...");

                // 3 пункт:
                try {
                    String value = map.get(key);

                    for (int i = 0; i < Integer.parseInt(value); i++) {
                        System.out.println("Hello, World!");
                    }
                    return;
                }
                catch (NumberFormatException e1)
                {
                    System.out.println("Поиск пути файла с настройками...");

                    // 4 пункт:
                    String pathToFile = map.get(key2);
                    Properties props = new Properties();
                    try {
                        props.load(new FileInputStream(pathToFile));
                        String value = props.getProperty(key);

                        for (int i = 0; i < Integer.parseInt(value); i++) {
                            System.out.println("Hello, World!");
                        }
                        return;

                    }
                    catch (Exception e2) {
                        System.out.println("Программа не находит необходимые параметры для работы и будет завершена.");
                    }
                }
            }


    }
}
