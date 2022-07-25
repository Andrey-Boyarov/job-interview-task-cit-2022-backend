package com.example.twotasksb2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *  Class for checks of squares properties
 */
public class SquareChecks {
    /**
     *  Checks confirmed half magic square if it is a pure magic square
     */
    public static boolean isPureMagic(List<List<Long>> a){
        return equalsAndPresent(checkRowsSums(a), checkDiagonalsSums(a));
    }

    /**
     *  Checks any square if it is a half magic square
     */
    public static boolean isHalfMagicSquare(List<List<Long>> a){
        return equalsAndPresent(checkRowsSums(a), checkColumnsSums(a));
    }

    private static Long checkDiagonalsSums(List<List<Long>> a){
        Long sum1 = 0L, sum2 = 0L;
        for (int i = 0; i < a.size(); ++i){
            sum1 += a.get(i).get(i);
            sum2 += a.get(i).get(a.size() - 1 - i);
        }
        return sum1.equals(sum2) ? sum1 : null;
    }

    private static Long checkColumnsSums(List<List<Long>> a){
        List<List<Long>> b = new ArrayList<>();
        for (int i = 0; i < a.size(); ++i) {
            List<Long> t = new ArrayList<>();
            for (List<Long> longs : a) t.add(longs.get(i));
            b.add(t);
        }
        return checkRowsSums(b);
    }


    private static Long checkRowsSums(List<List<Long>> a){
        Long sum = countListSum(a.get(0));
        return a.stream().skip(1).map(SquareChecks::countListSum).allMatch(t -> t.equals(sum)) ? sum : null;
    }

    private static Long countListSum(List<Long> list){
        return list.stream().reduce((accum, t) -> accum += t).orElse(null);
    }

    private static boolean equalsAndPresent(Object a, Object b){
        return Objects.equals(a, b) && a != null;
    }
}
