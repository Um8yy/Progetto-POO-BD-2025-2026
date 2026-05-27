package gui;

import Controller.Controller;
import model.Piano;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("unused")
public class Interfaccia {
    private JPanel mainPanel;
    private JComboBox<String> comboBox1;
    private JButton iscrivitiButton;
    private JButton registraLaTuaStrutturaButton;
    private JButton sottoscriviAbbonamentoButton;
    private JLabel testo;
    private JLabel logo;
    private JLabel RoomRadar;

    private Controller controller;

    public Interfaccia(Controller controller) {

        this.controller = controller;

        java.net.URL imgUrl = getClass().getResource("/logo.png");

        if (imgUrl != null) {
            logo.setIcon(new ImageIcon(imgUrl));
            testo.setHorizontalAlignment(SwingConstants.RIGHT);
            logo.setText("");
            logo.setAlignmentX(Component.RIGHT_ALIGNMENT);
        } else {
            System.out.println(" Errore: logo.png non trovato!");
        }

        comboBox1.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
        mainPanel.setOpaque(false);


        comboBox1.addActionListener(e -> {
            String selezione = (String) comboBox1.getSelectedItem();

            if (selezione != null && (selezione.equalsIgnoreCase("Area Cliente") || selezione.equalsIgnoreCase("Area Host"))) {

                String email = JOptionPane.showInputDialog(mainPanel, "LOGIN " + selezione + "\nInserisci la tua email:");
                String password = JOptionPane.showInputDialog(mainPanel, "Inserisci la tua password:");

                if (email != null && password != null && !email.isEmpty() && !password.isEmpty()) {
                    boolean loginRiuscito = controller.login(email, password);

                    if (loginRiuscito) {
                        JOptionPane.showMessageDialog(mainPanel, "Login effettuato con successo come: " + selezione);
                    } else {
                        JOptionPane.showMessageDialog(mainPanel, "Credenziali errate!", "Errore Login", JOptionPane.ERROR_MESSAGE);
                    }
                }

                comboBox1.setSelectedIndex(-1);
            }
        });


        iscrivitiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eseguiRegistrazione();
            }
        });
        sottoscriviAbbonamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opzioni = {"Gratuito (0 €) ", "Premium (45 € anno)"};
                int scelta = JOptionPane.showOptionDialog(mainPanel,
                        "Che piano di abbonamento si desidera effettuare?",
                        "Scegli il piano di abbonamento",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opzioni,
                        opzioni[0]);
                if (scelta == JOptionPane.CLOSED_OPTION) {
                    return;
                }
                Piano pianoScelto;
                if (scelta == 0) {
                    pianoScelto = Piano.GRATUITO;
                } else {
                    pianoScelto = Piano.PREMIUM;
                }

                boolean successo = controller.sottoscriviAbbonamento(pianoScelto);
                if (successo) {
                    JOptionPane.showMessageDialog(mainPanel, "Abbonamento piano" + pianoScelto + " attivato con successo");
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "non è stato possibile sottoscrivere l'abbonamento");
                }
            }

        });
        registraLaTuaStrutturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!controller.isUtenteLoggato()) {
                    JOptionPane.showMessageDialog(mainPanel, "Impossibile registrare la struttura,  \n devi fare prima l'accesso come host ");
                    return;
                }
                interfacciaHost schermataHost = new interfacciaHost(controller);
                schermataHost.setVisible(true);
            }
        });
    }

    private void eseguiRegistrazione() {

        Object[] opzioni = {"Cliente", "Host"};
        int scelta = JOptionPane.showOptionDialog(mainPanel,
                "Come desideri registrarti?",
                "Scegli il tipo di account",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opzioni,
                opzioni[0]);

        if (scelta == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String tipoScelto = (scelta == 0) ? "Cliente" : "Host";


        String nome = JOptionPane.showInputDialog(mainPanel, "Registrazione " + tipoScelto + "\nInserisci il Nome:");
        String cognome = JOptionPane.showInputDialog(mainPanel, "Inserisci il Cognome:");
        String email = JOptionPane.showInputDialog(mainPanel, "Inserisci l'Email:");
        String password = JOptionPane.showInputDialog(mainPanel, "Inserisci la Password:");

        if (nome == null || email == null || email.trim().isEmpty()) {
            return;
        }

        String telefono = "";
        String indirizzo = "";
        String iban = "";
        boolean registrazioneRiuscita = false;


        if (tipoScelto.equals("Cliente")) {
            telefono = JOptionPane.showInputDialog(mainPanel, "Inserisci il Telefono:");
            indirizzo = JOptionPane.showInputDialog(mainPanel, "Inserisci l'Indirizzo:");

            registrazioneRiuscita = controller.registrazione("Cliente", nome, cognome, email, password, telefono, indirizzo, iban);

        } else if (tipoScelto.equals("Host")) {
            iban = JOptionPane.showInputDialog(mainPanel, "Inserisci l'IBAN:");

            registrazioneRiuscita = controller.registrazione("Host", nome, cognome, email, password, telefono, indirizzo, iban);
        }


        if (registrazioneRiuscita) {
            JOptionPane.showMessageDialog(mainPanel, "Registrazione completata con successo! Ora puoi accedere dall'Area " + tipoScelto + ".");
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Errore: impossibile registrarsi. L'email potrebbe essere già in uso.", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Interfaccia");
        Controller controller = new Controller();
        Interfaccia gui = new Interfaccia(controller);

        JPanel sfondoSfumato = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                Color coloreAlto = new Color(0, 102, 204);
                Color coloreBasso = Color.WHITE;

                GradientPaint gp = new GradientPaint(0, 0, coloreAlto, 0, getHeight(), coloreBasso);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        sfondoSfumato.add(gui.mainPanel, BorderLayout.CENTER);

        frame.setContentPane(sfondoSfumato);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}