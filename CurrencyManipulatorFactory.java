package com.javarush.task.task26.task2613;

import java.util.*;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if(map.containsKey(currencyCode)) {
            return map.entrySet().stream().filter(k -> k.getKey().equals(currencyCode))
                    .map(k -> k.getValue()).findFirst().orElse(null);
        }
        CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
        map.put(currencyCode, manipulator);
        return manipulator;
    }
}
