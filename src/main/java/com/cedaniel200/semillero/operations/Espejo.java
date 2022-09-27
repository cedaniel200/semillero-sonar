package com.cedaniel200.semillero.operations;

import java.util.Arrays;

public class Espejo {
    public long sum(int... numbers){
        return Arrays.stream(numbers).sum();
    }

    public long count(int... numbers){
        return Arrays.stream(numbers).count();
    }

    public double average(int... numbers){
        return Arrays.stream(numbers).average().orElse(0.0);
    }
}
