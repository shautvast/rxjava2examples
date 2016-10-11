package rx.create;


import io.reactivex.Observable;

import java.util.stream.IntStream;

/*
 * creates a range
 */
public class Range {
    public static void main(String[] args) throws InterruptedException {
        Observable.range(1, 10).subscribe(v -> System.out.println(v));

        System.out.println("\njava 8:");
        IntStream.rangeClosed(1, 10).forEach(v -> System.out.println(v));

        System.out.println("\nfactorial(5) using reduce:");
        System.out.println(IntStream.rangeClosed(1, 5).reduce(1, (x, f) -> {
            return x * f;
        }));

    }
}
