package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.Map;

class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        String amount;
        int sum;

        while (true) {
            try {
                ConsoleHelper.writeMessage("Пожалуйста, введите сумму");
                amount = ConsoleHelper.readString();
                sum = Integer.parseInt(amount);

                if(manipulator.isAmountAvailable(sum)) {
                    try {
                        Map<Integer, Integer> integerIntegerMap = manipulator.withdrawAmount(sum);

                        integerIntegerMap.entrySet().stream()
                                .sorted(Collections.reverseOrder())
                                .forEach(x -> System.out.println(x.getKey() + " - " + x.getValue()));

                        ConsoleHelper.writeMessage("Транзакция была успешна!");
                        break;
                    } catch (NotEnoughMoneyException e) {
                        ConsoleHelper.writeMessage("Недостаточно денег! Попробуйте еще раз");
                        continue;
                    }
                }
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Что-то пошло не так. Попробуйте еще раз.");
                continue;
            }
        }


    }
}
