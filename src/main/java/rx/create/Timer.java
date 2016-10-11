package rx.create;

import io.reactivex.Observable;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Timer {
    public static void main(String[] args) throws InterruptedException {
        out.println(currentTimeMillis());

        Observable.timer(1000, MILLISECONDS).map(t -> {
            return "peekaboo";
        }).subscribe(v -> out.println(currentTimeMillis()+" "+v));

        MILLISECONDS.sleep(1200);
    }
}
