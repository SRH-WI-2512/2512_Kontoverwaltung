package controller;

import dao.KontoDAO;
import dao.SqlDAO;
import dao.TempDAO;
import model.Festzinskonto;
import model.Giro;
import model.Konto;
import model.Sparkonto;
import view.View;
import view.AlleKontenView;
import view.MainView;
import view.NeuesKontoView;

import javax.swing.*;
import java.awt.event.*;

public class MainController {
    private MainView mainView;
    private KontoDAO kontoDB;
    private NeuesKontoView neuesKontoView;

    public MainController(MainView mainView, KontoDAO kontoDB) {
        this.mainView = mainView;
        this.kontoDB = kontoDB;

        mainView.setNeuesKontoButtonListener( this::performNeuesKonto );
        mainView.setKontoAnzeigenButtonListener( this::performKontoAnzeigen );
        mainView.setEinzahlenButtonListener( this::performEinzahlenAbheben );
        mainView.setAbhebenButtonListener( this::performEinzahlenAbheben );
        mainView.setKontoLöschenButtonListener( this::performKontoLöschen );

        mainView.setAlleKontenAnzeigenButtonListener( this::performAlleKontenAnzeigen );
    }

    private void zeigeKonto(Konto konto) {
        if (konto != null) {
            mainView.setKontonummer(konto.getKontonummer());
            mainView.setKontoinhaber(konto.getInhaber());
            mainView.setKontostand(konto.getKontostand());
        }
        else {
            mainView.setKontoinhaber("");
            mainView.clearKontostand();
        }
    }

    private void performAlleKontenAnzeigen(ActionEvent actionEvent) {
        AlleKontenView alleKontenView = new AlleKontenView();
        mainView.setEnabled(false);

        DefaultListModel<Konto> kontoModel = new DefaultListModel<>();
        for (Konto konto : kontoDB.getAllKonten()) {
            kontoModel.addElement(konto);
        }

        alleKontenView.setKontoListDefaultModel(kontoModel);

        alleKontenView.setKontoListMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Konto konto = alleKontenView.getSelectedKonto();
                    zeigeKonto(konto);
                    alleKontenView.dispose();
                }
            }
        });

        /*TODO*/

        alleKontenView.addListener(mainView);
    }
    private void performKontoLöschen(ActionEvent actionEvent) {
        int kontonummer = mainView.getKontonummer();
        Konto konto = kontoDB.getKontoByKontonummer(kontonummer);
        if (konto != null) {
            if (mainView.zeigeRückfrage("Sind Sie sicher?"))
                kontoDB.deleteKonto(kontonummer);
        }
    }

  


    private void performEinzahlenAbheben(ActionEvent actionEvent) {
        int kontonummer = mainView.getKontonummer();
        Konto konto = kontoDB.getKontoByKontonummer(kontonummer);
        if (konto != null) {
            if ( mainView.istEinzahlenKlicked( actionEvent ) )
                konto.einzahlen( mainView.getBetrag() );
            else
                konto.abheben( mainView.getBetrag() );
            kontoDB.updateKonto( kontonummer, konto );
        }
        else mainView.zeigeFehlermeldung("Konto nicht gefunden");
    }

    private void performKontoAnzeigen(ActionEvent actionEvent) {
        int kontonummer = mainView.getKontonummer();

        Konto konto = kontoDB.getKontoByKontonummer(kontonummer);
        zeigeKonto(konto);
        if (konto == null)
            mainView.zeigeFehlermeldung("Dieses Konto existiert nicht.");
    }

    private void performNeuesKonto(ActionEvent actionEvent) {
        neuesKontoView = new NeuesKontoView();
        mainView.setEnabled(false);

        neuesKontoView.setAnlegenButtonListener(this::performKontoAnlegen);

        /*
        TODO
         */
        neuesKontoView.addListener(mainView);
    }

    private void performKontoAnlegen(ActionEvent actionEvent) {
        //System.out.println("Neues Konto");
        Konto k = null;
        int kontonummer = kontoDB.letzteAktuelleKontonummer() + 1;
        String name = neuesKontoView.getKontoinhaber();
        double limit = neuesKontoView.getKreditlimit();
        double zinssatz = neuesKontoView.getZinssatz();
        int laufzeit = neuesKontoView.getLaufzeit();

        switch (neuesKontoView.getKonto()){
            case 'G': k = new Giro(kontonummer, 0.0, name, limit);
            break;
            case 'S': k = new Sparkonto(kontonummer, 0.0, name, zinssatz);
            break;
            case 'F': k = new Festzinskonto(kontonummer, 0.0, name, zinssatz, laufzeit);
            break;
        }
        if (k != null) {
            if (!kontoDB.insertKonto(k))
                mainView.zeigeFehlermeldung("Konto kann nicht angelegt werden.");
        }

    }

    public static void main(String[] args) {
        new MainController( new MainView(), new TempDAO() );
    }
}
