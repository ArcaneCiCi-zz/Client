package net.minecraft.client.misc;


public class UnexpectedThrowable {

    public final String description;
    public final Throwable exception;
    public UnexpectedThrowable(String s, Throwable throwable) {
        description = s;
        exception = throwable;
    }
}
