package rx.create;

import io.reactivex.Observable;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Interval {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(0, 100, MILLISECONDS).subscribe(value -> System.out.println(System.currentTimeMillis() + ": " + value));

        SECONDS.sleep(1);
    }
}
