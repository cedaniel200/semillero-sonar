package com.cedaniel200.semillero.counter;

import com.cedaniel200.semillero.model.Summary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WordCounterDefault implements WordCounter{
    @Override
    public Summary process(String pathFile) throws IOException {
        Path path = Paths.get(pathFile);
        long numberOfLines = getNumberOfLines(path);
        long numberOfWords = getNumberOfWord(path);
        return new Summary(numberOfLines, numberOfWords);
    }

    private long getNumberOfLines(Path path) throws IOException {
        try(Stream<String> lines = Files.lines(path)){
            return lines.count();
        }
    }

    private long getNumberOfWord(Path path) throws IOException {
        try(Stream<String> lines = Files.lines(path)){
            return lines.map(line -> line.split(" "))
                    .mapToInt(words -> words.length)
                    .sum();
        }
    }
}
