package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.command.LoginCommand;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation = null;
        try {
            CommandExecutor.execute(Operation.LOGIN);
            do {
                try {
                    operation = ConsoleHelper.askOperation();
                    CommandExecutor.execute(operation);
                } catch (InterruptOperationException e) {
                    ConsoleHelper.writeMessage("До свидания!");
                }
            }
            while (!operation.name().equals(Operation.EXIT.name()));
        } catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("Завершено!");
        }
    }

}
