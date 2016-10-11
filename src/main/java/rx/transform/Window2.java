package rx.transform;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/*
 * Emits a new window based on elapsed time
 */
public class Window2 {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(0, 500, TimeUnit.MILLISECONDS)
                .window(5, TimeUnit.SECONDS)
                .subscribe(observable -> {
                    System.out.println("new window");
                    observable.subscribe(value -> System.out.println(value));
                });

        TimeUnit.SECONDS.sleep(60);
    }
}
