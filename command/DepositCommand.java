package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class DepositCommand implements Command{
    @Override
    public void execute() throws InterruptOperationException {
        String code = null;// спрашиваем код
        code = ConsoleHelper.askCurrencyCode();
        String[] digits = ConsoleHelper.getValidTwoDigits(code);// получаем номинал и количество купюр
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);// выбираем манипулятор
        cm.addAmount(Integer.parseInt(digits[0]), Integer.parseInt(digits[1]));// добавляем введенный номинал и количество купюр
    }
}
