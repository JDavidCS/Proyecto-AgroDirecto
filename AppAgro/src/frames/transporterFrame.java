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

public class transporterFrame {

    JFrame frame;
    JPanel listPanel, formPanel;

    public transporterFrame(){
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Transporte | Agro-Directo");
        ImageIcon icon = new ImageIcon(getClass().getResource("/AppAgro/src/img/Icon6.png"), "Icon");
        frame.setSize(900, 540);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(icon.getImage());
        frame.setLayout(new BorderLayout());

        displayFormContent();
        displayTable();
    }

    private void displayFormContent() {

        formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(frame.getWidth() * 1 / 2, frame.getHeight()));

        GridBagConstraints gbc = new GridBagConstraints();
        formPanel.setLayout(new GridBagLayout());

        JLabel FormTitle = new JLabel("Nuevo Transporte");
        FormTitle.setFont(new Font(null, Font.PLAIN, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 20, 20, 20);
        formPanel.add(FormTitle, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 5);
        gbc.gridwidth = 1;


        JLabel MOriginLabel = new JLabel("Municipio de origen");
        MOriginLabel.setFont(new Font(null, Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(MOriginLabel, gbc);
        JLabel MDestinationLabel = new JLabel("Municipio de Destino");
        MDestinationLabel.setFont(new Font(null, Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(MDestinationLabel, gbc);
        JLabel bultosLabel = new JLabel("Cantidad de Bultos");
        bultosLabel.setFont(new Font(null, Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(bultosLabel, gbc);
        JLabel weightLabel = new JLabel("Peso");
        weightLabel.setFont(new Font(null, Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 7;
        formPanel.add(weightLabel, gbc);
        // Inputs
        gbc.weightx = 1;

        String[] optionsDep = { null, "Cundinamarca", "Antioquia", "Santander", "Tolima", "Atlantico" };
        JComboBox<String> MOrigin_dep = new JComboBox<>(optionsDep);
        gbc.gridx = 1;
        gbc.gridy = 4;
        formPanel.add(MOrigin_dep, gbc);

        JComboBox<String> MOrigin_mun = new JComboBox<>();
        MOrigin_mun.setEnabled(false);
        gbc.gridx = 2;
        gbc.gridy = 4;
        formPanel.add(MOrigin_mun, gbc);

        eventJcombo(MOrigin_dep, MOrigin_mun);

        JComboBox<String> MDestination_dep = new JComboBox<>(optionsDep);
        gbc.gridx = 1;
        gbc.gridy = 5;
        formPanel.add(MDestination_dep, gbc);

        JComboBox<String> MDestination_mun = new JComboBox<>();
        MDestination_mun.setEnabled(false);
        gbc.gridx = 2;
        gbc.gridy = 5;
        formPanel.add(MDestination_mun, gbc);

        eventJcombo(MDestination_dep, MDestination_mun);

        JTextField bultoInput = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 6;
        formPanel.add(bultoInput, gbc);

        JTextField weightInput = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 7;
        formPanel.add(weightInput, gbc);

        JButton send = new JButton("Enviar");
        send.setFocusPainted(false);
        send.setBackground(new Color(8, 96, 3));
        send.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        formPanel.add(send, gbc);
        sendEvent(send);

        // departamento & municipio Label
        gbc.insets = new Insets(10, 10, 0, 5);
        JLabel depLabel = new JLabel("Departamento");
        gbc.gridx = 1;
        gbc.gridy = 3;
        formPanel.add(depLabel, gbc);
        JLabel munLabel = new JLabel("Municipio");
        gbc.gridx = 2;
        gbc.gridy = 3;
        formPanel.add(munLabel, gbc);

        frame.add(formPanel, BorderLayout.EAST);

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
        DefaultTableModel model = new DefaultTableModel(null, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane newScroll = new JScrollPane(table);
        newScroll.getViewport().setBackground(Color.LIGHT_GRAY);

        tablePanel.add(newScroll, BorderLayout.CENTER);

        listPanel.add(tablePanel, BorderLayout.CENTER);

        frame.add(listPanel, BorderLayout.CENTER);

        // peso total
        JPanel totalWeightPanel = new JPanel();
        totalWeightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

            JLabel totalWeightLabel = new JLabel("Peso total:");
            totalWeightLabel.setFont(new Font(null, Font.BOLD, 18));

            JLabel valueLabel = new JLabel("800 kg");
            valueLabel.setFont(new Font(null, Font.PLAIN, 14));
        totalWeightPanel.add(totalWeightLabel);
        totalWeightPanel.add(valueLabel);
        listPanel.add(totalWeightPanel, BorderLayout.SOUTH);
        


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
                System.out.println("enviando");
            }
        });
    }

    public void show() {
        frame.setVisible(true);
    }
}
