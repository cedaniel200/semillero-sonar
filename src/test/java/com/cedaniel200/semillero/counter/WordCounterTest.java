package com.cedaniel200.semillero.counter;

import com.cedaniel200.semillero.model.Summary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {
    @Test
    void mustReturnCorrectSummary() throws IOException {
        Path resourceDirectory = Paths.get("src","test","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        WordCounter wordCounter = new WordCounterDefault();

        Summary summary = wordCounter.process(absolutePath + File.separator + "test.txt");

        Assertions.assertEquals(2, summary.getNumberOfLines());
        Assertions.assertEquals(5, summary.getNumberOfWord());
    }

    @Test
    void mustThromsIOExceptionWhenFileNotFound() throws IOException {
        IOException thrown = assertThrows(
                IOException.class,
                () -> {
                    Path resourceDirectory = Paths.get("src","test","resources");
                    String absolutePath = resourceDirectory.toFile().getAbsolutePath();
                    WordCounter wordCounter = new WordCounterDefault();

                    Summary summary = wordCounter.process(absolutePath + File.separator + "test23.txt");
                },
                "Expected doThing() to throw, but it didn't"
        );

        assertNotNull(thrown.getMessage());
    }

}
