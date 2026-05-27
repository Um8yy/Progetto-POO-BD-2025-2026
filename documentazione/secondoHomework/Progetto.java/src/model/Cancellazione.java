package model;

/**
 * La classe si occuperà di gestire la cancellazione di una prenotazione da parte di un cliente.
 * In particolare, memorizza il motivo, la data e lo stato del rimborso, e calcola automaticamte
 * La percentuale di penale applicata in base alla politica di cancellazione selezionata.
 */
public class Cancellazione {
    private String motivo;
    private String data_cancellazione;
    private StatoRimborso stato_rimborso;
    private double percentuale_penale;
    private PoliticaCancellazione politica;

    /**
     * Instantiates a new Cancellazione.
     * All'atto della cancellazione, viene invocato il metodo privato per il calcolo automatico
     * della percentuale della penale in base alla politica inserita.
     *
     * @param motivo             il motivo della cancellazione
     * @param data_cancellazione la data in cui è stata effettuata la cancellazione
     * @param stato_rimborso     lo stato attuale del rimborso (es. Richiesto, approvato, rifiutato
     * @param politica           la politica di cancellazione da applicare a prenotazione
     */
    public Cancellazione(String motivo, String data_cancellazione, StatoRimborso stato_rimborso, PoliticaCancellazione politica) {
        this.motivo = motivo;
        this.data_cancellazione = data_cancellazione;
        this.stato_rimborso = stato_rimborso;
        this.politica = politica;

        this.calcolaPercentualePenale();
    }

    /**
     * Calcola la percentuale basandosi sulla politica di rimborso
    */
    private void calcolaPercentualePenale() {
        switch (this.politica) {
            case PoliticaCancellazione.FLESSIBILE:
                this.percentuale_penale = 0.0;
                break;
            case PoliticaCancellazione.SEMI_FLESSIBILE:
                this.percentuale_penale = 50.0;
                break;
            case PoliticaCancellazione.NON_FLESSIBILE:
                this.percentuale_penale = 100.0;
                break;
        }
    }


    /**
     * Gets percentuale penale.
     *
     * @return the percentuale penale
     */
    public double getPercentualePenale() { return percentuale_penale; }


    /**
     * Sets percentuale penale personalizzata.
     *
     * @param penale the penale
     */
    public void setPercentualePenalePersonalizzata(double penale) {
        if(this.politica == PoliticaCancellazione.NON_FLESSIBILE) {
            this.percentuale_penale = penale;
        }
    }
}