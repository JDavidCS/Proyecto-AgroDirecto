package AppAgro.src.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class sellerFrame {
    JFrame frame;
    JPanel sellsList;

    public sellerFrame(){
        initialize();
    }
    private void initialize(){
        frame = new JFrame("Ventas | Agro-Directo");
        ImageIcon icon = new ImageIcon(getClass().getResource("/AppAgro/src/img/Icon6.png"), "Icon");
        frame.setSize(900, 540);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(icon.getImage());
        frame.setLayout(new BorderLayout());

        JPanel left = new JPanel();
        left.setBackground(Color.DARK_GRAY);

        JPanel center = new JPanel();
        center.setBackground(Color.blue);
        center.setLayout(new GridBagLayout());
        center.setPreferredSize(new Dimension((frame.getWidth() * 2) / 5, frame.getHeight()));
        GridBagConstraints gbc = new GridBagConstraints();

        JButton button = new JButton("hola");

        

        center.add(button, gbc);



        frame.add(left, BorderLayout.CENTER);
        frame.add(center, BorderLayout.EAST);


        displayContent();
    }

    public void displayContent(){

    }

    public void show(){
        frame.setVisible(true);
    }
}
