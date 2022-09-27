package com.cedaniel200.semillero.operations;

import java.util.Arrays;

public class Operator {

    public long sum(int... numbers){
        Arrays.stream(numbers).sum();
        return Arrays.stream(numbers).sum();
    }

    public long count(int... numbers){
        Arrays.stream(numbers).count();
        return Arrays.stream(numbers).count();
    }

    public double average(int... numbers){
        Arrays.stream(numbers).average().orElse(0.0);
        return Arrays.stream(numbers).average().orElse(0.0);
    }

    public long sum2(int... numbers){
        Arrays.stream(numbers).sum();
        return Arrays.stream(numbers).sum();
    }

    public long count2(int... numbers){
        Arrays.stream(numbers).count();
        return Arrays.stream(numbers).count();
    }

    public double average2(int... numbers){
        Arrays.stream(numbers).average().orElse(0.0);
        return Arrays.stream(numbers).average().orElse(0.0);
    }
}
