package controller;

import dao.KontoDAO;
import dao.TempDAO;
import model.Giro;
import model.Konto;

public class TestDAO {

    private static void alleKontenAnzeigen(KontoDAO kontoDB) {
        System.out.println("Kontenübersicht in der Datenbank:");
        for (Konto konto : kontoDB.getAllKonten()) {
            System.out.print(konto);
            System.out.println(" : " + konto.getKontostand() + " €");
        }
    }

    public static void main(String[] args) {
        KontoDAO kontoDB = new TempDAO();

        Konto k1 = kontoDB.getKontoByKontonummer(1);
        k1.einzahlen(1_000_000);            // <- Änderung darf sich NICHT in der DB auswirken
        alleKontenAnzeigen(kontoDB);

        Konto k2 = new Giro(50, 5000, "Mr. Rich", 20000);
        kontoDB.insertKonto(k2);
        alleKontenAnzeigen(kontoDB);

        k2.abheben(24999.9);                  // <- Änderung darf sich NICHT in der DB auswirken
        alleKontenAnzeigen(kontoDB);

        //kontoDB.updateKonto(k2.getKontonummer(), k2);
        kontoDB.updateKonto(k1.getKontonummer(), k1);
        alleKontenAnzeigen(kontoDB);
    }
}
