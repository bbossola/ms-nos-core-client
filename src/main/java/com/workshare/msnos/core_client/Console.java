package com.workshare.msnos.core_client;

import java.io.BufferedReader;
import java.io.PrintStream;

public interface Console {

    public BufferedReader in();
    public PrintStream out();
    public PrintStream err();
}