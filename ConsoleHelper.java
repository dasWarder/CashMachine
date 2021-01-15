package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String line = null;
        try {
            line = bis.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    public static String askCurrencyCode() {
        writeMessage("Введите код валюты");
        String code = readString();
        while (code.length() != 3) {
            writeMessage("Incorrect data! Try again.");
            code = readString();
        }
        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        String[] cash;

        while (true) {
            writeMessage("Пожалуйста введите два целых положительных числа!");

            try {
                cash = readString().split(" ");
                if (Integer.parseInt(cash[0]) > 0 && Integer.parseInt(cash[1]) > 0 && cash.length == 2) break;
            } catch (Exception e) {
                writeMessage("Код должен содержать 2 положительных числа!");
                continue;
            }
            writeMessage("Код должен содержать 2 положительных числа!");

        }
        return cash;
    }

}
