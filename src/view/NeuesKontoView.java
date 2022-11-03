package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class NeuesKontoView extends JFrame {
    private JRadioButton radioGiro, radioSpar, radioFest;
    private JTextField kontoinhaber, kreditlimit, zinssatz, laufzeit;
    private JButton hauptmenü, anlegen;

    public NeuesKontoView() {
        // setSize() könnte abstrahiert werden => DRY
        setSize(600, 400);
        setTitle("Kontoverwaltung");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addComponents();
        pack();
        setVisible(true);
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
        hauptmenü = new JButton("Hauptmenü");
        anlegen = new JButton("Anlegen");
        bottomPanel.add(hauptmenü);
        bottomPanel.add(anlegen);
    }

    private void addCenterComponents(JPanel centerPanel) {
        centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel centerLeft = new JPanel( new GridLayout(3,1));
        radioGiro = new JRadioButton("Girokonto");
        radioSpar = new JRadioButton("Sparkonto");
        radioFest = new JRadioButton("Festzinskonto");
        radioGiro.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioGiro);
        bg.add(radioSpar);
        bg.add(radioFest);

        centerLeft.add(radioGiro);
        centerLeft.add(radioSpar);
        centerLeft.add(radioFest);

        JPanel centerRight = new JPanel( new GridLayout(4,2));
        kontoinhaber = new JTextField("Max Mustermann");
        kreditlimit = new JTextField();
        zinssatz = new JTextField();
        laufzeit = new JTextField();

        centerRight.add( new JLabel("Kontoinhaber") );
        centerRight.add(kontoinhaber);
        centerRight.add( new JLabel("Kreditlimit"));
        centerRight.add(kreditlimit);
        centerRight.add( new JLabel("Zinssatz") );
        centerRight.add(zinssatz);
        centerRight.add( new JLabel("Laufzeit"));
        centerRight.add(laufzeit);


        centerPanel.add(centerLeft);
        centerPanel.add(centerRight);
    }

    public void setHauptmenüListener(ActionListener listener){
        hauptmenü.addActionListener(listener);
    }

    public void setAnlegen(ActionListener listener){
        anlegen.addActionListener(listener);
    }

    public int getKonto(){
        if(radioGiro.isSelected()) return 1;
        else if(radioSpar.isSelected()) return 2;
        else return 3;
    }

    public JTextField getKontoinhaber() {
        return kontoinhaber;
    }

    public JTextField getKreditlimit() {
        return kreditlimit;
    }

    public JTextField getZinssatz() {
        return zinssatz;
    }

    // Getter für Laufzeit
    public JTextField getLaufzeit() {
        return laufzeit;
    }

    public static void main(String[] args) {
        new NeuesKontoView();
    }
}