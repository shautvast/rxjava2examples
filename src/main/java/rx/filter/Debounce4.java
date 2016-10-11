package rx.filter;

import io.reactivex.Observable;

import java.util.Random;

import static io.reactivex.Observable.range;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static rx.filter.Debounce.sleep;

public class Debounce4 {
    public static void main(String[] args) {
        Random random = new Random();

        range(1, 50)
                .map(r -> {
                    return random.nextInt(500);
                })
                .map(waittime -> {
                    long t = currentTimeMillis();

                    out.println("timestamp " + t + ", wait " + waittime);
                    sleep(waittime);
                    return t;
                })
                .debounce(400, MILLISECONDS)
                .subscribe(key -> out.println("event " + key));
    }
}
