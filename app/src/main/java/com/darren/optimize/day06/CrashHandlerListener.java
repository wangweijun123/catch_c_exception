package com.darren.optimize.day06;

public interface CrashHandlerListener {
    void onCrash(String threadName, Error error);
}
