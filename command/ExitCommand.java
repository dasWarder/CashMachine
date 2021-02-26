package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class ExitCommand implements Command{
    @Override
    public void execute() throws InterruptOperationException {
        String answer;
        ConsoleHelper.writeMessage("Вы дейтвительно хотите выйти? y | n");
        answer = ConsoleHelper.readString();

        if(answer.equals("y")) {
            ConsoleHelper.writeMessage("До свидания!");
        }
    }
}
