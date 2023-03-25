package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String s : list) {
                if (!(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            int sizeSnapshot = list.size();
            for (int i = 0; i < sizeSnapshot; i++) {
                Integer element = list.get(i);
                if (element % 2 == 0) {
                    list.add(element);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(s -> s.charAt(0) >= 'A' && s.charAt(0) <= 'Z'
                        && s.charAt(s.length() - 1) == '.'
                        && s.chars().filter(c -> c == ' ').count() > 2
                )
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> list.stream()
                .collect(Collectors.toMap(s -> s, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>();
            result.addAll(list1);
            result.addAll(list2);
            return result;
        };
    }
}
