package model;

/**
 gestisce i servizi che possono essere garantiti dalla struttura
 */
public class Servizio {


        private boolean parcheggio;
        private boolean piscina;
        private boolean palestra;
        private boolean wifi;
        private boolean spa;
        private Pensione pensione;


    /**
     * Instantiates a new Servizio.
     *
     * @param parcheggio  parcheggio
     * @param piscina     piscina
     * @param palestra    palestra
     * @param wifi        wifi
     * @param spa         spa
     * @param pensione    pensione
     */
    public Servizio(boolean parcheggio, boolean piscina, boolean palestra, boolean wifi, boolean spa, Pensione pensione){
            this.parcheggio = parcheggio;
            this.piscina = piscina;
            this.palestra = palestra;
            this.wifi = wifi;
            this.spa = spa;
            this.pensione = pensione;
        }

    /**
     * Is parcheggio boolean.
     *
     * @return the boolean
     */
    public boolean isParcheggio() {
        return parcheggio;
    }

    /**
     * Is piscina boolean.
     *
     * @return the boolean
     */
    public boolean isPiscina() {
        return piscina;
    }

    /**
     * Is palestra boolean.
     *
     * @return the boolean
     */
    public boolean isPalestra() {
        return palestra;
    }

    /**
     * Is wifi boolean.
     *
     * @return the boolean
     */
    public boolean isWifi() {
        return wifi;
    }

    /**
     * Is spa boolean.
     *
     * @return the boolean
     */
    public boolean isSpa() {
        return spa;
    }

    /**
     * Gets pensione.
     *
     * @return the pensione
     */
    public Pensione getPensione() {
        return pensione;
    }

    /**
     * Verifica che il servizio sia disponibile.
     *
     * @param servizioDaCercare l'utente può sceglere se c'è un servizio che vuole che sia presente in quella determinata struttura
     * @return  boolean  (true se è presente , false se non è presente)
     */
    public boolean verificaServizio (String servizioDaCercare) {
            if(servizioDaCercare.equalsIgnoreCase("parcheggio")) return parcheggio;
            if(servizioDaCercare.equalsIgnoreCase("piscina")) return piscina;
            if(servizioDaCercare.equalsIgnoreCase("palestra")) return palestra;
            if(servizioDaCercare.equalsIgnoreCase("WI-FI")) return wifi ;
            if(servizioDaCercare.equalsIgnoreCase("spa")) return spa ;
            return false;
        }







}

