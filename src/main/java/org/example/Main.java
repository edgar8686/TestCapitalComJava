package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        ArrayList<String> elements = new ArrayList<>();
        elements.add("1");
        elements.add("2");
        elements.add("3");
        elements.add("4");
        elements.add("5");
        for (var element : elements) {
            System.out.println(element);
        }
        int randomIndex = random.nextInt(elements.size());
        String randomElement = elements.get(randomIndex);
        System.out.println(elements.size());

        System.out.println("Случайный элемент: " + randomElement);

    }
}