package rx.transform;

import io.reactivex.Observable;

/*
 * Applies a mapping function 'with state', ie the previous output.
 * The output reenters together with the new emission from the original observable.
 */
public class Scan {
    public static void main(String[] args) {
        Observable.range(1, 10).scan((sum, item) -> {
            return sum + item;
        }).subscribe(value -> System.out.println(value));
    }
}
