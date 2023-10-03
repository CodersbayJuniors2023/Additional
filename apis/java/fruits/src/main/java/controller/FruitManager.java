package controller;

import com.google.gson.Gson;
import model.Fruit;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class FruitManager {

    public static String getFruitsAsJSON() {
        return new Gson().toJson(getFruits());
    }

    public static String getFruitByNameJSON(String name) {
        Fruit fruit = getFruitByName(name);
        if (fruit == null) {
            throw new NoSuchElementException("Fruit not found");
        }

        return new Gson().toJson(fruit);
    }


    private static Fruit getFruitByName(String name) {
        return Arrays.stream(getFruits()).filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    private static Fruit[] getFruits() {
        return new Fruit[]{
                new Fruit("Apple", "Red"),
                new Fruit("Banana", "Yellow"),
                new Fruit("Orange", "Orange"),
                new Fruit("Grapes", "Purple")
        };
    }
}
