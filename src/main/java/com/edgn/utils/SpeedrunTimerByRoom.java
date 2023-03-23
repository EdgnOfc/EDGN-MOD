package com.edgn.utils;
public class SpeedrunTimerByRoom {
    public static long startTime;
    public static long splitTime;
    public static long totalTime;

    public static void start() {
        startTime = System.currentTimeMillis();
        splitTime = startTime;
    }

    public static String stop() {
        long endTime = System.currentTimeMillis();
        totalTime += endTime - splitTime;

        long elapsedTime;
        elapsedTime = totalTime;
        long minutes = elapsedTime / (60 * 1000);
        elapsedTime -= minutes * (60 * 1000);
        long seconds = elapsedTime / 1000;
        elapsedTime -= seconds * 1000;
        long milliseconds = elapsedTime;
        totalTime = 0;

        return String.format("%02d:%02d:%03d", minutes, seconds, milliseconds);
    }
}