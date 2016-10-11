package rx.combine;

import io.reactivex.Observable;

public class Zip {

    public static void main(String[] args) {
        Observable<String> strings = Observable.fromArray(new String[]{"a", "b", "c"});
        Observable<Integer> integers = Observable.fromArray(new Integer[]{1, 2, 3});

        strings.zipWith(integers, (string, integer) -> {
            return string + integer;
        }).subscribe(value -> System.out.println(value));
    }
}
