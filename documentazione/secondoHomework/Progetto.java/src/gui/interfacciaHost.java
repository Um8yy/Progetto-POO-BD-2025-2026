package gui;

import Controller.Controller;
import model.Struttura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfacciaHost extends JFrame {
    private JPanel panelHost;
    private JButton registraStrutturaButton;
    private JButton cercaStrutturaButton;
    private JComboBox comboBox1;
    private JButton eliminaStrutturaButton;
    private JLabel benvenutoLabel;
    private JList listaStrutture;
    private JScrollPane scrollPaneStrutture;
    private DefaultListModel listModel;

    private Controller controller;
    //aggiungiamo il controller al costruttore
    public interfacciaHost(Controller controller) {
        this.controller = controller;

        setContentPane(panelHost);
        setTitle("Area Host - Gestione Struttura");
        setSize(750,450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //chiude solo la finestra host registra strutture
        setLocationRelativeTo(null); //centra la finestra

        listModel = new DefaultListModel<>();
        listaStrutture = new JList(listModel);

        scrollPaneStrutture.setViewportView(listaStrutture);

        aggiornaVisualizzazioneLista();


        String nomeUtente = controller.getNomeLoggato();
        if(!nomeUtente.isEmpty()){
            benvenutoLabel.setText("Benvenuto: "+ nomeUtente);
        } else {
            benvenutoLabel.setText("Benvenuto");
        }
        benvenutoLabel.setForeground(Color.WHITE);

        benvenutoLabel.setFont(new Font("Avenir Text", Font.BOLD, 16));

        registraStrutturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog(panelHost, "Inseriscic il nome della struttura ");
                if(nome==null || nome.trim().isEmpty()) return ;
                String indirizzo = JOptionPane.showInputDialog(panelHost, "Inserisci indirizzo ");
                if(indirizzo==null || indirizzo.trim().isEmpty()) return ;

// trim --> Se un utente distratto per sbaglio preme la barra spaziatrice prima e dopo il suo nome, scrivendo "   Mario   ", il comando trim() prenderà quel testo e lo trasformerà magicamente in "Mario".
// empty se vuota restituisce true ovvero ha 0 caratteri
                String categoriaString = JOptionPane.showInputDialog(panelHost, " Inserisci il numero di stelle (1-5) ");
                if(categoriaString==null || categoriaString.trim().isEmpty()) return ;

                String camereString = JOptionPane.showInputDialog(panelHost, " Inserisci il numero di camere");
                if(camereString==null || camereString.trim().isEmpty()) return ;

                int categoriaScelta, numeroCamere;
                try {
                    categoriaScelta=Integer.parseInt(categoriaString); // parseInt capisce che il contenuto della stinga e traduce ( e non fa cast) in questo caso ad intero
                    numeroCamere = Integer.parseInt(camereString);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panelHost,"Errore, inserire il numero di stelle corretto (1-5) e quantità camere");
                    return;
                }

                boolean successo = controller.registraStruttura(nome,indirizzo,categoriaScelta, numeroCamere);
                if(successo){
                    JOptionPane.showMessageDialog(panelHost, "La struttura " + nome  +" è stata registrata con successo");
                    aggiornaVisualizzazioneLista();
                }
                else{
                    JOptionPane.showMessageDialog(panelHost, "errore nella registrazione della struttura " + nome + " .");

                }


            }
        });
    }
    private void aggiornaVisualizzazioneLista(){
        listModel.clear();
        for (Struttura s: controller.getStrutturaHostLoggato()){
            String rigaStruttura = String.format(" 🏨 %s  |  📍 %s  |  ⭐ %d Stelle  |  🛏 Camere Totali: %d",
                    s.restituisciNome(),
                    s.restituisciIndirizzo(),
                    s.restituisciCategoria(),
                    s.restituisciNumeroCamere());

            listModel.addElement(rigaStruttura);
        }
    }




}