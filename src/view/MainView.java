package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JButton neuesKontoButton;
    private JButton alleKontenAnzeigenButton;
    private JButton billanzButton;
    private JButton kontoAnzeigenButton;
    private JTextField kontonummerTextfield;
    private JTextField kontoinhaberTextfield;
    private JTextField kontostandTextfield;

    public MainView() {
        setSize(600, 400);
        setTitle("Kontoverwaltung");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addComponents();
        pack();
        setVisible(true);
    }

    private void addComponents() {
        setLayout( new BorderLayout() );
        JPanel centerPanel = new JPanel( new GridLayout(4,3) );
        JPanel bottomPanel = new JPanel( new FlowLayout(FlowLayout.LEFT) );
        this.add( new JLabel("Kontoverwaltung v3"), BorderLayout.NORTH );
        this.add( centerPanel, BorderLayout.CENTER );
        this.add( bottomPanel, BorderLayout.SOUTH );
        addCenterComponents( centerPanel );
        addButtons( bottomPanel );
    }

    private void addButtons(JPanel bottomPanel) {
        bottomPanel.setBorder( new EmptyBorder(5,5,5,5) );
        neuesKontoButton = new JButton("Neues Konto anlegen");
        alleKontenAnzeigenButton = new JButton("Alle Konten anzeigen");
        billanzButton = new JButton("Billanz stellen");
        bottomPanel.add( neuesKontoButton );
        bottomPanel.add( alleKontenAnzeigenButton );
        bottomPanel.add( billanzButton );
    }

    private void addCenterComponents(JPanel centerPanel) {
        centerPanel.setBorder( new EmptyBorder(5,5,5,5) );

        kontoAnzeigenButton = new JButton("Konto anzeigen");
        kontonummerTextfield = new JTextField();

        centerPanel.add( new JLabel("Kontonummer") );
        centerPanel.add( kontonummerTextfield );
        centerPanel.add( kontoAnzeigenButton );

        kontoinhaberTextfield = new JTextField();
        centerPanel.add( new JLabel("Kontoinhaber") );
        centerPanel.add( kontoinhaberTextfield );
        centerPanel.add( new JButton("Zinsen zuschlagen") );

        kontostandTextfield = new JTextField();
        centerPanel.add( new JLabel("Kontostand") );
        centerPanel.add( kontostandTextfield );
        centerPanel.add( new JButton("Konto löschen") );

        centerPanel.add( new JLabel("Betrag") );
        centerPanel.add( new JTextField() );

        // Extra Panel für zwei Buttons
        JPanel manipulationsPanel = new JPanel(new FlowLayout());
        manipulationsPanel.add( new JButton("Einzahlen") );
        manipulationsPanel.add( new JButton("Abheben") );
        centerPanel.add( manipulationsPanel );
    }

    public void setNeuesKontoButtonListener(ActionListener listener) {
        neuesKontoButton.addActionListener(listener);
    }

    public void setKontoAnzeigenButtonListener(ActionListener listener) {
        kontoAnzeigenButton.addActionListener(listener);
    }

    public int getKontonummer() {
        int kontonummer = 0;
        try {
            kontonummer = Integer.parseInt(kontonummerTextfield.getText());
        }
        catch (NumberFormatException e) {
            System.err.println("Kontonummer im falschen Format!");
        }
        return kontonummer;
    }

    public void setKontoinhaber(String inhaber) {
        kontoinhaberTextfield.setText(inhaber);
    }

    public void setKontostand(double kontostand) {
        kontostandTextfield.setText( Double.toString(kontostand) );
    }

    public void clearKontostand() {
        kontostandTextfield.setText("");
    }

    // Mockup starten
    public static void main(String[] args) {
        new MainView();
    }

    public void zeigeFehlermeldung(String message) {
        JOptionPane.showMessageDialog(this, message, "Fehler", JOptionPane.ERROR_MESSAGE);
    }
}
