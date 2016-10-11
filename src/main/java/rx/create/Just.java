package rx.create;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.stream.Stream;

/*
 * creates an Observable from any
 */
public class Just {

    public static void main(String[] args) {
        Observable.just("hello").subscribe(v -> System.out.println(v));

        System.out.println();

        System.out.println("java 8:");
        Stream.of(Arrays.asList("hello", " ", "world")).forEach(t -> System.out.println(t));
    }
}
