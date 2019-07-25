package sample;

import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.event.AWTEventListener;
import java.util.Iterator;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        Provider provider = Provider.getCurrentProvider(true);
        provider.register(KeyStroke.getKeyStroke("control shift PLUS"), new HotKeyListener() {
//        provider.register(KeyStroke.getKeyStroke("shift "), new HotKeyListener() {
            @Override
            public void onHotKey(HotKey hotKey) {
                System.out.println("key click");
            }
        });

        primaryStage.show();
////        Toolkit.getDefaultToolkit().getDesktopProperty()
//        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        systemClipboard.addFlavorListener(new FlavorListener() {
//            @Override
//            public void flavorsChanged(FlavorEvent e) {
//                System.out.println("key");
//            }
//        });
//        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                System.out.println("mouse click detected! " + mouseEvent.getSource());
//            }
//        });
//

//        Iterator<Window> windows = Stage.impl_getWindows();
//        java.awt.Window fullScreenWindow = MouseInfo.getPointerInfo().getDevice().getFullScreenWindow();
//        Toolkit.getDefaultToolkit().addAWTEventListener(
//                new Listener(), AWTEvent.MOUSE_EVENT_MASK | AWTEvent.FOCUS_EVENT_MASK);
//        Stage.impl_getWindows().next().
//        Window next1 = windows.next();
//        next1.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
//        Iterator<Window> windowIterator = Window.impl_getWindows();
//        Window next = windowIterator.next();
//        next.addEventHandler(MouseEvent.MOUSE_PRESSED,eventHandler);
//        Window owner = primaryStage.getOwner();
//        owner.addEventHandler(MouseEvent.MOUSE_CLICKED,eventHandler);
    }
    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            System.out.println("Click----");
        }
    };
    private static class Listener implements AWTEventListener {
        public void eventDispatched(AWTEvent event) {
            System.out.print(MouseInfo.getPointerInfo().getLocation() + " | ");
            System.out.println(event);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
