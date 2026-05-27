package model;


/**
 * La classe si occupera di gestire la prenotazione effettuata dal cliente per una struttura.
 * Permette di monitorare il periodo del soggiorno, il numero di ospiti, lo stato dell'attività,
 * i dettagli del pagamento associato e l'eventuale cancellazione
 */
public class Prenotazione {


        private String data_inizio;
        private String data_fine;
        private boolean stato;
        private int quant_persone;

         private Pagamento pagamento;
         private Cancellazione cancellazione; // Può essere null finché non viene cancellata
         private Cliente cliente;             // Chi ha effettuato la prenotazione
          private Struttura struttura;         // A quale struttura è inviata

    /**
     * Instantiates a new Prenotazione.
     *
     * @param data_inizio    data inizio
     * @param data_fine      data fine
     * @param stato          stato
     * @param quant_persone  quant persone
     * @param pagamento      pagamento
     * @param cliente        cliente
     * @param struttura      struttura
     */
    public Prenotazione(String data_inizio, String data_fine, boolean stato, int quant_persone,
        Pagamento pagamento , Cliente cliente, Struttura struttura){
            this.data_inizio = data_inizio;
            this.data_fine = data_fine;
            this.stato = stato;
            this.quant_persone = quant_persone;
            this.pagamento = pagamento;
            this.cancellazione = null;
            this.cliente=cliente;
            this.struttura=struttura;

        }


    /**
     * Gets data inizio.
     *
     * @return the data inizio
     */
    public String getData_inizio() { return data_inizio;}

    /**
     * Sets data inizio.
     *
     * @param data_inizio the data inizio
     */
    public void setDataInizio(String data_inizio) { this.data_inizio = data_inizio; }

    /**
     * Gets data fine.
     *
     * @return the data fine
     */
    public String getData_fine() {return data_fine;}

    /**
     * Sets data fine.
     *
     * @param data_fine the data fine
     */
    public void setData_fine(String data_fine) { this.data_fine = data_fine; }

    /**
     * Gets stato.
     *
     * @return the stato
     */
    public boolean getStato() { return stato;}

    /**
     * Sets stato.
     *
     * @param stato the stato
     */
    public void setStato(boolean stato) { this.stato = stato; }

    /**
     * Gets quant persone.
     *
     * @return the quant persone
     */
    public int getQuant_persone() { return quant_persone;}

    /**
     * Sets quant persone.
     *
     * @param quant_persone the quant persone
     */
    public void setQuant_persone(int quant_persone) { this.quant_persone = quant_persone; }

    /**
     * Gets pagamento.
     *
     * @return the pagamento
     */
    public Pagamento getPagamento() { return pagamento;}

    /**
     * Sets pagamento.
     *
     * @param pagamento the pagamento
     */
    public void setPagamento(Pagamento pagamento) { this.pagamento = pagamento; }

    /**
     * Gets cancellazione.
     *
     * @return the cancellazione
     */
    public Cancellazione getCancellazione() {
        return cancellazione;
    }

    /**
     * Gets cliente.
     *
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Gets struttura.
     *
     * @return the struttura
     */
    public Struttura getStruttura() {
        return struttura;
    }

    /**
     * Sets cancellazione.
     *
     * @param cancellazione the cancellazione
     */
    public void setCancellazione(Cancellazione cancellazione) {
        this.cancellazione = cancellazione;
    }

    /**
     * Sets cliente.
     *
     * @param cliente the cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Sets struttura.
     *
     * @param struttura the struttura
     */
    public void setStruttura(Struttura struttura) {
        this.struttura = struttura;
    }

    /**
     * Restituisce una presentazione testuale dello stato della prenotazione,
     * includendo date, numero persone, dicitura attiva o cancellata.
     * @return
     */

    @Override
    public String toString() {
        return "Prenotazione dal " + data_inizio + " al " + data_fine +
                " per " + quant_persone + " persone. " +
                (stato ? "ATTIVA" : "CANCELLATA");
    }


    /**
     * Annulla la prenotazione corrente cambiandone lo stato logico e memorizzando
     * i dettagli relativi all'annullamento
     *
     * questo metodo imposta la variabile booleana stato a false segnalando che non è più attiva la prenotazione
     * @param c the c
     */
    public void annullaPrenotazione(Cancellazione c) {
        this.stato = false; // La prenotazione non è più attiva
        this.cancellazione = c; // Assegno i dettagli della cancellazione
    }



}
