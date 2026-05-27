package model;

/**
 gestione della camera , permettendo di restituire il tipo ( presente nell'enumerazione) per capire che tipo di camera (Singola, doppia, matrimoniale ecc..)
 e verificando prezzo e gestione
 */
public class Camera {


    private int numero;  // identifica la camera
    private double prezzo;
    private Tipo tipo;
    private boolean disponibile; // da aggiungere

    /**
     * Instantiates a new Camera.
     *
     * @param numero the numero
     * @param prezzo the prezzo
     * @param tipo   the tipo
     */
    public Camera( int numero, double prezzo, Tipo tipo ){
        this.numero = numero; // identifica la camera
        this.prezzo = prezzo;
        this.tipo=tipo;
        disponibile=true;

    }


    /**
     * Restituisci tipo tipo.
     *
     * @return the tipo
     */
    public Tipo restituisciTipo () {return tipo;}

    /**
     * Restituisci numero camera int.
     *
     * @return the int
     */
    public int restituisciNumeroCamera () {return numero;}

    /**
     * Restituisci prezzo double.
     *
     * @return the double
     */
    public double restituisciPrezzo () {return prezzo;}

    /**
     * Restituisci disponibilita boolean.
     *
     * @return the boolean
     */
    public boolean restituisciDisponibilita () {return disponibile;}

    /**
     * Imposta disponibilita.
     *
     * @param stato the stato
     */
    public void impostaDisponibilita(boolean stato) {disponibile = stato;}

    /**
     * Verifica disponibilita della camera.
     *
     * @return messaggio string in base alla disponinibilità
     */
    public String verificaDisponibilita (){
        if(disponibile == true){
            return "Disponibile";
        }
        else{
            return "Non Disponibile";
        }
    }

    /**
     * Mostra info generali per la camera .
     *
     * @return messaggio string con tutte le informazioni
     */
    public String mostraInfo (){
        return   "Numero camera: " + restituisciNumeroCamera() + ", Tipo: " + restituisciTipo()
                + " Disponibilità: " + verificaDisponibilita() + "\n"
                + "Prezzo per notte: " + restituisciPrezzo() + " €.";
    }




}
