package rx.create;

import io.reactivex.Observable;

/*
 * throws an exception...
 *
 * seems simple enough, but wait, where's the catch?
 */
public class ThrowExplained {

    public static void main(String[] args) {
        error();
        try {
            the_trick();
        } catch (Throwable t) {
            System.out.println("can I catch it?");
        }
    }

    public static void error() {
        try {
            Observable.error(new Exception("something went wrong")).subscribe(e -> System.out.println("oops: " + e));
        } catch (Throwable e) {
            System.out.println("hold your horses, we're catching an exception:");
            e.printStackTrace();
        }
    }

    public static void the_trick() {
        try {
            Thread currentThread = Thread.currentThread();

            Thread.UncaughtExceptionHandler handler = currentThread.getUncaughtExceptionHandler();
            handler.uncaughtException(currentThread, new Exception("looks like something went wrong here too"));
        } catch (Throwable e) {
            System.out.println("trying to catch this exception");

            e.printStackTrace();
        }
    }

}
