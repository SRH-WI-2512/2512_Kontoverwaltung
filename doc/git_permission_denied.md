# Guide zum Lösen des Error 403 beim Git Push
## Ausgangssituation
Ein Projekt soll mit der Veisionskontrolle Git bearbeitet werden.
Wenn das auf Github mit einer Organisation und 
einzelnen Teams umgesetzt werden soll, kann es beim Pushen 
zum "Error 403 - Permission Denied" kommen. Der Pushvorgang wird 
dann nicht durchgeführt.

### Konfiguration auf Github:
Der Ersteller der Organisation muss die einzelnen Teammitglieder erst 
der Organisation und dem Projektteam hinzufügen.

### Windows Einstellungen:
![alt text](doc/Systemsteuerung_Alle Systemsteuerungselemente_Anmeldeinformationsverwaltung.png)
In der Anmeldeiformationsverwaltung innerhalb der Windows Systemeinstellungen
müssen unter dem Reiter "Windows-Anmeldinformationen" bei den generischen Anmeldeinformationen alle Einträge 
zu Git gelöscht werden.  

### Git Einstellungen:
Um Git richtig zu konfigurieren, muss man mit der Eingabeaufforderung in den Projektpfad wechseln.
Wenn Git als portable Version installiert ist, muss bei den folgenden Befehlen anstelle von "git" 
der Dateipfad zur git.exe in doppelten Hochkommata eingegeben werden.

`code` git config --global --unset credential.helper

`code` git config --system --unset credential.helper

`code` git config --global credential.helper manager

`code` git config credential.helper manager-core

### IntelliJ Einstellungen:
Mit "Strg+Alt+s" öffnet man die Optionen. In dem Untermenü Version Controll=>Git
muss ganz unten die Checkbox "use credential helper" ausgewählt sein.


