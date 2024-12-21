package me.eren.beatblockeditor;

public class Condition {

    public static void check(boolean desired, String message) {
        if (!desired)
            throw new IllegalArgumentException(message);
    }

}
