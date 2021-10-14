package com.app.service;

import com.app.models.Letters;
import com.app.models.LettersCombinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CombinationsService {
    private final LettersCombinations lettersCombinations = new LettersCombinations();
    private final Letters l = new Letters();
    private final Random r = new Random();

    public String generateName() {
        int nameLenth = generateLength(2, 6);
        List<String> name = new ArrayList<>();
        for (int i = 0; i < nameLenth; i++) {
            String comb = getRandomCombination();
            if (i == 0 &&  lettersCombinations.getConsCons().contains(comb)&&!comb.equals("sh")) {
                comb = getRandomCombination(lettersCombinations.getVowelCons());
            }
            if (i > 0) {
                Character lastCharOfPrev = name.get(i - 1).charAt(comb.length() - 1);
                if (l.getConsonantsAsList().contains(lastCharOfPrev) ) {
                    comb = getRandomCombination(lettersCombinations.getVowelCons());
                }
            }
            name.add(comb);
        }
        String replaceFirst = name.get(0);
        String res = Character.toUpperCase(replaceFirst.charAt(0)) + replaceFirst.substring(1);
        name.set(0, res);
        return name.stream().reduce("", String::concat);
    }

    private int generateLength(int min, int max) {
        return randInt(min, max);
    }


    private String getRandomCombination() {
        return lettersCombinations.getCombinations().get(randInt(0, lettersCombinations.getCombinations().size()));
    }

    private String getRandomCombination(List<String> alternative) {
        return alternative.get(randInt(0, alternative.size()));
    }

    private int randInt(int from, int to) {
        return r.ints(from, to)
                .findFirst()
                .getAsInt();
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
