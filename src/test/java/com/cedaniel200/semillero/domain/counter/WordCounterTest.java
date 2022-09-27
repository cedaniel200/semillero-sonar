package com.cedaniel200.semillero.domain.counter;

import com.cedaniel200.semillero.model.Summary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    private WordCounter wordCounter;
    private String absolutePath;

    @BeforeEach
    public void setup(){
        Path resourceDirectory = Paths.get("src","test","resources");
        absolutePath = resourceDirectory.toFile().getAbsolutePath();
        wordCounter = new WordCounterDefault();
    }

    @Test
    void mustReturnCorrectSummary() throws IOException {
        Summary summary = wordCounter.process(absolutePath + File.separator + "test.txt");

        assertNotNull(summary);
        Assertions.assertEquals(2, summary.getNumberOfLines());
        Assertions.assertEquals(5, summary.getNumberOfWord());
    }

    @Test
    void mustThrowsIOExceptionWhenFileNotFound() {
        IOException thrown = assertThrows(
                IOException.class,
                () -> {
                    Summary summary = wordCounter.process(absolutePath + File.separator + "test23.txt");
                },
                "Expected doThing() to throw, but it didn't"
        );

        assertNotNull(thrown.getMessage());
    }

}
