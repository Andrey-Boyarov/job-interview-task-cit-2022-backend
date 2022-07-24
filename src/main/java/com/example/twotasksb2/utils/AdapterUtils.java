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
        for (int i = 0; i < a.size(); i += size) res.add(a.subList(i, i + size));
        return res;
    }

    /**
     *  Returns sorted copy of list of values from square
     */
    public static List<Long> inlineCopyFromSquare(List<List<Long>> a){
        return Objects.requireNonNull(List.copyOf(a).stream()
                .reduce((accum, l) -> {
                    accum.addAll(l);
                    return accum;
                })
                .orElse(null)).stream()
                .sorted(Long::compareTo)
                .collect(Collectors.toList());
    }

}
