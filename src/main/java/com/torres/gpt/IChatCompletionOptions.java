package com.torres.gpt;

public class IChatCompletionOptions {
    private boolean debug;
    private String model;
    private boolean stream;
    private int chunkSize;

    

    public IChatCompletionOptions(boolean debug, String model, boolean stream, int chunkSize) {
        this.debug = debug;
        this.model = model;
        this.stream = stream;
        this.chunkSize = chunkSize;
    }

    public String getModel() {
        return model;
    }

    public boolean isStream() {
        return stream;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }

    public int getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
    }

}

