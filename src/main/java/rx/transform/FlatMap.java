package rx.transform;

import io.reactivex.Observable;


/*
 * flattens an observable of observables
 */
public class FlatMap {

    public static void main(String[] args) {
        Observable<String> observable = Observable.range(1, 4).flatMap(r -> {
            return Observable.range(1, r).map(i -> {
                return "" + i;
            });
        });
        observable.toList().subscribe(s -> System.out.println(s));
    }
}
