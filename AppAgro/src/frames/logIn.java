package AppAgro.src.frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class logIn {
    private JFrame frame;
    JPanel inputPanel;
    JPanel descriptionPanel;
    JPanel input;

    private JLabel titleLabel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userArea;
    private JPasswordField passwordArea;
    private JButton send;

    public logIn() {
        initialize();
    }

    private void initialize(){
        frame = new JFrame("LogIn | Agro-Directo");
        ImageIcon icon = new ImageIcon(getClass().getResource("/AppAgro/src/img/Icon6.png"), "Icon");
        frame.setSize(900, 540);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(icon.getImage());
        // frame.setResizable(false);
        frame.setLayout(new GridLayout(1, 2));


        descriptionPanel = new JPanel();
        descriptionPanel.setBackground(Color.gray);
        inputPanel = new JPanel();
        descriptionPanel.setBackground(Color.DARK_GRAY);

        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints maingbc = new GridBagConstraints();
        maingbc.fill = GridBagConstraints.HORIZONTAL;
        maingbc.insets = new Insets(0, 30, 0, 30);
        // maingbc.anchor = GridBagConstraints;
        maingbc.weightx = 1;
        maingbc.gridx = 0;
        maingbc.gridy = 0;
        
        frame.add(descriptionPanel);
        frame.add(inputPanel);
        
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();
        
        input = new JPanel();
        input.setLayout(layout);
        
        displayContent(gbc);
        sendEvent();
        
        inputPanel.add(input, maingbc);
    }
    
    private void displayContent(GridBagConstraints gbc){
        titleLabel = new JLabel("Log In");
            titleLabel.setFont(new Font(null, Font.BOLD, 25));
            gbc.insets = new Insets(10,20,15,10);
            gbc.gridx = 5;
            gbc.gridy = 0;
            gbc.weighty = 2;
        input.add(titleLabel, gbc);

        userLabel = new JLabel("Usuario");
            gbc.insets = new Insets(10,20,10,10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            userLabel.setFont(new Font(null, Font.BOLD, 16));
            gbc.gridwidth = 3;
            gbc.gridx = 5;
            gbc.gridy = 1;
            gbc.weighty = 0;
        input.add(userLabel, gbc);

        passwordLabel = new JLabel("Contraseña");
            passwordLabel.setFont(new Font(null, Font.BOLD, 16));
            gbc.gridwidth = 3;
            gbc.gridx = 5;
            gbc.gridy = 2;
        input.add(passwordLabel, gbc);

        userArea = new JTextField();
            userArea.setFont(new Font(null, Font.PLAIN, 16));
            userArea.setBorder(BorderFactory.createLineBorder(Color.gray));
            gbc.gridwidth = 3; // Establecer a 1 para ocupar una sola celda
            gbc.gridx = 8;
            gbc.gridy = 1;
            gbc.weightx = 1; // Establecer weightx para ocupar espacio adicional horizontalmente
            gbc.weighty = 1;
        input.add(userArea, gbc);

        passwordArea = new JPasswordField();
            passwordArea.setFont(new Font(null, Font.PLAIN, 16));
            passwordArea.setBorder(BorderFactory.createLineBorder(Color.gray));
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 3; // Establecer a 1 para ocupar una sola celda
            gbc.gridx = 8;
            gbc.gridy = 2;
            gbc.weightx = 1; // Establecer weightx para ocupar espacio adicional horizontalmente
            gbc.weighty = 1;
        input.add(passwordArea, gbc);

        send = new JButton("Siguiente");
            send.setFocusPainted(false);
            send.setBackground(new Color(8, 96, 3));
            send.setFont(new Font(null, Font.BOLD, 16));
            send.setForeground(Color.WHITE);
            gbc.anchor = GridBagConstraints.PAGE_END; //bottom of space
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 4; // Establecer a 1 para ocupar una sola celda
            gbc.gridheight = 2; // Establecer a 1 para ocupar una sola celda
            gbc.gridx = 8;
            gbc.gridy = 3;
            gbc.weightx = 1; // Establecer weightx para ocupar espacio adicional horizontalmente
        input.add(send, gbc);

    }

    private void sendEvent(){
        send.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    String user = userArea.getText();
                    String password = String.valueOf(passwordArea.getPassword());

                    boolean userOK = !user.trim().isEmpty() && !user.contains(" ");
                    boolean passwordOK = !password.trim().isEmpty() && !password.contains(" ");


                    if(userOK && passwordOK){
                        userArea.setBackground(Color.white);
                        userArea.setBorder(BorderFactory.createLineBorder(Color.gray));

                        passwordArea.setBackground(Color.white);
                        passwordArea.setBorder(BorderFactory.createLineBorder(Color.gray));

                        sendInfo();
                    } 
                    else if(!userOK || !passwordOK){
                        if(!userOK){
                            userArea.setBackground(new Color(255, 211, 211));
                            userArea.setBorder(BorderFactory.createLineBorder(Color.RED));

                        } 
                        if(!passwordOK){
                            passwordArea.setBackground(new Color(255, 211, 211));
                            passwordArea.setBorder(BorderFactory.createLineBorder(Color.RED));
                            
                        }
                    }

                    // if(userOK){
                    //     userArea.setBackground(Color.white);
                    //     userArea.setBorder(BorderFactory.createLineBorder(Color.gray));
                    //     // System.out.println("Usuario correcto");
                    // } else {
                    //     userArea.setBackground(new Color(255, 211, 211));
                    //     userArea.setBorder(BorderFactory.createLineBorder(Color.RED));
                    //     // System.out.println("Usuario Incorrecto");
                    // }
                    // if (passwordOK) {
                    //     passwordArea.setBackground(Color.white);
                    //     passwordArea.setBorder(BorderFactory.createLineBorder(Color.gray));
                    //     // System.out.println("Contraseña correcta");
                    // } else {
                    //     passwordArea.setBackground(new Color(255, 211, 211));
                    //     passwordArea.setBorder(BorderFactory.createLineBorder(Color.RED));
                    //     // System.out.println("Contraseña Incorrecta");
                    // }


                }
        });
    }

    private void sendInfo(){
        // frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        JPanel blockingPanel = new JPanel();
        blockingPanel.setBackground(new Color(0, 0, 0, 64));
        blockingPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        frame.setGlassPane(blockingPanel);
        blockingPanel.setVisible(true);

        // open the main process
        
        frame.dispose();
    }

    public void show() {
        frame.setVisible(true);
    }
}
