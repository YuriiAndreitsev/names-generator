package com.app.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.mapping;

public class Letters {
    private final Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u', 'y'};
    private final Character[] consonants = new Character[]{'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};

    public Character[] getVowels() {
        return vowels;
    }

    public Character[] getConsonants() {
        return consonants;
    }

    public List<Character> getVowelsAsList() {
        return List.of(vowels);
    }

    public List<Character> getConsonantsAsList() {
        return List.of(consonants);
    }

    public Character[] getAllLettersShuffled() {
        Stream<Character[]> listOfStreams = Stream.of(vowels, consonants, vowels, vowels);
        List<Character> chars = listOfStreams.flatMap(Stream::of).collect(Collectors.toList());
        Collections.shuffle(chars);
        return chars.toArray(Character[]::new);
    }
}
