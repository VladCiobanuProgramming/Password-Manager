import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        Path passwordPath = Path.of(System.getProperty("user.home"), "text.txt");


        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
    private static void createAndShowGUI() {
        // todo : come up with a better name
        JFrame mainFrame = new JFrame("Password Manager");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400,150);
        mainFrame.setLayout(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("Password Manager", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        mainFrame.add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton addPasswordButton = new JButton("Add Password");
        JButton managePasswordButton = new JButton("Manage Passwords");

        mainPanel.add(addPasswordButton);
        mainPanel.add(managePasswordButton);

        mainFrame.add(mainPanel, FlowLayout.CENTER);

        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);

        addPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addFrame = new JFrame("Password Manager (form)");
                addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addFrame.setSize(500,350);
                addFrame.setVisible(true);
                addFrame.setLocationRelativeTo(null);

                JPanel addPanel = new JPanel();
                addFrame.add(addPanel);

                addPanel.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(5, 5, 5, 5);
                // TODO: set fonts for the Text Fields , make text more appealing
                // Row 1 : Folder name + Text Field
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.WEST;
                addPanel.add(new JLabel("Folder Name:"), gbc);

                gbc.gridx = 1;
                JTextField folderNameField = new JTextField(24);
                addPanel.add(folderNameField, gbc);
                // Row 2 : Email/Username + Text Field
                gbc.gridx = 0;
                gbc.gridy = 1;
                addPanel.add(new JLabel("Email/Username: "), gbc);

                gbc.gridx = 1;
                JTextField emailUsernameField = new JTextField(24);
                addPanel.add(emailUsernameField, gbc);
                // Row 3 : Password + Text Field
                gbc.gridx = 0;
                gbc.gridy = 2;
                addPanel.add(new JLabel("Password:"), gbc);

                gbc.gridx = 1;
                JTextField passwordField = new JTextField(24);
                addPanel.add(passwordField, gbc);
                // Button
                gbc.gridx = 1;
                gbc.gridy = 3;
                gbc.anchor = GridBagConstraints.CENTER;
                JButton submitButton = new JButton("Submit");
                addPanel.add(submitButton, gbc);

            }
        });


    }
}