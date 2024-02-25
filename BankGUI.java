import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankGUI extends JFrame {
    private JPanel mainPanel;
    private JLabel balanceLabel;
    private JTextField balanceField;
    private JButton depositButton;
    private JButton withdrawButton;
    private BankAccount account;

    public BankGUI() {
        mainPanel = new JPanel();
        balanceLabel = new JLabel("Balance:");
        balanceField = new JTextField(10);
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        //GUI
        setTitle("Bank Balance");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setLayout(new GridLayout(3, 2));
        mainPanel.add(balanceLabel);
        mainPanel.add(balanceField);
        mainPanel.add(depositButton);
        mainPanel.add(withdrawButton);
        add(mainPanel);
        pack();
        setLocationRelativeTo(null);

        account = new BankAccount(0);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter deposit amount:"));
                    account.deposit(depositAmount);
                    updateBalance();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter withdraw amount:"));
                    account.withdraw(withdrawAmount);
                    updateBalance();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });

        updateBalance();
    }

    private void updateBalance() {
        balanceField.setText(String.valueOf(account.getBalance()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BankGUI().setVisible(true);
        });
    }
}