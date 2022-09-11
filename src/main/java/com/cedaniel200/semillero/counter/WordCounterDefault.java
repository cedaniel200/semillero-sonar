package com.cedaniel200.semillero.counter;

import com.cedaniel200.semillero.model.Summary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordCounterDefault implements WordCounter{
    @Override
    public Summary process(String pathFile) throws IOException {
        Path path = Paths.get(pathFile);
        long numberOfLines = Files.lines(path).count();
        long numberOfWords = Files.lines(path)
                .map(line -> line.split(" "))
                .mapToInt(words -> words.length)
                .sum();
        return new Summary(numberOfLines, numberOfWords);
    }
}
