package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String line = null;
        try {
            line = bis.readLine();
            if(line.toLowerCase().equals("exit")){
                throw new InterruptOperationException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage("Введите код валюты");
        String code = readString();
        while (code.length() != 3) {
            writeMessage("Неверные данные.");
            code = readString();
        }
        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
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

    public static Operation askOperation() throws InterruptOperationException{

        int operation = 0;
        Operation resultOperation = null;

        while (true) {
            writeMessage("Введите операцию:");
            try {
                    String operationStr = readString().toLowerCase();
                    operation = Integer.parseInt(operationStr);
                    resultOperation = Operation.getAllowableOperationByOrdinal(operation);
                    break;
            } catch (Exception e) {
                writeMessage("Что-то пошло не так. Попробуйте еще раз.");
                continue;
            }
        }


        return resultOperation;
    }

}
