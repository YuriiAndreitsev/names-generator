package com.app.models;

import java.util.List;

public class LettersCombinations {
    private final List<String> combinations = List.of("he", "an", "he", "te", "an", "se", "in", "me", "er", "sa", "nd", "ne", "re", "wa", "ed", "ve", "es", "le", "ou", "no", "to", "ta", "ha", "al", "en", "de", "ea", "ot", "st", "so", "nt", "dt", "on", "ll", "at", "tt", "hi", "el", "as", "ro", "it", "ad", "ng", "di", "is", "ew", "or", "ra", "et", "ri", "of", "sh");
    private final List<String> consCons = List.of("sh", "dt", "st", "tt", "ll", "ng", "nt", "nd");
    private final List<String> vowelCons = List.of("of", "an", "in", "er", "ed", "es", "al", "ot", "on", "at", "el", "as", "it", "ad", "is",
            "or", "et");


    public List<String> getConsCons() {
        return consCons;
    }

    public List<String> getVowelCons() {
        return vowelCons;
    }

    public List<String> getCombinations() {
        return combinations;
    }
}
