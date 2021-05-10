# ATdIT_Gruppe2
IBAIT 20 Project


Projekt-Meeting - Mi, 07.04.2021

- Einteilung in Aufgabenbereiche (Wer programmiert, Wer designt, Wer sammelt Informationen)
- Fragen für 1. Programmierstunde bwzüglich Front-End sammeln
- erste Schritte überlegen
  - zuerst Mock-Daten zur einfacheren Benutzung, später eventuell DB einbinden
  - Usecase für Präsentation festlegen: Ummeldung bei Wohnungswechsel
- Termin für nächstes Meeting: Di, 13.04.2021

___________________________________________________________________________________________________________________________________________________________________________________

Projekt-Meeting - Di, 13.04.2021

- Organisation der Aufgabenverteilung planen
- Termin für wöchentliches Meeting festlegen

- Entscheidungen:
  - Java Web Server nicht selbst schreiben -> fertigen downloaden und implimentieren
  - Wöchentliches Meeting: Mittwochs 14:00-15:00 Uhr

- Aufgaben:
  - Julian:   PostgreSQL Anleitung erstellen, damit jeder seine eigene DB anlegen kann
  - Paulina:  Prozessdiagramm für Ummeldungsprozess erstellen
  - Eda: Beschreibung des Hintergrundes des Projektes (nicht technisch; nur allgemeine Idee)
  - Peter, Marvin: Java WebServer recherchieren (speziell HTML / CSS Anbindung)
- Termin für nächstes Meeting: Mi, 14.04.2021

___________________________________________________________________________________________________________________________________________________________________________________

Projekt-Meeting - Mi, 14.04.2021

- Ideen / Challanges:
  - Docker Image für DB erstellen um individuelle DB Erstellung zu verhindern
  - Wie wird sicher gestellt, dass nicht unerlaubte Autenthentifizierung erfolgt (z.B. bei Personalausweis-Verlust)
    - bei geringeren Sicherheits-Dokumenten: Hochladen Vorder- und Rückseite Personalausweis
    - bei wichtigeren Dokumenten und Prozessen: selbiges + persönliches Erscheinen
    - bei erstmaliger Anmeldung: Code auf postialischen Weg zusenden
  - Wollen wir Benutzerkonten machen, damit teilweise ausgefüllte Dokumente zwischengespeichert werden müssen?

- Entscheidungen:
  - Zeitplan:
    - 21.04.2021 - Zusammentragen von Daten, die für das Programm bzw. die Formulare benötigt werden
    - 25.04.2021 - Fertigstellung Programm-Architektur
    - 11.05.2021 - Review
    - 26.05.2021 - Präsentation
  - erst mal keine Benutzerkonten
  - Authentifizierung der Abfrage eines Formular-Bearbeitungsprozesses über Tokens lösen
  - allgemein bei den Aufgaben: jeder hilft jedem, aber die eigene Aufgabe steht im Vordergrund

- Aufgaben:
  - Julian: nach Docker Image Erstellung schauen
  - Paulina: Prozesse und Frontpage Mockup designen
  - Eda: Daten zusammentragen (auch kategorisieren in z.B. persönlich und unperönlich)
  - Peter/Marvin: erste Klassenstruktur erstellen

- Termin nächstes Meeting: 21.04.2021 / Sub-Meeting (Klassenstruktur): 17.04.2021
___________________________________________________________________________________________________________________________________________________________________________________

Projekt-Meeting 21.04.2021

- Ideen/Challanges
  - Usecase-Ablauf:
    - Landing Page
    - *Ummenldung anklicken*
    - Ummeldungs-Page
    - Auswahl an Optionen: Antrag ausfüllen, Formulare anzeigen/downloaden, Ansprechpartner, Termin vereinbaren
  - Bei Terminvereinbarung
    - Kalendereintrag automatisch per Mail senden (asl Outlook-Datei)
    - empfohlener Terminzeitpunkt (auf Basis von Bearbeitungsstaus -> Token)
  - Token-System
    - bei Abgabe eines Formulares wird ein Token generiert, der per Mail zugesendet wird
    - mit diesem kann man den Bearbeitungsstatus jederzeit angucken
    - Automatische Terminerinnerung bei gewissen Bearbeitungsstatus

- Was fertig ist
  - Docker Image

___________________________________________________________________________________________________________________________________________________________________________________

Projekt-Meeting 28.04.2021

- Ideen/Challanges
  - Klassenstruktur
    - für die Anzeige der Fragen und das Auslesen der Antworten wird eine Vererbungsstruktur erstellen

- Aufgaben
  - Marvin
    - Klassenstruktur
    - Mockup HTML Page
  - Peter
    - Webserver pushen
  - Julian
    - HTML Formular für Fragen
  - Paulina
    - Prozesskette digitalisieren
  - Eda
    - Fragen zum Formular ausfüllen

___________________________________________________________________________________________________________________________________________________________________________________

Projekt-Meeting 05.05.2021

- Ideen/Challanges
  - GUI
  - Rückbau Webserver (weiterer Aufwand zu groß)

- Aufgaben
  - Marvin
    - GUI
  - Peter
    - delete Webserver
    - Doku, Tests
  - Julian
    - Logik, Datenbank
  - Paulina
    - Inhalte anfertigen, Übersetzen
  - Eda
    - Inhalte anfertigen, Übersetzen

