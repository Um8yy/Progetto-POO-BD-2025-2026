package model;
import java.time.LocalDate;

/**
la classe si occuperà di gestire l'abbonamento che il cliente può sottoscrivere, in
 particolare potrà scegliere tra 2 tipi di piano , quello base dal costo di 0€ oppure premium che però
 permetterà di avere vantaggi in futuro nel caso di una prenotazione di una camera
 */
public class Abbonamento {
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private double importo;
    private Piano tipo; // enumerazione si compone facendod nome enumerazione + nome tipo

    /**
     * Instantiates a new Abbonamento.
     *
     * @param tipo the tipo
     */
    public Abbonamento (Piano tipo){


        this.dataInizio= LocalDate.now();
        this.dataFine=this.dataInizio.plusDays(365);

        this.tipo=tipo;

        if(tipo== Piano.PREMIUM){
            importo=100.0;
        }
        else{
            importo=0.0;
        }

    }

    /**
     * Controlla che l'abbonamento non sia scaduto
     *
     * @return  valore true se è scaduto , false se è ancora attivo
     */
    public boolean Scaduto (){
        return LocalDate.now().isAfter(dataFine);
    }

    /**
     * Gets data inizio.
     *
     * @return the data inizio
     */
    public LocalDate getDataInizio() {
        return dataInizio;
    }

    /**
     * Gets data fine.
     *
     * @return the data fine
     */
    public LocalDate getDataFine() {
        return dataFine;
    }

    /**
     * Gets importo.
     *
     * @return the importo
     */
    public double getImporto() {
        return importo;
    }

    /**
     * Gets tipo.
     *
     * @return the tipo
     */
    public Piano getTipo() {
        return tipo;
    }
}
