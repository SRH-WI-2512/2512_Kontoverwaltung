package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends View {

    private JButton neuesKontoButton;
    private JButton alleKontenAnzeigenButton;
    private JButton billanzButton;
    private JButton kontoAnzeigenButton;
    private JTextField kontonummerTextfield;
    private JTextField kontoinhaberTextfield;
    private JTextField kontostandTextfield;
    private JButton einzahlenButton;
    private JButton abhebenButton;
    private JTextField betragTextfield;
    private JButton kontoLöschenButton;
    private JButton zinsenZuschlagenButton;

    public MainView() {
        super("Kontoverwaltung");
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
        zinsenZuschlagenButton = new JButton("Zinsen zuschlagen");
        centerPanel.add( zinsenZuschlagenButton );

        kontostandTextfield = new JTextField();
        centerPanel.add( new JLabel("Kontostand") );
        centerPanel.add( kontostandTextfield );
        kontoLöschenButton = new JButton("Konto löschen");
        centerPanel.add( kontoLöschenButton);


        betragTextfield = new JTextField();
        centerPanel.add( new JLabel("Betrag") );
        centerPanel.add( betragTextfield );

        // Extra Panel für zwei Buttons
        einzahlenButton = new JButton("Einzahlen");
        abhebenButton = new JButton("Abheben");
        JPanel manipulationsPanel = new JPanel(new FlowLayout());
        manipulationsPanel.add( einzahlenButton );
        manipulationsPanel.add( abhebenButton );
        centerPanel.add( manipulationsPanel );
    }
    public void setKontoLöschenButtonListener(ActionListener listener){
        kontoLöschenButton.addActionListener(listener);
    }

    public void setNeuesKontoButtonListener(ActionListener listener) {
        neuesKontoButton.addActionListener(listener);
    }

    public void setKontoAnzeigenButtonListener(ActionListener listener) {
        kontoAnzeigenButton.addActionListener(listener);
    }

    public void setEinzahlenButtonListener(ActionListener listener) {
        einzahlenButton.addActionListener(listener);
    }

    public void setAbhebenButtonListener(ActionListener listener) {
        abhebenButton.addActionListener(listener);
    }

    public void setAlleKontenAnzeigenButtonListener(ActionListener listener) {
        alleKontenAnzeigenButton.addActionListener(listener);
    }

    public void setBillanzButtonListener(ActionListener listener) {
        billanzButton.addActionListener(listener);
    }

    public boolean istEinzahlenKlicked(ActionEvent event) {
        return event.getSource() == einzahlenButton;
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

    public void setKontonummer(int kontonummer) {
        kontonummerTextfield.setText( Integer.toString(kontonummer) );
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

    public void setBetrag(double betrag) {
        betragTextfield.setText( Double.toString(betrag) );
    }

    public double getBetrag() {
        String textValue = betragTextfield.getText();
        double betrag = 0.0;
        try {
            betrag = Double.parseDouble(textValue);
        }
        catch (NumberFormatException e) {
            System.err.println("Betrag im falschen Format!");
        }
        return betrag;
    }

    // Mockup starten
    public static void main(String[] args) {
        new MainView();
    }

    public void zeigeFehlermeldung(String message) {
        JOptionPane.showMessageDialog(this, message, "Fehler", JOptionPane.ERROR_MESSAGE);
    }
    public boolean zeigeRückfrage(String message){
        return
        JOptionPane.showConfirmDialog(this, message, "Bestätigung",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION;

    }
}
