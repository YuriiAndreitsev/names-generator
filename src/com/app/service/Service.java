package com.app.service;

import com.app.models.Letters;

import java.util.Random;

public class Service {
    private final Letters l;
    private final Random r = new Random();

    public Service(Letters letters) {
        this.l = letters;
    }

    public String generateName() {

        int nameLenth = generateLength(5, 12);
        char[] letters = new char[nameLenth];
        for (int i = 0; i < nameLenth; i++) {
            letters[i] = generateChar();
            if (i > 1) {
                if (l.getVowelsAsList().contains(letters[i - randInt(1, 3)])) {
                    letters[i] = generateConsonant();
                } else if (l.getConsonantsAsList().contains(letters[i - randInt(1, 3)])) {
                    letters[i] = generateVowel();
                }
            }
        }
        letters[0] = Character.toUpperCase(letters[0]);
        return new String(letters);
    }

    private int randInt(int from, int to) {
        return r.ints(from, to)
                .findFirst()
                .getAsInt();
    }

    private int generateLength(int min, int max) {
        return randInt(min, max);
    }

    private char generateChar() {
        return l.getAllLettersShuffled()[randInt(0, l.getAllLettersShuffled().length)];
    }

    private char generateVowel() {
        return l.getVowels()[randInt(0, l.getVowels().length)];
    }

    private char generateConsonant() {
        return l.getConsonants()[randInt(0, l.getConsonants().length)];
    }
}
