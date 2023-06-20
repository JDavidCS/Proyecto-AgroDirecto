package AppAgro.src.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import AppAgro.src.App;


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
        frame.setSize(850, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(icon.getImage());
        // frame.setResizable(false);
        frame.setLayout(new GridLayout(1, 2));


        descriptionPanel = new JPanel();
        descriptionPanel.setBackground(Color.lightGray);
        descriptionPanel.setLayout(new GridLayout(2, 1));
            
            JLabel etiquetaImagen = new JLabel();
            etiquetaImagen.setBackground(Color.GREEN);
            etiquetaImagen.setSize(270, 189);

            ImageIcon importImage = new ImageIcon(getClass().getResource("/AppAgro/src/img/Logo3.png"), "Logo");

            Icon logo = new ImageIcon(importImage.getImage().getScaledInstance(etiquetaImagen.getWidth(), etiquetaImagen.getHeight(), Image.SCALE_AREA_AVERAGING));

            etiquetaImagen.setIcon(logo);

            etiquetaImagen.setHorizontalAlignment(JLabel.CENTER);

            JPanel textPanel = new JPanel();
            textPanel.setLayout(new GridBagLayout());
            textPanel.setBackground(new Color(0, 0, 0, 0));


            JTextArea label = new JTextArea("Agro-Directo busca reducir los costos de la intermediación, acercando a los distribuidores finales con los campesinos productores.");
            label.setBackground(new Color(0, 0, 0, 0));
            label.setFont(new Font(null, Font.BOLD, 15));
            label.setPreferredSize(new Dimension(350, 100));
            label.setEditable(false);
            label.setWrapStyleWord(true);
            label.setLineWrap(true);
            textPanel.add(label);


        descriptionPanel.add(etiquetaImagen, BorderLayout.NORTH);
        descriptionPanel.add(textPanel, BorderLayout.CENTER);
        
        
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints maingbc = new GridBagConstraints();
        maingbc.fill = GridBagConstraints.HORIZONTAL;
        maingbc.insets = new Insets(0, 30, 0, 30);
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
                            JOptionPane.showMessageDialog(frame, "Error");

                        } 
                        if(!passwordOK){
                            passwordArea.setBackground(new Color(255, 211, 211));
                            passwordArea.setBorder(BorderFactory.createLineBorder(Color.RED));
                            JOptionPane.showMessageDialog(frame, "Error");
                        }
                    }
                }
        });
    }

    private void sendInfo(){
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        send.setEnabled(false);
        // open the main process
        
        App.main(null, 2);
        frame.dispose();
    }

    public void show() {
        frame.setVisible(true);
    }
}
