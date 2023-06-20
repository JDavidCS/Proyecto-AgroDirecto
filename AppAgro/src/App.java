package AppAgro.src;

import javax.swing.SwingUtilities;

import AppAgro.src.frames.transporterFrame;
import AppAgro.src.frames.sellerFrame;

public class App {
    public static void main(String[] args, int account) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                switch (account){
                    case 1:
                        startAsSeller();
                    break;

                    case 2:
                        startAsTransporter();
                    break;
                }
            }
        });

    }

    private static void startAsSeller(){
        sellerFrame frame = new sellerFrame();

        frame.show();
    }
    private static void startAsTransporter(){
        transporterFrame frame = new transporterFrame();

        frame.show();
    }
}
