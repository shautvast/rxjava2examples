package rx.create;

import io.reactivex.Observable;

/*
 * throws an exception...
 */
public class Throw {

    public static void main(String[] args) {
        try {
            Observable.error(new Exception("something went wrong")).subscribe(e -> System.out.println("oops: " + e));
        } catch (Throwable e) {
            System.out.println("hold your horses, we're catching an exception:");
            e.printStackTrace();
        }
    }

}
