package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
    static String[] ingredients = {"tomoatoe", "Cucmber"};
    int it = 0;
    public List<List<String>> createMenu(String[] inputs){
        if(inputs == null){
            return null;
        }
        List<List<String>> menu = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        menu.add(curr);


        build(menu, curr, 0, inputs);

        return menu;
    }

    public void build(List<List<String>> menu, List<String> curr, int index, String[] inputs){
        //it++;
        if(index == inputs.length){
            return;
        }
        for(int i=index; i< inputs.length; i++){
            curr.add(inputs[i]);
            menu.add(new ArrayList(curr));
            build(menu, curr, i+1, inputs);
            curr.remove(curr.size() - 1);
        }

    }
    public static void main(String[] args) {
        Combination c = new Combination();
        System.out.println(c.it);
        System.out.println(Arrays.asList(c.createMenu(ingredients)));
    }
}

