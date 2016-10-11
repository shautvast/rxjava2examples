package rx.create;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.stream.Stream;

/*
 * create an Observable from any
 */
public class Create {
    public static void main(String[] args) {
        Observable<Long> observable = Observable.create(emitter -> {
            emitter.onNext(System.nanoTime());
            emitter.onNext(System.nanoTime());
        });
        observable.subscribe(l -> System.out.println(l));

        System.out.println("java 8:");
        Stream.of(new Long[]{System.nanoTime(), System.nanoTime()}).forEach(t -> System.out.println(t));
    }
}
