package rx.filter;

import java.util.Random;

import static io.reactivex.Observable.interval;
import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Distinct {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        interval(0, 100, MILLISECONDS).map(t -> {
            return random.nextInt(20);
        }).distinct().subscribe(w -> out.println(w));

        SECONDS.sleep(10);
    }
}
