package MalteDammann.uebRatio;

/**
 * Beschreibung:
 * Ratio-Klasse welche das Interface "IRatio" implementiert und als Rechenobjekt
 * des Progamms dient. Stellt eine rationale Zahl mit Nenner und Zähler dar.
 *
 * @author Malte Dammann
 * E-Mail: s0549309@htw-berlin.de
 * Bearbeitungszeitraum: 29.11.14 - 18.01.2015
 *
 * Modul: Programmierung 1
 * 
 * Dateiname: Ratio.java
 * IDE: NetBeans IDE 8.0.2
 * Java: 1.8.0_20; Java HotSpot(TM) 64-Bit
 *
 * @since 2014-11-30
 *
 */
public class Ratio implements IRatio {

    // Attribute
    private int zaehler;
    private int nenner;

    /**
     * Default Konstruktor:
     * initialisiert Zähler auf 0 und Nenner auf 1
     */
    public Ratio() {
        this.zaehler = 0;
        this.nenner = 1;
    }// end of Ratio

    /**
     * Parametrisierter Konstruktor
     *
     * @param zaehler (int): Ganzzahliger Zähler
     * @param nenner  (int): Ganzzahliger Nenner
     */
    public Ratio(int zaehler, int nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }// end of Ratio

    /**
     * Getter-Methoder für den Zähler
     *
     * @return zaehler (int): Ganzzahliger Zähler
     */
    public int getZaehler() {
        return zaehler;
    }// end of getZaehler

    /**
     * Getter-Methoder für den Nenner
     *
     * @return nenner (int): Ganzzahliger Nenner
     */
    public int getNenner() {
        return nenner;
    }// end of getNenner

    /**
     * Setter-Methode für den Zähler
     *
     * @param zaehler (int): Ganzzahliger Zähler
     */
    public void setZaehler(int zaehler) {
        this.zaehler = zaehler;
    }// end of setZaehler

    /**
     * Setter-Methode für den Nenner
     *
     * @param nenner (int): Ganzzahliger Nenner
     */
    public void setNenner(int nenner) {
        if (nenner == 0){
            throw new ArithmeticException("Division durch '0' nicht erlaubt.");
        }
        this.nenner = nenner;
    }// end of setNenner

    // Durch das Interface impementierte Methoden:
    /**
     * addire-Methode:
     * Methode zum Addieren einer rationalen Zahl.
     *
     * @param zahl2 (Ratio): Zahl vom Objekt Ratio mit der gerechnet wird
     *
     * @return result (Ratio)
     *
     * Formel: z/n + x/y = (z * y + n * x ) / (n * y )
     */
    @Override
    public Ratio addiere(Ratio zahl2) {

        zaehler = (this.zaehler * zahl2.getNenner() + this.nenner * zahl2.getZaehler());
        nenner = (this.nenner * zahl2.getNenner());

        kuerze();

        Ratio result = new Ratio(zaehler, nenner);
        return result;

    } // end of addiere

    /**
     * subtrahiere-Methode:
     * Methode zum Subtrahieren einer rationalen Zahl.
     *
     * @param zahl2 (Ratio): Zahl vom Objekt Ratio mit der gerechnet wird
     *
     * @return result (Ratio)
     *
     * Fromel: z/n - x/y = (z * y - n * x ) / (n * y )
     */
    @Override
    public Ratio subtrahiere(Ratio zahl2) {

        zaehler = (this.zaehler * zahl2.getNenner() - this.nenner * zahl2.getZaehler());
        nenner = (this.nenner * zahl2.getNenner());

        kuerze();

        Ratio result = new Ratio(zaehler, nenner);
        return result;

    } // end of subtrahiere

    /**
     * multipliziere-Methode:
     * Methode zum Multiplizieren mit einer rationalen Zahl.
     *
     * @param zahl2 (Ratio): Zahl vom Objekt Ratio mit der gerechnet wird
     *
     * @return result (Ratio): Ergebnis
     *
     * Formel: z/n * x/y = (z * x ) / (n * y )
     */
    @Override
    public Ratio multipliziere(Ratio zahl2) {

        zaehler = (this.zaehler * zahl2.getZaehler());
        nenner = (this.nenner * zahl2.getNenner());

        kuerze();

        Ratio result = new Ratio(zaehler, nenner);
        return result;

    } // end of multipliziere

    /**
     * dividiere-Methode:
     * Methode zum Dividieren mit einer rationalen Zahl.
     *
     * @param zahl2 (Ratio): Zahl vom Objekt Ratio mit der gerechnet wird
     *
     * @return result (Ratio): Ergebnis
     *
     * @throws ArithmeticException wenn mathematischer Fehler auftritt
     *
     * Formel: z/n : x/y = (z * y ) / (n * x )
     */
    @Override
    public Ratio dividiere(Ratio zahl2) throws ArithmeticException {

        zaehler = (this.zaehler * zahl2.getNenner());
        nenner = (this.nenner * zahl2.getZaehler());

        kuerze();

        Ratio result = new Ratio(zaehler, nenner);
        return result;

    } // end of dividiere

    /**
     * kuerze-Methode:
     * Methode zum Kuerzen einer rationalen Zahl.
     *
     * @return this (Ratio): Ergebnis
     *
     */
    @Override
    public Ratio kuerze() throws ArithmeticException {

        int i,
                n = Math.abs(nenner),
                z = Math.abs(zaehler);

        if (nenner == 0) {
            throw new ArithmeticException("Durch '0' teilen ist nicht erlaubt... \n");
        } else {
            while (z > 0) {
                if (z < n) {
                    i = n;
                    n = z;
                    z = i;
                }
                z = z - n;
            }

            nenner = nenner / n;
            zaehler = zaehler / n;
        }
        
        return this;
        
    } // end of kuerze

    /**
     * equals-Methode:
     * Methode zum Vergleichen zweier Objekte.
     *
     * @param obj (Object): Zu vergleichendes Objekt
     *
     * @return boolean: true oder false, ob das Objekt identisch ist oder nicht
     *
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        if (obj.getClass() == this.getClass()) {
            Ratio ratio = (Ratio) obj;
            if (this.zaehler == ratio.getZaehler() && this.nenner == ratio.getNenner()) {
                return true;
            }
        }
        
        return false;
        
    } // end of equals

    /**
     * toString-Methode:
     * Methode zum Umwandeln des Objekts in einen String.
     *
     * @return String: in der Form "z/n"
     *
     */
    @Override
    public String toString() {
        return zaehler + "/" + nenner;
    } // end of toString

} // end of class
