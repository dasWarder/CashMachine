package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Collection;

class InfoCommand implements Command {
    Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
    @Override
    public void execute() throws InterruptOperationException {
        if (manipulators.isEmpty()) {
            ConsoleHelper.writeMessage("No money available.");
        } else {
            for(CurrencyManipulator manipulator : manipulators) {
                if (manipulator.hasMoney()) {
                    ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
                } else {
                    ConsoleHelper.writeMessage("No money available.");
                }
            }
        }

    }
}
