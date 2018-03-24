package ru.sbt.jschool.session1;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

public class ValueSearcher implements PropertyHelper {


    private String[] args;

    private String path;

    private String value;

    private boolean isDouble;

    private boolean isInteger;



    public ValueSearcher(String[] args, String path)
    {
        this.args = args;
        this.path = path;
    }


    private void checkByType(String value)
    {
        try {
            Integer.parseInt(value);
            isInteger = true; return;
        } catch (NumberFormatException e) {

        }
        try {
            Double.parseDouble(value);
            isDouble = true; return;
        } catch (NumberFormatException e) {

        }
    }


    private void searchInArgs(String name)
    {
        String[] strings = {};

        for (String arg: args) {

            strings = arg.split("=");

            if (strings.length==2)
                if (strings[0].equals(name))
                    value = strings[1];
                    return;
        }
    }

    @Override
    public String stringValue(String name) {

        searchInArgs(name);

        if (value != null) {
            checkByType(value);
            if (isInteger) {
                System.out.println("Используйте метод integerValue");
                return null;
            }
            if (isDouble) {
                System.out.println("Используйте метод doubleValue");
                return null;
            }

            return value;

        } else {
            Properties properties = System.getProperties();
            value = properties.getProperty(name);
            if (value != null) {
                checkByType(value);
                if (isInteger) {
                    System.out.println("Используйте метод integerValue");
                    return null;
                }
                if (isDouble) {
                    System.out.println("Используйте метод doubleValue");
                    return null;
                }

                return value;
            }
            else
            {
                Map<String , String> map = System.getenv();
                value = map.get(name);
                if (value != null) {
                    checkByType(value);
                    if (isInteger) {
                        System.out.println("Используйте метод integerValue");
                        return null;
                    }
                    if (isDouble) {
                        System.out.println("Используйте метод doubleValue");
                        return null;
                    }

                    return value;
                }
                else {
                    Properties props = new Properties();
                    try {
                        props.load(new FileInputStream(path));
                        value = props.getProperty(name);
                        if (value!= null)
                        {
                            checkByType(value);
                            if (isInteger) {
                                System.out.println("Используйте метод integerValue");
                                return null;
                            }
                            if (isDouble) {
                                System.out.println("Используйте метод doubleValue");
                                return null;
                            }

                            return value;
                        }
                    }
                    catch (Exception e)
                    {

                    }
                }
            }


        }
        return null;
    }

    @Override
    public Integer integerValue(String name) {

        searchInArgs(name);

        if (value != null) {
            checkByType(value);
            if (isInteger) {

                return Integer.parseInt(value);
            }
            if (isDouble) {
                System.out.println("Используйте метод doubleValue");
                return null;
            }
            System.out.println("Используйте метод stringValue");
            return null;

        } else {
            Properties properties = System.getProperties();
            value = properties.getProperty(name);
            if (value != null) {
                checkByType(value);
                if (isInteger) {

                    return Integer.parseInt(value);
                }
                if (isDouble) {
                    System.out.println("Используйте метод doubleValue");
                    return null;
                }
                System.out.println("Используйте метод stringValue");
                return null;
            }
            else
            {
                Map<String , String> map = System.getenv();
                value = map.get(name);
                if (value != null) {
                    checkByType(value);
                    if (isInteger) {

                        return Integer.parseInt(value);
                    }
                    if (isDouble) {
                        System.out.println("Используйте метод doubleValue");
                        return null;
                    }
                    System.out.println("Используйте метод stringValue");
                    return null;
                }
                else {
                    Properties props = new Properties();
                    try {
                        props.load(new FileInputStream(path));
                        value = props.getProperty(name);
                        if (value!= null)
                        {
                            checkByType(value);
                            if (isInteger) {

                                return Integer.parseInt(value);
                            }
                            if (isDouble) {
                                System.out.println("Используйте метод doubleValue");
                                return null;
                            }
                            System.out.println("Используйте метод stringValue");
                            return null;
                        }
                    }
                    catch (Exception e)
                    {

                    }
                }
            }


        }
        return null;
    }

    @Override
    public Double doubleValue(String name) {
        searchInArgs(name);

        if (value != null) {
            checkByType(value);
            if (isInteger) {
                System.out.println("Используйте метод integerValue");
                return null;
            }
            if (isDouble) {
                return Double.parseDouble(value);
            }
            System.out.println("Используйте метод stringValue");
            return null;

        } else {
            Properties properties = System.getProperties();
            value = properties.getProperty(name);
            if (value != null) {
                checkByType(value);
                if (isInteger) {
                    System.out.println("Используйте метод integerValue");
                    return null;
                }
                if (isDouble) {
                    return Double.parseDouble(value);
                }
                System.out.println("Используйте метод stringValue");
                return null;
            }
            else
            {
                Map<String , String> map = System.getenv();
                value = map.get(name);
                if (value != null) {
                    checkByType(value);
                    if (isInteger) {
                        System.out.println("Используйте метод integerValue");
                        return null;
                    }
                    if (isDouble) {
                        return Double.parseDouble(value);
                    }
                    System.out.println("Используйте метод stringValue");
                    return null;
                }
                else {
                    Properties props = new Properties();
                    try {
                        props.load(new FileInputStream(path));
                        value = props.getProperty(name);
                        if (value!= null)
                        {
                            checkByType(value);
                            if (isInteger) {
                                System.out.println("Используйте метод integerValue");
                                return null;
                            }
                            if (isDouble) {
                                return Double.parseDouble(value);
                            }
                            System.out.println("Используйте метод stringValue");
                            return null;
                        }
                    }
                    catch (Exception e)
                    {

                    }
                }
            }


        }
        return null;
    }
}
