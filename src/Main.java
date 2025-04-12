import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
    private static void createAndShowGUI() {
        // todo : come up with a better name
        JFrame mainFrame = new JFrame("Password Manager");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400,300);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainFrame.add(mainPanel);

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.anchor = GridBagConstraints.SOUTH;
        JButton addPasswordButton = new JButton("Add Password");
        mainPanel.add(addPasswordButton, gbc);


        gbc.anchor = GridBagConstraints.NORTH;
        JButton managePasswordButton = new JButton("Manage Passwords");
        mainPanel.add(managePasswordButton, gbc);

        addPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addFrame = new JFrame("Password Manager (form)");
                addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addFrame.setSize(500,400);
                addFrame.setVisible(true);
                addFrame.setLocationRelativeTo(null);

                JPanel addPanel = new JPanel();
                addFrame.add(addPanel);

                addPanel.setLayout(new GridBagLayout());
                GridBagConstraints gbc1 = new GridBagConstraints();
                gbc1.insets = new Insets(5, 5, 5, 5);

                // Row 1 : Folder name + Text Field
                gbc1.gridx = 0;
                gbc1.gridy = 0;
                gbc1.anchor = GridBagConstraints.WEST;
                addPanel.add(new JLabel("Folder Name:"), gbc1);

                gbc1.gridx = 1;
                JTextField folderNameField = new JTextField(24);
                addPanel.add(folderNameField, gbc1);
                // Row 2 : Email/Username + Text Field
                gbc1.gridx = 0;
                gbc1.gridy = 1;
                addPanel.add(new JLabel("Email/Username: "), gbc1);

                gbc1.gridx = 1;
                JTextField emailUsernameField = new JTextField(24);
                addPanel.add(emailUsernameField, gbc1);
                // Row 3 : Password + Text Field
                gbc1.gridx = 0;
                gbc1.gridy = 2;
                addPanel.add(new JLabel("Password:"), gbc1);

                gbc1.gridx = 1;
                JTextField passwordField = new JTextField(24);
                addPanel.add(passwordField, gbc1);
                // Button
                gbc1.gridx = 1;
                gbc1.gridy = 3;
                gbc1.anchor = GridBagConstraints.CENTER;
                JButton submitButton = new JButton("Submit");
                addPanel.add(submitButton, gbc1);

            }
        });


    }
}