package com.app;

import com.app.models.Letters;
import com.app.service.CombinationsService;
import com.app.service.Service;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Letters l = new Letters();
        Service s = new Service(l);
        CombinationsService cs = new CombinationsService();
        Stream.generate(()-> cs.generateName()+" "+cs.generateName()).limit(101).forEach(System.out::println);
//        System.out.println(cs.generateName());
//        Stream.generate(()-> s.generateName()+" "+s.generateName()).limit(101).forEach(System.out::println);
//        System.out.println(s.generateChar());
//        System.out.println(Arrays.toString(l.getAllLettersShuffled()));
    }
}
