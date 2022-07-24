package com.example.twotasksb2.tasks;

import com.example.twotasksb2.utils.pojos.InputOneRequestPojo;
import com.example.twotasksb2.utils.pojos.Option;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Object of task one - strings from array one included in strings from array two in lexicographical order
 */
@AllArgsConstructor
public class TaskOne implements Task{
    private final InputOneRequestPojo input;

    @Override
    public String calculate() {
        List<String> two = input.getTwo().stream().map(Option::getLabel).collect(Collectors.toList());
        Predicate<String> isInTwo = s -> two.stream().anyMatch(t -> t.contains(s));

        String res = input.getOne().stream()
                .map(Option::getLabel)
                .filter(isInTwo) // filter string by containing in any string from list two
                .sorted(String::compareTo) // lexicographically sorted (default for strings)
                .collect(Collectors.joining(", "));
        return res.isEmpty() ? "No strings from array one are contained in strings of array two" : res;
    }
}
