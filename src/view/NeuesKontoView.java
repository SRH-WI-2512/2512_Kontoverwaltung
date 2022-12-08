package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NeuesKontoView extends View {
    private JRadioButton radioGiro, radioSpar, radioFest;
    private JTextField kontoinhaberTextfield, kreditlimitTextfield, zinssatzTextfield, laufzeitTextfield;
    private JButton anlegenButton;
    private JPanel kreditlimitPanel, zinssatzPanel, laufzeitPanel;

    public NeuesKontoView() {
        super("Kontoverwaltung");
        addComponents();
        pack();
        setVisible(true);
        switchKonto('G');
    }

    public void addComponents() {
        JPanel centerPanel = new JPanel( new GridLayout(1,2) );
        JPanel bottomPanel = new JPanel( new FlowLayout(FlowLayout.CENTER) );
        this.add( new JLabel("Neues Konto anlegen"), BorderLayout.NORTH );
        this.add( centerPanel, BorderLayout.CENTER );
        this.add( bottomPanel, BorderLayout.SOUTH );
        addCenterComponents( centerPanel );
        addButtons( bottomPanel );
    }

    private void addButtons(JPanel bottomPanel) {
        bottomPanel.setBorder( new EmptyBorder(5,5,5,5) );
        JButton abbrechenButton = new JButton("Abbrechen");
        anlegenButton = new JButton("Anlegen");
        bottomPanel.add(abbrechenButton);
        bottomPanel.add(anlegenButton);
        abbrechenButton.addActionListener( e -> dispose() );
    }

    private void addCenterComponents(JPanel centerPanel) {
        centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel centerLeft = new JPanel( new GridLayout(3,1));
        radioGiro = new JRadioButton("Girokonto");
        radioSpar = new JRadioButton("Sparkonto");
        radioFest = new JRadioButton("Festzinskonto");
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioGiro);
        bg.add(radioSpar);
        bg.add(radioFest);
        centerLeft.add(radioGiro);
        centerLeft.add(radioSpar);
        centerLeft.add(radioFest);
        radioGiro.addActionListener( this::switchKontoListener );
        radioSpar.addActionListener( this::switchKontoListener );
        radioFest.addActionListener( this::switchKontoListener );

        JPanel centerRight = new JPanel( new GridLayout(4,1) );
        kontoinhaberTextfield = new JTextField("Max Mustermann");
        kreditlimitTextfield = new JTextField();
        zinssatzTextfield = new JTextField();
        laufzeitTextfield = new JTextField();

        JPanel kontoinhaberPanel = new JPanel( new GridLayout(1,2) );
        kreditlimitPanel = new JPanel( new GridLayout(1,2) );
        zinssatzPanel = new JPanel( new GridLayout(1,2) );
        laufzeitPanel = new JPanel( new GridLayout(1,2) );

        kontoinhaberPanel.add( new JLabel("Kontoinhaber") );
        kontoinhaberPanel.add(kontoinhaberTextfield);
        kreditlimitPanel.add( new JLabel("Kreditlimit") );
        kreditlimitPanel.add(kreditlimitTextfield);
        zinssatzPanel.add( new JLabel("Zinssatz") );
        zinssatzPanel.add(zinssatzTextfield);
        laufzeitPanel.add( new JLabel("Laufzeit"));
        laufzeitPanel.add(laufzeitTextfield);

        centerRight.add( kontoinhaberPanel );
        centerRight.add( kreditlimitPanel );
        centerRight.add( zinssatzPanel );
        centerRight.add( laufzeitPanel );

        centerPanel.add(centerLeft);
        centerPanel.add(centerRight);
    }

    public void setAnlegenButtonListener(ActionListener listener){anlegenButton.addActionListener(listener);}

    private void switchKontoListener(ActionEvent actionEvent) {
        switchKonto( getKonto() );
    }

    private void switchKonto(char kontotyp) {
        // erstmal alle Elemente ausblenden
        kreditlimitPanel.setVisible(false);
        zinssatzPanel.setVisible(false);
        laufzeitPanel.setVisible(false);

        switch (kontotyp) {
            case 'G' -> {
                radioGiro.setSelected(true);
                kreditlimitPanel.setVisible(true);
            }
            case 'S' -> {
                radioSpar.setSelected(true);
                zinssatzPanel.setVisible(true);
            }
            case 'F' -> {
                radioFest.setSelected(true);
                zinssatzPanel.setVisible(true);
                laufzeitPanel.setVisible(true);
            }
        }
    }

    public char getKonto() {
        if(radioGiro.isSelected()) return 'G';
        else if(radioSpar.isSelected()) return 'S';
        else return 'F';
    }

    public String getKontoinhaber() {
        return kontoinhaberTextfield.getText();
    }

    // im ersten Ansatz erhalten wir den double hierüber
    public double getKreditlimit() {
        String textValue = kreditlimitTextfield.getText();
        double kreditlimit = 0.0;
        try {
            kreditlimit = Double.parseDouble(textValue);
        }
        catch (NumberFormatException e) {
            System.err.println("Kreditlimit im falschen Format!");
        }
        return kreditlimit;
    }

    public double getZinssatz() {
        String textValue = zinssatzTextfield.getText();
        double zinssatz = 0.0;
        try {
            zinssatz = Double.parseDouble(textValue);
        }
        catch (NumberFormatException e) {
            System.err.println("Zinssatz im falschen Format!");
        }
        return zinssatz;
    }

    // Getter für Laufzeit
    public int getLaufzeit() {
        String textValue = zinssatzTextfield.getText();
        int laufzeit = 0;
        try {
            laufzeit = Integer.parseInt(textValue);
        }
        catch (NumberFormatException e) {
            System.err.println("Laufzeit im falschen Format!");
        }
        return laufzeit;
    }

    public static void main(String[] args) {
        // Zum Testen des Mockups.
        new NeuesKontoView();
    }
}