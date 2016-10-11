package rx.transform;

import io.reactivex.Observable;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/*
 * Buffers until a criterium is met and the emits all the buffered values in one emission.
 */
public class Buffer {
    public static void main(String[] args) {
        Frame frame = getFrame();
        JTextField textfield = new JTextField();
        frame.add(textfield);
        frame.pack();
        frame.setVisible(true);

        final Observable<String> keys = Observable.create(observableEmitter -> {
            textfield.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent keyEvent) {
                    observableEmitter.onNext(new String(new char[]{keyEvent.getKeyChar()}));
                }
            });
        });

        keys.buffer(3).subscribe(key -> System.out.println("event " + key));
    }

    private static Frame getFrame() {
        Frame f = new JFrame("");
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        return f;
    }
}
