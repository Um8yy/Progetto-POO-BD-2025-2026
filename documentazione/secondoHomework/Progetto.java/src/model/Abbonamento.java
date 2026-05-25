package model;
import java.time.LocalDate;

public class Abbonamento {
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private double importo;
    private Piano tipo; // enumerazione si compone facendod nome enumerazione + nome tipo

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

    public boolean Scaduto (){
        return LocalDate.now().isAfter(dataFine);
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public double getImporto() {
        return importo;
    }

    public Piano getTipo() {
        return tipo;
    }
}
