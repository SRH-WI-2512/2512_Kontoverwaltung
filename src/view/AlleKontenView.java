package view;

import model.Konto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class AlleKontenView extends View {

    private final JList<Konto> kontoList;

    public AlleKontenView() {
        super();
        setTitle("Alle Konten anzeigen");
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
