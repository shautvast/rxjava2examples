package rx.create;

import io.reactivex.Observable;

/*
 * Does nothing
 */
public class Never {
    public static void main(String[] args) {
        Observable.never().subscribe(n -> System.out.println(n));
    }
}
