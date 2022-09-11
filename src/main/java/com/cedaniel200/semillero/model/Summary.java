package com.cedaniel200.semillero.model;

public class Summary {
    private final long numberOfLines;
    private final long numberOfWord;

    public Summary(long numberOfLines, long numberOfWord) {
        this.numberOfLines = numberOfLines;
        this.numberOfWord = numberOfWord;
    }

    public long getNumberOfLines() {
        return numberOfLines;
    }

    public long getNumberOfWord() {
        return numberOfWord;
    }

}
