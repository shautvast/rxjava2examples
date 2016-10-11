package rx.create;

import io.reactivex.Flowable;

/*
 * Flowable = Observable
 * fromCallable is another way of deferring. It creates an observable from the result of call.
 * Please note that the callable is not being called asynchronously. It's just deferred until subscription.
 */
public class FromCallable {
    public static void main(String[] args) {
        System.out.println("current thread: " + Thread.currentThread());

        Flowable.fromCallable(() -> {
            System.out.println(Thread.currentThread() + ": returning 'hello world'");
            return "hello world";
        }).subscribe();
    }
}
