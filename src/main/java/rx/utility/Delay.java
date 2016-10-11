package rx.utility;

import io.reactivex.Observable;

import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Delay {
    public static void main(String[] args) throws InterruptedException {
        out.println("start");

        Observable<Integer> rangeFrom1To5 = Observable.range(1,5);

        rangeFrom1To5.delay(3, SECONDS).subscribe(v -> out.println("receive "+v));

        SECONDS.sleep(5);
    }
}
