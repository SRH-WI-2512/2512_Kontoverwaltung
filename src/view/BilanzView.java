package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
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
        return countField;
    }

    private JTextField buildPanel(JPanel panel, String text, JTextField countField) {
        JLabel label = new JLabel("  " + text + "    ");
        panel.add( label );
        if (countField != null) panel.add(countField);
        JTextField amountField = new JTextField("0.00 €");
        amountField.setColumns(8);
        panel.add( amountField );
        return amountField;
    }

    public static void main(String[] args) {
        new BilanzView();
    }
}
