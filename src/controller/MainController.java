package controller;

import dao.KontoDAO;
import dao.TempDAO;
import model.Konto;
import view.MainView;
import view.NeuesKontoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainController {
    private MainView mainView;
    private KontoDAO kontoDB;

    public MainController(MainView mainView, KontoDAO kontoDB) {
        this.mainView = mainView;
        this.kontoDB = kontoDB;

        mainView.setNeuesKontoButtonListener( this::performNeuesKonto );
        mainView.setKontoAnzeigenButtonListener( this::performKontoAnzeigen );
        mainView.setEinzahlenButtonListener( this::performEinzahlen );
    }

    private void performEinzahlen(ActionEvent actionEvent) {
        int kontonummer = mainView.getKontonummer();
        Konto konto = kontoDB.getKontoByKontonummer(kontonummer);
        if (konto != null) {
            konto.einzahlen( mainView.getBetrag() );
            kontoDB.updateKonto( kontonummer, konto );
        }
        else mainView.zeigeFehlermeldung("Konto nicht gefunden");
    }

    private void performKontoAnzeigen(ActionEvent actionEvent) {
        int kontonummer = mainView.getKontonummer();

        Konto konto = kontoDB.getKontoByKontonummer(kontonummer);
        if (konto == null) {
            mainView.setKontoinhaber("");
            mainView.clearKontostand();
            mainView.zeigeFehlermeldung("Dieses Konto existiert nicht.");
        }
        else {
            mainView.setKontoinhaber(konto.getInhaber());
            mainView.setKontostand(konto.getKontostand());
        }
    }

    private void performNeuesKonto(ActionEvent actionEvent) {
        NeuesKontoView neuesKontoView = new NeuesKontoView();
        mainView.setEnabled(false);

        neuesKontoView.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {}

            @Override
            public void windowClosed(WindowEvent e) {
                mainView.setEnabled(true);
                mainView.requestFocus();
            }

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
    }

    public static void main(String[] args) {
        new MainController( new MainView(), new TempDAO() );
    }
}
