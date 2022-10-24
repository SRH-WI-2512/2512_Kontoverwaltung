package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainView extends JFrame {

    private JButton neuesKontoButton;
    private JButton alleKontenAnzeigenButton;
    private JButton billanzButton;

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

        centerPanel.add( new JLabel("Kontonummer") );
        centerPanel.add( new JTextField() );
        centerPanel.add( new JButton("Konto anzeigen") );

        centerPanel.add( new JLabel("Kontoinhaber") );
        centerPanel.add( new JTextField() );
        centerPanel.add( new JButton("Zinsen zuschlagen") );

        centerPanel.add( new JLabel("Kontostand") );
        centerPanel.add( new JTextField() );
        centerPanel.add( new JButton("Konto löschen") );

        centerPanel.add( new JLabel("Betrag") );
        centerPanel.add( new JTextField() );

        // Extra Panel für zwei Buttons
        JPanel manipulationsPanel = new JPanel(new FlowLayout());
        manipulationsPanel.add( new JButton("Einzahlen") );
        manipulationsPanel.add( new JButton("Abheben") );
        centerPanel.add( manipulationsPanel );
    }

    // Mockup starten
    public static void main(String[] args) {
        new MainView();
    }
}
