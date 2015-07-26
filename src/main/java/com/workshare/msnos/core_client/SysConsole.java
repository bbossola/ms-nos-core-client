package com.workshare.msnos.core_client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * A console that works, as on my jdk1.6 Runtime.getConsole() returns null and
 * I'm now really pissed
 */
public class SysConsole implements Console {

    private static SysConsole INSTANCE = new SysConsole();

    public static BufferedReader in;
    public static PrintStream out;
    public static PrintStream err;

    static {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = System.out;
        err = System.err;
    }

    private SysConsole() {
    }

    @Override
    public BufferedReader in() {
        return in;
    }

    @Override
    public PrintStream out() {
        return out;
    }

    @Override
    public PrintStream err() {
        return err;
    }

    public static Console get() {
        return INSTANCE;
    }

}
