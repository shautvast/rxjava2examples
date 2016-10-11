package rx.transform;

import io.reactivex.Observable;

/*
 * Applies a mapping function to an observable returning a new Observable
 */
public class Map {
    public static void main(String[] args) {
        Observable.range(1, 10).map(value -> {
            return value + " is " + (value % 2 == 0 ? "even" : "uneven");
        }).subscribe(output -> System.out.println(output));
    }
}
