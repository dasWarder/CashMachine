package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;

import java.util.Locale;
import java.util.logging.ConsoleHandler;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation = null;
        do {
            operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);
        }
        while(!operation.name().equals(Operation.EXIT.name()));
    }

}
