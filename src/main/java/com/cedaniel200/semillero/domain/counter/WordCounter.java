package com.cedaniel200.semillero.domain.counter;

import com.cedaniel200.semillero.model.Summary;

import java.io.IOException;

public interface WordCounter {
    Summary process(String path) throws IOException;
}
