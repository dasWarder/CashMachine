package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

public class LoginCommand implements Command {
    private String cardNumber = "123456789012";
    private String cardPin = "1234";


    @Override
    public void execute() throws InterruptOperationException {


        while (true) {
            ConsoleHelper.writeMessage("Введите номер карты и пин:");
            String cardNum = ConsoleHelper.readString();
            String cardPinCode = ConsoleHelper.readString();

            if(cardNum == null || !cardNum.trim().matches("\\d{12}") ||
                    cardPinCode == null || !cardPinCode.trim().matches("\\d{4}")) {
                ConsoleHelper.writeMessage("Вы ввели некорректные данные! Попробуйте снова!");
                continue;
            } else {
                if(cardNum.equals(cardNumber) && cardPinCode.equals(cardPin)) {
                    ConsoleHelper.writeMessage("Валидация прошла успешно!");
                    break;
                } else {
                    ConsoleHelper.writeMessage("Ошибка валидации! Попробуйте еще раз!");
                    continue;
                }
            }
        }
    }
}