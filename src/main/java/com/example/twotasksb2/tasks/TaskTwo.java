package com.example.twotasksb2.tasks;

import com.example.twotasksb2.utils.pojos.InputTwoRequestPojo;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class TaskTwo implements Task{
    private final InputTwoRequestPojo input;

    @Override
    public String calculate(){
        return "calculated task two";
    }








    private boolean isMagicSquare(List<List<Long>> a){
        return isHalfMagicSquare(a) && checkDiagonalsSums(a);
    }

    private boolean isHalfMagicSquare(List<List<Long>> a){
        return checkRowsSums(a) && checkColumnsSums(a);
    }

    private boolean checkDiagonalsSums(List<List<Long>> a){
        Long sum1 = 0L, sum2 = 0L;
        for (int i = 0; i < a.size(); ++i){
            sum1 += a.get(i).get(i);
            sum2 += a.get(i).get(a.size() - 1 - i);
        }
        return sum1.equals(sum2);
    }

    private boolean checkColumnsSums(List<List<Long>> a){
        List<List<Long>> b = new ArrayList<>();
        for (int i = 0; i < a.size(); ++i) {
            List<Long> t = new ArrayList<>();
            for (List<Long> longs : a) t.add(longs.get(i));
            b.add(t);
        }
        return checkRowsSums(b);
    }


    private boolean checkRowsSums(List<List<Long>> a){
        Long sum = countListSum(a.get(0));
        return a.subList(1, a.size() - 1).stream().map(this::countListSum).allMatch(t -> t.equals(sum));
    }

    private Long countListSum(List<Long> list){
        return list.stream().reduce((accum, t) -> accum += t).orElse(null);
    }
}
