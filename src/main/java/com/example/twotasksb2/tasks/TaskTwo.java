package com.example.twotasksb2.tasks;

import com.example.twotasksb2.utils.AdapterUtils;
import com.example.twotasksb2.utils.SquareChecks;
import com.example.twotasksb2.utils.pojos.InputTwoRequestPojo;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class TaskTwo implements Task{
    private final InputTwoRequestPojo input;

    @Override
    public String calculate(){
        List<List<Long>> initial = input.getCurrentData();
        List<List<List<Long>>> halfSuspects = bruteForceForHalfMagic(initial);
        List<List<List<Long>>> pureSuspects = filterPureMagic(halfSuspects);
        List<List<Long>> ans = null;
        if (pureSuspects.size() > 0) {
            ans = pureSuspects.stream()
                    .sorted(Comparator.comparingLong(t -> calculateCost(initial, t)))
                    .collect(Collectors.toList())
                    .get(0);
            return "Magic square\n" + AdapterUtils.stringFromSquare(ans) + "\nCost: " + calculateCost(initial, ans);
        } else if (halfSuspects.size() > 0) {
            ans = halfSuspects.stream()
                    .sorted(Comparator.comparingLong(t -> calculateCost(initial, t)))
                    .collect(Collectors.toList())
                    .get(0);
            return "Half magic square\n" + AdapterUtils.stringFromSquare(ans) + "\nCost: " + calculateCost(initial, ans);
        }

        return "No magic square with given values exists";
    }

    private Long calculateCost(List<List<Long>> a, List<List<Long>> b){
        List<Long> res = new ArrayList<>(),
                t1 = AdapterUtils.inlineCopyFromSquare(a),
                t2 = AdapterUtils.inlineCopyFromSquare(b);
        for (int i = 0; i < t1.size(); ++i) {
            res.add(Math.abs(t1.get(i) - t2.get(i)));
        }
        return res.stream().reduce((accum, l) -> accum += l).orElse(null);
    }

    // separates pure magic squares from half magic ones
    private List<List<List<Long>>> filterPureMagic(List<List<List<Long>>> a){
        return a.stream().filter(SquareChecks::isPureMagic).collect(Collectors.toList());
    }

    // creates all squares possible and searches for half magic ones
    private List<List<List<Long>>> bruteForceForHalfMagic(List<List<Long>> a){
        List<Long> b = AdapterUtils.inlineCopyFromSquare(a).stream().sorted(Long::compareTo).collect(Collectors.toList());
        List<List<List<Long>>> res = new ArrayList<>();
        do {
            List<List<Long>> t = AdapterUtils.squareCopyFromInline(b);
            if (SquareChecks.isHalfMagicSquare(t))
                res.add(t);
        } while (nextPermutation(b));

        return res;
    }

    // generates the next iteration of order change
    boolean nextPermutation(List<Long> p) {
        for (int a = p.size() - 2; a >= 0; --a)
            if (p.get(a) < p.get(a + 1))
                for (int b = p.size() - 1;; --b)
                    if (p.get(b) > p.get(a)) {
                        Long t = p.get(a);
                        p.set(a, p.get(b));
                        p.set(b, t);
                        for (++a, b = p.size() - 1; a < b; ++a, --b) {
                            t = p.get(a);
                            p.set(a, p.get(b));
                            p.set(b, t);
                        }
                        return true;
                    }
        return false;
    }
}
