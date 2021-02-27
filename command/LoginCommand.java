package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import org.jsoup.select.Evaluator;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements Command {
    String packagePart = CashMachine.class.getPackage().getName();

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(packagePart + ".resources.verifiedCards", Locale.ENGLISH);


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
                if(validCreditCards.containsKey(cardNum)) {
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