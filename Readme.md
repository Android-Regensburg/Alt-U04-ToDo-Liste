# U04 | ToDo-Liste

![Cover für die vierte Übungsaufgabe](./docs/cover.png)

## Downloads

- [Download des Starterpakets](https://github.com/Android-Regensburg/U04-ToDo-Liste/archive/master.zip)
- [Download des Lösungsvorschlag](https://github.com/Android-Regensburg/U04-ToDo-Liste/archive/solution.zip)

## Aufgabe

Erstellen Sie eine einfache **ToDo-Liste**, die es dem Benutzer erlaubt Aufgaben über ein Eingabefeld (`EditText`) zu erstellen. Die eingegebenen Aufgaben werden in einer `ListView` angezeigt und können gelöscht werden, in dem der Benutzer länger auf den entsprechenden Eintrag in der Liste klickt (`OnItemLongClick()`). Speichern Sie die Aufgaben als String in einer entsprechenden `ArrayList` und  nutzen Sie zur Anbindung an das *User Interface* einen `ArrayAdapter`.

## Hinweise

* Benutzen sie für diese Übung das Constraint Layout. In einem Constraint Layout werden Views mittels Constraints “magnetisch” an andere gebunden um sie so relativ im Layout zu platzieren.

* Sie können sich Guidelines zu Hilfe nehmen um UI-Elemente exakt zu platzieren. Ziehen sie dazu ein Guideline View (Palette -> Layouts -> Guideline) in ihr Layout und nutzen sie Constraints um andere Views von der Position der Guideline abhängig zu machen.

* Auf einer `ListView` lassen sich verschiedene *Listener* registrieren, um Interaktionen mit den dargestellten Einträgen abzufangen. Unter anderem können Sie über einen `OnItemLongClickListener()` einen längeren Touch-Event auf einen Listeneintrag abfangen. Die entsprechende *Callback*-Methode des *Listeners* bekommt die Position des *geklickten* Eintrags als Parameter übergeben.

* Die Position des geklickten Eintrages entspricht gleichzeitig dem Index des geklickten Items in der Liste des Adapters

## Vorgehen

Versuchen Sie „ordentlichen“ Code zu erstellen. Lagern Sie Teilaufgaben in Methoden aus und referenzieren Sie nur solche Elemente als Member, die Sie auch tatsächliche methodenübergreifend benötigen. Zur Zuweisung eines *Listener* zu einem `View` reicht eine lokale Referenz innerhalb der entsprechenden Methode. Wenn Sie nach der Initialisierung der Benutzerschnittstelle nicht mehr direkt auf UI-Elemente zugreifen müssen, sollten diese Elemente auch nicht als Member verfügbar sein. Versuchen Sie Fehler abzufangen. Ihre App sollte keine Probleme damit haben, eine leere Eingabe des Benutzers zu verarbeiten.

### Anleitung

1. Erstellen Sie das nötige Layout durch Bearbeiten der entsprechenden XML-Datei. Sie benötigen ein `EditText` für die Eingabe einer neuen Aufgabe, einen Button zum Hinzufügen der Aufgabe zur Liste, sowie ein `ListView` zur Darstellung der Aufgaben. Über `Constraints` können Sie UI-Elemente relativ auf dem Bildschirm platzieren. Das `EditText` verfügt über ein Attribut `hint`, über das ein Hilfetext definiert werden kann. Dieser wird angezeigt, wenn das Textfeld leer ist. Lagern Sie Texte und Farben in entsprechende XML-Dateien aus.

2. Bearbeiten Sie nun die `Activity`: Initialisieren  Sie eine `ArrayList`, die Daten vom Typ `String` beinhalten kann. In dieser werden später die Aufgaben gespeichert.

3. Registrieren Sie einen `OnClickListener()` auf dem Button. Beim Klicken soll der aktuelle Inhalt des `EditText` als String in die `ArrayList` gespeichert werden. Das Textfeld soll danach geleert werden.

4. Registrieren Sie einen `OnItemLongClickListener()` auf dem `ListView`. Wird ein Item länger *angeklickt*, so soll das entsprechende Element aus der `ArrayList` gelöscht werden. Die Position des *angeklickten* Elements wird über den Parameter `position` übergeben.

5. Erstellen Sie anschließend  einen `ArrayAdapter` für den Datentyp `String`. Dieser erwartet für die Listeneinträge das Layout `android.R.layout.simple_list_item_1` und greift als Datenbasis auf die `ArrayList` zu. Verbinden Sie den Adapter mit dem `ListView`.

6. Damit der Adapter Änderung aus der Liste an das UI bzw. den `ListView` weitergibt, müssen Sie nach allen Manipulationen der `ArrayList` die Methode `notifyDatSetChanged()` des Adapters aufrufen.

## Quellen
Große Teile dieser Anleitung wurden aus der Übungsaufgabe 4 des Sommersemesters 2013 von Thomas Wagner und Thomas Wilhelm übernommen welche von Alexander Bazo überarbeitet wurde.

## Anhang
### Screenshots

![Screenshot der vierten App](./docs/screenshot-1.png "Startbildschirm der App")

![Screenshot der vierten App](./docs/screenshot-2.png "Startbildschirm und Eingabe der App")

![Screenshot der vierten App](./docs/screenshot-3.png "Startbildschirm und ListView Anzeige der App")
