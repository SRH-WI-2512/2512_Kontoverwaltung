package view;

import model.Konto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class AlleKontenView extends JFrame {

    private final JList<Konto> kontoList;

    public AlleKontenView() {
        setSize(600, 400);
        setTitle("Alle Konten anzeigen");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getRootPane().setBorder( new EmptyBorder(5,5,5,5) );

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane);

        kontoList = new JList<>();
        kontoList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        scrollPane.setViewportView( kontoList );

        setVisible(true);
    }

    public void setKontoListMouseListener(MouseAdapter adapter) {
        kontoList.addMouseListener(adapter);
    }

    public void setKontoListDefaultModel(DefaultListModel<Konto> defaultModel) {
        kontoList.setModel( defaultModel );
    }

    public Konto getSelectedKonto() {
        return kontoList.getSelectedValue();
    }
}
