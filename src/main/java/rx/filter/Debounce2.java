package rx.filter;

import io.reactivex.Observable;
import java.util.Random;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static rx.filter.Debounce.sleep;

public class Debounce2 {
    public static void main(String[] args)  {
        Random random = new Random();

        Observable<Integer> range = Observable.range(1, 50);

        Observable<Long> times = range.map(i -> {
            long t = currentTimeMillis();
            int w = random.nextInt(500);

            out.println("time " + t + ", wait " + w);
            sleep(w);
            return t;
        });

        times.debounce(400, MILLISECONDS).subscribe(key -> out.println("event " + key));
    }
}