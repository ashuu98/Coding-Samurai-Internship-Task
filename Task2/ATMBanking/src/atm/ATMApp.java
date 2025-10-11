package atm;


import javax.swing.SwingUtilities;

public class ATMApp {
    public static void main(String[] args) {
        ATMSystem system = new ATMSystem();
        SwingUtilities.invokeLater(() -> new LoginFrame(system));
    }
}

