package com.javarush.task.task26.task2613;

import java.util.Locale;
import java.util.logging.ConsoleHandler;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String code = null;// спрашиваем код
        try {
            code = ConsoleHelper.askCurrencyCode();
            String[] digits = ConsoleHelper.getValidTwoDigits(code);// получаем номинал и количество купюр
            CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);// выбираем манипулятор
            cm.addAmount(Integer.parseInt(digits[0]), Integer.parseInt(digits[1]));// добавляем введенный номинал и количество купюр
            ConsoleHelper.writeMessage(String.valueOf(cm.getTotalAmount()));
            Operation operation = ConsoleHelper.askOperation();
            System.out.println(operation.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
