package AppAgro.src;

import javax.swing.SwingUtilities;

import AppAgro.src.frames.buyerFrame;
import AppAgro.src.frames.transporterFrame;
import AppAgro.src.frames.logIn;
import AppAgro.src.frames.sellerFrame;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                // logIn frame = new logIn();

                // frame.show();

                // sellerFrame frame2 = new sellerFrame();

                // frame2.show();

                transporterFrame frame3 = new transporterFrame();

                frame3.show();

                buyerFrame frame4 = new buyerFrame();

                frame4.show();
            }
        });
        
    }
}