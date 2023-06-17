package AppAgro.src;

import javax.swing.SwingUtilities;

import AppAgro.src.frames.conveyorFrame;
import AppAgro.src.frames.logIn;
import AppAgro.src.frames.sellerFrame;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                // logIn frame = new logIn();

                // frame.show();

                // sellerFrame frame = new sellerFrame();

                // frame.show();

                conveyorFrame frame = new conveyorFrame();

                frame.show();
            }
        });
        
    }
}