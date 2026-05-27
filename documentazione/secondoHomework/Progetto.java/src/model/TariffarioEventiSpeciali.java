package model;


/**
 * La classe si occuperà di gestire le tariffe speciali applicate durante gli eventi
 * permette di definire una finestra temporale associata a un evento specifico
 * e di applicare un moltiplicatore al prezzo delle camere
 */
public class TariffarioEventiSpeciali {

    private String data_inizio;
    private String data_fine;
    private String nome_evento;
    private double moltiplicatore_prezzo;

    /**
     * Instantiates a new Tariffario eventi speciali.
     *
     * @param data_inizio            data inizio
     * @param data_fine              data fine
     * @param nome_evento            nome evento
     * @param moltiplicatore_prezzo  moltiplicatore prezzo
     */
    public TariffarioEventiSpeciali(String data_inizio, String data_fine, String nome_evento, double moltiplicatore_prezzo) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.nome_evento = nome_evento;
        this.moltiplicatore_prezzo = moltiplicatore_prezzo;
    }

    /**
     * Gets data inizio.
     *
     * @return the data inizio
     */
    public String getData_inizio() { return data_inizio; }

    /**
     * Sets data inizio.
     *
     * @param data_inizio the data inizio
     */
    public void setData_inizio(String data_inizio) { this.data_inizio = data_inizio; }

    /**
     * Gets data fine.
     *
     * @return the data fine
     */
    public String getData_fine() { return data_fine; }

    /**
     * Sets data fine.
     *
     * @param data_fine the data fine
     */
    public void setData_fine(String data_fine) { this.data_fine = data_fine; }

    /**
     * Gets nome evento.
     *
     * @return the nome evento
     */
    public String getNome_evento() { return nome_evento; }

    /**
     * Sets nome evento.
     *
     * @param nome_evento the nome evento
     */
    public void setNome_evento(String nome_evento) { this.nome_evento = nome_evento; }

    /**
     * Gets moltiplicatore prezzo.
     *
     * @return the moltiplicatore prezzo
     */
    public double getMoltiplicatore_prezzo() { return moltiplicatore_prezzo; }

    /**
     * Sets moltiplicatore prezzo.
     *
     * @param moltiplicatore_prezzo the moltiplicatore prezzo
     */
    public void setMoltiplicatore_prezzo(double moltiplicatore_prezzo) { this.moltiplicatore_prezzo = moltiplicatore_prezzo; }

    /**
     * Restituisce una presentazione testuale del tariffario speciale
     * evidenziando nome evento, intervallo di date e il valore del moltiplicatore
     * @return
     */
    @Override
    public String toString() {
        return "Evento Speciale: " + nome_evento + " (dal " + data_inizio + " al " + data_fine + "). " +
                "Moltiplicatore prezzo: " + moltiplicatore_prezzo + "x";
    }
}
