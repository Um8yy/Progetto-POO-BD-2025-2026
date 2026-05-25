package model;

public class Recensione {


        private int stelle;
        private String testo;
        private boolean foto;

    public Recensione(int stelle, String testo, boolean foto){

        if (stelle >= 0 && stelle <= 5) {
            this.stelle = stelle;
        } else {
            this.stelle = 0;
        }

        this.testo = testo;
        this.foto = foto;
    }




        public String vediTesto (){

            if((testo!=null) && (!testo.isEmpty())){
                return testo;
            }
            else{
                return "Nessuna descrizione presente";
            }

        }


    public int getStelle() {
        return stelle;
    }

    public String getTesto() {
        return testo;
    }

    public boolean isFoto() {
        return foto;
    }

    public String infoRecensione (Cliente c , Struttura s){
            return   "Cliente: " + c.getNome() + " " + c.getCognome() + "\n"
                    + "Nome della struttura : " + s.restituisciNome () +
                     "Valutazione: " + getStelle() + " Descrizione: " + getTesto()
             + "Foto allegate: " + (isFoto() ? "Sì" : "No");


        }


}
