package com.example.twotasksb2.utils;

import com.example.twotasksb2.utils.pojos.InputOneRequestPojo;
import com.example.twotasksb2.utils.pojos.InputTwoRequestPojo;
import com.example.twotasksb2.utils.pojos.Option;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Class for any adapter design pattern implementations
 */
public class AdapterUtils {

    /**
     *  Converts TaskPojo to a bit more beautiful string than it's JSON view
     */
    public static String beautyVersion(TaskPojo pojo){
        if (pojo instanceof InputOneRequestPojo) {
            InputOneRequestPojo p = (InputOneRequestPojo) pojo;
            return "First array: " + p.getOne().stream().map(Option::getLabel).collect(Collectors.joining(", "))
                    + "\nSecond array: " + p.getTwo().stream().map(Option::getLabel).collect(Collectors.joining(", "));
        }
        if (pojo instanceof InputTwoRequestPojo) {
            InputTwoRequestPojo p = (InputTwoRequestPojo) pojo;
            return stringFromSquare(p.getCurrentData());
        }
        return "Error at beautifying extracted input";
    }

    /**
     *  Converts JSON to InputOneRequestPojo
     */
    public static InputOneRequestPojo getPojoForTaskOne(String s){
        ObjectMapper mapper = new ObjectMapper();
        InputOneRequestPojo ans = null;
        try {
            ans = mapper.readValue(s, InputOneRequestPojo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ans;
    }

    /**
     *  Converts JSON to InputTwoRequestPojo
     */
    public static InputTwoRequestPojo getPojoForTaskTwo(String s){
        ObjectMapper mapper = new ObjectMapper();
        InputTwoRequestPojo ans = null;
        try {
            ans = mapper.readValue(s, InputTwoRequestPojo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ans;
    }

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
