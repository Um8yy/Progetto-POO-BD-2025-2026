package model;

/**
 gestisce la recensione che scrive al cliente legata alla struttura avendo la possibilità di allegare testo e/o foto
 */
public class Recensione {


        private int stelle;
        private String testo;
        private boolean foto;

    /**
     * Instantiates a new Recensione.
     *
     * @param stelle  stelle
     * @param testo   testo
     * @param foto    foto
     */
    public Recensione(int stelle, String testo, boolean foto){

        if (stelle >= 0 && stelle <= 5) {
            this.stelle = stelle;
        } else {
            this.stelle = 0;
        }

        this.testo = testo;
        this.foto = foto;
    }


    /**
     * Controllo se è presente il testo per la descrizione
     *
     * @return the string
     */
    public String vediTesto (){

            if((testo!=null) && (!testo.isEmpty())){
                return testo;
            }
            else{
                return "Nessuna descrizione presente";
            }

        }


    /**
     * Gets stelle.
     *
     * @return the stelle
     */
    public int getStelle() {
        return stelle;
    }

    /**
     * Gets testo.
     *
     * @return the testo
     */
    public String getTesto() {
        return testo;
    }

    /**
     *  Controllo se sono presenti o no fotografie
     *
     * @return the boolean (true se ci sono , false se non sono presenti)
     */
    public boolean isFoto() {
        return foto;
    }

    /**
     * Info recensione string.
     *
     * @param c the c
     * @param s the s
     * @return the string
     */
    public String infoRecensione (Cliente c , Struttura s){
            return   "Cliente: " + c.getNome() + " " + c.getCognome() + "\n"
                    + "Nome della struttura : " + s.restituisciNome () +
                     "Valutazione: " + getStelle() + " Descrizione: " + getTesto()
             + "Foto allegate: " + (isFoto() ? "Sì" : "No");


        }


}
