package model;

import java.util.ArrayList;
public class Struttura {

        private String indirizzo;
        private String nome;
        private int categoria;
        private ArrayList <Camera> elencoCamere;
        private ArrayList <Servizio>  serviziOfferti;


        public Struttura(String nome, String indirizzo, int categoria ){
        this.nome= nome;
        this.indirizzo=indirizzo;
        this.categoria=categoria;

        elencoCamere = new ArrayList<>();
        serviziOfferti = new ArrayList<>();

        }

      public void aggiungiCamera (Camera c){elencoCamere.add(c);}
      public void aggiungiServizio (Servizio s){ serviziOfferti.add(s);}

        //elimina camera
    public void eliminaCamera (int numeroCameraDaEliminare){
            for (int i = 0 ; i < elencoCamere.size(); i++){
                if (elencoCamere.get(i).restituisciNumeroCamera() ==numeroCameraDaEliminare ){
                   elencoCamere.remove(i);
                }
            }
    }
         // cerca camera
    public boolean cercaCamera ( int numeroCameraDaCercare){
            boolean trovato;
            for (int i = 0 ; i < elencoCamere.size(); i++){
                if(elencoCamere.get(i).restituisciNumeroCamera() == numeroCameraDaCercare){
                    trovato= true;
                    return trovato;
                }
            }
            trovato= false;
            return trovato;
    }

    public boolean PresenzaServizio(String nomeDaCercare) {
        for (Servizio s : serviziOfferti) {
            if (s.verificaServizio(nomeDaCercare)) {
                return true;
            }
        }
        return false;
    }





        public String restituisciNome () {return nome;}
        public String restituisciIndirizzo () { return indirizzo;}
        public int restituisciCategoria () {return categoria; }

    public String mostraServizio (){
            String risultato = "";
           if (serviziOfferti.isEmpty()){
               risultato +="Nessun servizio disponibile";
           }
           else{
              for (Servizio serv : serviziOfferti){
                  risultato += "Servizi: " +  serv.elencoServiziAttivi();
                  risultato += "Tipo di pensioene: " + serv.servizioSoloColazione();
              }

           }
           return risultato;
    }

    public String specificaTipoCamera(int numeroCameraDaCercare) {
        if (cercaCamera(numeroCameraDaCercare) == true) {
            for (Camera c : elencoCamere) {
                if (c.restituisciNumeroCamera() == numeroCameraDaCercare) {
                    return "La camera selezionata è una "  + c.restituisciTipo();
                }
            }
        }
       return  "Camera non trovata.";

    }



}
