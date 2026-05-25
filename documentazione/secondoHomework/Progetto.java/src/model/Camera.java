package model;

public class Camera {


        private int numero;  // identifica la camera
        private double prezzo;
        private Tipo tipo;
        private boolean disponibile; // da aggiungere

        public Camera( int numero, double prezzo, Tipo tipo ){
            this.numero = numero; // identifica la camera
            this.prezzo = prezzo;
            this.tipo=tipo;
            disponibile=true;

        }




    public Tipo restituisciTipo () {return tipo;}
    public int restituisciNumeroCamera () {return numero;}
    public double restituisciPrezzo () {return prezzo;}
    public boolean restituisciDisponibilita () {return disponibile;}
    public void impostaDisponibilita(boolean stato) {disponibile = stato;}
    public String verificaDisponibilita (){
            if(disponibile == true){
                return "Disponibile";
            }
            else{
                return "Non Disponibile";
            }
    }

    public String mostraInfo (){
          return   "Numero camera: " + restituisciNumeroCamera() + ", Tipo: " + restituisciTipo()
            + " Disponibilità: " + verificaDisponibilita() + "\n"
                    + "Prezzo per notte: " + restituisciPrezzo() + " €.";
    }




}
