package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.concurrent.Flow;

public class BilanzView extends View {

    private JTextField giroAnzahlFeld, sparAnzahlFeld, festzinsAnzahlFeld;
    private JTextField giroSummeFeld, sparSummeFeld, festzinsSummeFeld,
        kreditSummeFeld;

    public BilanzView() {
        super("Bilanz");
        addComponents();
        pack();
        setVisible(true);
    }

    private void addComponents() {
        setLayout( new BorderLayout() );
        getRootPane().setBorder( new EmptyBorder(5,5,5,5) );
        JPanel centerPanel = new JPanel( new GridLayout(4,1) );
        JPanel bottomPanel = new JPanel( new FlowLayout(FlowLayout.RIGHT) );
        JButton okButton = new JButton("Ok");
        okButton.addActionListener( e -> dispose() );
        bottomPanel.add(okButton);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        JPanel giroPanel = new JPanel( new FlowLayout(FlowLayout.RIGHT) );
        JPanel sparPanel = new JPanel( new FlowLayout(FlowLayout.RIGHT) );
        JPanel festzinsPanel = new JPanel( new FlowLayout(FlowLayout.RIGHT) );
        JPanel kreditPanel = new JPanel( new FlowLayout(FlowLayout.RIGHT) );

        giroAnzahlFeld = buildAnzahlFeld();
        sparAnzahlFeld = buildAnzahlFeld();
        festzinsAnzahlFeld = buildAnzahlFeld();

        giroSummeFeld = buildPanel(giroPanel, "Girokonten", giroAnzahlFeld);
        sparSummeFeld = buildPanel(sparPanel, "Sparkonten", sparAnzahlFeld);
        festzinsSummeFeld = buildPanel(festzinsPanel, "Festzinskonten", festzinsAnzahlFeld);
        kreditSummeFeld = buildPanel(kreditPanel, "Kredite", null);

        centerPanel.add(giroPanel);
        centerPanel.add(sparPanel);
        centerPanel.add(festzinsPanel);
        centerPanel.add(kreditPanel);
    }

    private JTextField buildAnzahlFeld() {
        JTextField countField = new JTextField("0");
        countField.setColumns(3);
        countField.setEditable(false);
        return countField;
    }

    private JTextField buildPanel(JPanel panel, String text, JTextField countField) {
        JLabel label = new JLabel("  " + text + "    ");
        panel.add( label );
        if (countField != null) panel.add(countField);
        JTextField amountField = new JTextField("0.00 €");
        amountField.setColumns(8);
        amountField.setEditable(false);
        panel.add( amountField );
        return amountField;
    }

    public void setGiroAnzahl(int giroAnzahl) {
        giroAnzahlFeld.setText( Integer.toString(giroAnzahl) );
    }

    public void setSparAnzahl(int sparAnzahl) {
        sparAnzahlFeld.setText( Integer.toString(sparAnzahl) );
    }

    public void setFestzinsAnzahl(int festzinsAnzahl) {
        festzinsAnzahlFeld.setText( Integer.toString(festzinsAnzahl) );
    }

    public void setGiroSumme(double betrag) {
        DecimalFormat df = new DecimalFormat("#,##0.00 €");
        giroSummeFeld.setText( df.format(betrag) );
    }

    public void setSparSumme(double betrag) {
        DecimalFormat df = new DecimalFormat("#,##0.00 €");
        sparSummeFeld.setText( df.format(betrag) );
    }

    public void setFestzinsSumme(double betrag) {
        DecimalFormat df = new DecimalFormat("#,##0.00 €");
        festzinsSummeFeld.setText( df.format(betrag) );
    }

    public void setKreditSumme(double betrag) {
        DecimalFormat df = new DecimalFormat("#,##0.00 €");
        kreditSummeFeld.setText( df.format(betrag) );
    }

    public static void main(String[] args) {
        new BilanzView();
    }
}
