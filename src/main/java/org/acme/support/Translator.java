package org.acme.support;

import java.util.Random;

public class Translator {
    private static final Random random = new Random();

    public static String translate(String phrase) {
        if (phrase != null) {
            phrase = phrase.toLowerCase();
            phrase = phrase.replaceAll("hello", hello());
            phrase = phrase.replaceAll("doomed", "cooked");
            phrase = phrase.replaceAll("good", "sigma");

            if (random.nextBoolean()) {
                phrase = phrase + ", skibidi";
            }
            if (random.nextBoolean()) {
                phrase = phrase + ", ballerina cappuccina";
            }
            if (random.nextBoolean()) {
                phrase = phrase + ", chimpanzini bananini";
            }
            if (random.nextBoolean()) {
                phrase = phrase + ", chicken jockey";
            }
            if (random.nextBoolean()) {
                phrase = "zang! " + phrase;
            }
            if (random.nextBoolean()) {
                phrase = phrase + ". this demo is dog water.";
            }

            phrase = toSentenceCase(phrase);
        }

        return phrase;
    }

    private static String hello() {
        if (random.nextBoolean()) {
            return "dab me up";
        } else {
            return "what's up";
        }
    }

    public static String toSentenceCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (capitalizeNext && Character.isLetter(c)) {
                result.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                result.append(Character.toLowerCase(c));
            }

            // After punctuation that ends a sentence, set flag to true
            if (c == '.' || c == '!' || c == '?') {
                capitalizeNext = true;
            }
        }

        return result.toString().replaceAll("quarkus rest", "Quarkus REST").replaceAll("quarkus", "Quarkus");
    }
}
