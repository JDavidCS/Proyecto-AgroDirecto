package AppAgro.src.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class buyerFrame {

    JFrame frame;
    JPanel listPanel, formPanel;
    DefaultTableModel modelVendedores;

    public buyerFrame(){
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Comprador | Agro-Directo");
        ImageIcon icon = new ImageIcon(getClass().getResource("/AppAgro/src/img/Icon6.png"), "Icon");
        frame.setSize(900, 540);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(icon.getImage());
        frame.setLayout(new BorderLayout(20, 20));

        displayFormContent();
        displayTable();
    }

    private void displayFormContent() {

        formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(frame.getWidth() * 1 / 2, frame.getHeight()));

        GridBagConstraints gbc = new GridBagConstraints();
        formPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

            JLabel FormTitle = new JLabel("Buscar Vendedores");
            FormTitle.setFont(new Font(null, Font.BOLD, 20));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 3;
            gbc.insets = new Insets(30, 0, 0, 0);
            inputPanel.add(FormTitle, gbc);

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(5, 10, 5, 5);
            gbc.gridwidth = 1;

            JLabel MOriginLabel = new JLabel("Municipio");
            MOriginLabel.setFont(new Font(null, Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 4;
            inputPanel.add(MOriginLabel, gbc);


            // Inputs
            String[] optionsDep = { null, "Cundinamarca", "Antioquia", "Santander", "Tolima", "Atlantico" };
            JComboBox<String> MOrigin_dep = new JComboBox<>(optionsDep);
            gbc.weightx = 1;
            gbc.gridx = 1;
            gbc.gridy = 4;
            inputPanel.add(MOrigin_dep, gbc);

            JComboBox<String> MOrigin_mun = new JComboBox<>();
            MOrigin_mun.setEnabled(false);
            gbc.gridx = 2;
            gbc.gridy = 4;
            inputPanel.add(MOrigin_mun, gbc);

            eventJcombo(MOrigin_dep, MOrigin_mun);

            JButton send = new JButton("Buscar");
            send.setFocusPainted(false);
            send.setBackground(new Color(8, 96, 3));
            send.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 8;
            gbc.gridwidth = 2;
            inputPanel.add(send, gbc);
            sendEvent(send);

            // departamento & municipio Label
            gbc.insets = new Insets(10, 10, 0, 5);
            JLabel depLabel = new JLabel("Departamento");
            gbc.gridx = 1;
            gbc.gridy = 3;
            inputPanel.add(depLabel, gbc);
            JLabel munLabel = new JLabel("Municipio");
            gbc.gridx = 2;
            gbc.gridy = 3;
            inputPanel.add(munLabel, gbc);

        formPanel.add(inputPanel, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.EAST);

        // Table with all buyers
        JPanel infoConsult = new JPanel();
        infoConsult.setLayout(new BorderLayout());
            String[] columnNames = { "Nombre", "Correo", "telefono"};
            String[][] data = {};

            modelVendedores = new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            JTable table = new JTable(modelVendedores);
            table.setRowHeight(25);
            table.getTableHeader().setReorderingAllowed(false);
            table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

            JScrollPane newScroll = new JScrollPane(table);
        infoConsult.add(newScroll);
        formPanel.add(infoConsult, BorderLayout.CENTER);
    }

    private void displayTable() {
        listPanel = new JPanel();
        listPanel.setBackground(Color.LIGHT_GRAY);
        listPanel.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titleLabel = new JLabel("Hola, David");
        titleLabel.setFont(new Font(null, Font.BOLD, 30));

        titlePanel.add(titleLabel);
        listPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(Color.DARK_GRAY);

        String[] columnNames = { "Producto", "Comprador", "Destino", "Bultos", "Peso" };
        String[][] data = { { "Papa", "40343", "Armenia", "4", "34" }, { "Fresa", "5345", "Narnia" } };

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(25);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane newScroll = new JScrollPane(table);
        newScroll.getViewport().setBackground(Color.LIGHT_GRAY);

        tablePanel.add(newScroll, BorderLayout.CENTER);

        listPanel.add(tablePanel, BorderLayout.CENTER);

        frame.add(listPanel, BorderLayout.CENTER);
    }

    private void eventJcombo(JComboBox<String> dep, JComboBox<String> mun) {

        dep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dep.getSelectedIndex() < 0)
                    mun.setEnabled(false);
                else
                    mun.setEnabled(true);
            }
        });
    }

    private void sendEvent(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] a = {"Jaimito", "jaim1998@mail.com", "3775949445"};
                modelVendedores.addRow(a);// con este metodo se añade información a la tabla.

                if(modelVendedores.getRowCount() > 5){
                    // Codigo dentro de este if es para borrar la información ya existente para luego añadir la nueva información
                    int count = modelVendedores.getRowCount();
                    for (int i = 0; i < count; i++) {
                        modelVendedores.removeRow(0);
                    }
                }
            }
        });
    }

    public void show() {
        frame.setVisible(true);
    }
}
