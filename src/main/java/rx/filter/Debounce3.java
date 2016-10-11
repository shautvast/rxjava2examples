package rx.filter;

import io.reactivex.Observable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import static rx.filter.Debounce.sleep;

public class Debounce3 {
    public static void main(String[] args) {
        Random random = new Random();

        Observable<Integer> waittimes = Observable.range(1, 50).map(r -> {
            return random.nextInt(500);
        });

        Observable<Long> timestamps = waittimes.map(waittime -> {
            long t = currentTimeMillis();

            out.println("timestamp " + t + ", wait " + waittime);
            sleep(waittime);
            return t;
        });

        timestamps.debounce(400, TimeUnit.MILLISECONDS).subscribe(key -> out.println("event " + key));
    }
}
