package org.acme.support;

import java.util.Random;

public class Translator {
    private static final Random random = new Random();

    public static String translate(String originalPhrase) {
        if (originalPhrase != null) {
            StringBuilder phrase = new StringBuilder(originalPhrase.toLowerCase());

            replace(phrase, "hello", hello());
            replace(phrase, "doomed", "cooked");
            replace(phrase, "good", "sigma");
            replace(phrase, "great", "goated");

            maybeAppend(phrase, "skibidi");
            maybeAppend(phrase, "ballerina cappuccina");
            maybeAppend(phrase, "chimpanzini bananini");
            maybeAppend(phrase, "\uD83D\uDC80");
            maybeAppend(phrase, "chicken jockey");

            maybePrepend(phrase, "zang! ");

            if (random.nextBoolean()) {
                phrase.append(" this demo is dog water. ");
            }

            toSentenceCase(phrase);
            return phrase.toString();
        }

        return originalPhrase;
    }

    private static void maybeAppend(StringBuilder phrase, String slang) {
        if (random.nextBoolean()) {
            append(phrase, slang);
        }
    }

    private static void maybePrepend(StringBuilder phrase, String slang) {
        if (random.nextBoolean()) {
            prepend(phrase, slang);
        }
    }

    private static void append(StringBuilder phrase, String slang) {
        replace(phrase, ".", ", " + slang + ".");
    }

    private static void prepend(StringBuilder phrase, String slang) {
        phrase.insert(0, slang);
    }

    private static void replace(StringBuilder builder, String target, String to) {
        if (builder.indexOf(target) >= 0) {
            builder.replace(builder.indexOf(target), builder.indexOf(target) + target.length(), to);
        }
    }

    private static String hello() {
        if (random.nextBoolean()) {
            return "dab me up";
        } else {
            return "what's up";
        }
    }

    public static void toSentenceCase(StringBuilder input) {
        boolean capitalizeNext = true;

        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);

            if (capitalizeNext && Character.isLetter(c)) {
                input.setCharAt(i, Character.toUpperCase(c));
                capitalizeNext = false;
            }

            // After punctuation that ends a sentence, set flag to true
            if (c == '.' || c == '!' || c == '?') {
                capitalizeNext = true;
            }
        }

        replace(input, "quarkus rest", "Quarkus REST");
        replace(input, "quarkus", "Quarkus");
    }
}
