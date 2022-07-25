package com.example.twotasksb2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *  Class for any adapter design pattern implementations
 */
public class AdapterUtils {
    /**
     *  Returns square from a flat list
     */
    public static List<List<Long>> squareCopyFromInline(List<Long> a){
        int size = (int) Math.sqrt(a.size());
        List<List<Long>> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i += size) res.add(List.copyOf(a.subList(i, i + size)));
        return res;
    }

    /**
     *  Returns copy of list of values from square
     */
    public static List<Long> inlineCopyFromSquare(List<List<Long>> a){
        return copySquare(a).stream()
                .reduce(new ArrayList<>(), (accum, l) -> {
                    accum.addAll(l);
                    return accum;
                });
    }

    /**
     *  Returns string view of square
     */
    public static String stringFromSquare(List<List<Long>> a){
        return a.stream()
                .map(b -> b.stream()
                        .map(Object::toString)
                        .reduce("", (accum, l) -> accum + " " + l))
                .reduce("", (accum, row) -> accum + row + "\n");
    }

    private static List<List<Long>> copySquare(List<List<Long>> a){
        List<List<Long>> res = new ArrayList<>();
        for (List<Long> t: a) {
            res.add(List.copyOf(t));
        }
        return res;
    }
}
