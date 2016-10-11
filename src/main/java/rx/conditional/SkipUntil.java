package rx.conditional;

import io.reactivex.Observable;

import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;

public class SkipUntil {

    public static void main(String[] args) throws InterruptedException {
        out.println("start");

        Observable<Long> range = Observable.intervalRange(0, 10, 0, 1, SECONDS);
        Observable<Long> timer = Observable.timer(5, SECONDS);

//        range.subscribe(v -> out.println(v));
        range.skipUntil(timer).subscribe(v -> out.println(v));

        SECONDS.sleep(10);
    }
}
