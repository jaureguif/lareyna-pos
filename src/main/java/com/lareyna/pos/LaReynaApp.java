package com.lareyna.pos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.swing.*;

import com.lareyna.pos.exception.CuentaException;
import com.lareyna.pos.gui.NumberField;
import com.lareyna.pos.gui.Panel1;
import com.lareyna.pos.gui.PanelMayoreo;

// Referenced classes of package LaReyna:
//            Fecha, Panel1, Panel2, Panel3,
//            Cuenta, JNumberField, Ticket, Nomina

public class LaReynaApp extends JFrame implements ActionListener, WindowListener {

    private JPanel p11;
    private JPanel p12;
    private JPanel p13;
    private JPanel p0;
    private JPanel pInicial;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JMenuBar bamenu;
    private JMenu bmenu;
    private JMenuItem itemSalir;
    private JMenuItem[] itemCuenta;
    private JMenuItem itemHelados;
    private JMenu menuNom;
    private JMenuItem itemNom;
    private double d;
    private final String VERSION = "Test1";
    private JMenuItem[] acelerador;
    private boolean estaDeudores;
    private boolean estaBodega;
    int estaPanelNumero;
    //Fecha f;
    private String saludo;
    private JLabel l;
    private Panel1 pan;
    private Panel1 panel2;
    private PanelMayoreo panel3;
    private Cuenta cuenta;
    //private Cuenta cuentaR;
    private String nombre;

    public LaReynaApp() {
        bamenu = new JMenuBar();
        bmenu = new JMenu("OPCIONES");
        itemSalir = new JMenuItem("SALIR");
        itemCuenta = new JMenuItem[3];
        itemHelados = new JMenuItem("HELADOS");
        menuNom = new JMenu("N\323MINA");
        itemNom = new JMenuItem("HACER N\323MINA");
        d = 0.0D;
        acelerador = new JMenuItem[4];
        estaDeudores = false;
        estaBodega = false;
        estaPanelNumero = 0;
        //f = new Fecha();
        //saludo = "BIENVENIDO   HOY ES:  " + f.toString(new Date()).toUpperCase();
        //l = new JLabel(saludo);
        l = new JLabel(VERSION);
        setIconImage((new ImageIcon("paleta4.png")).getImage());
        aceleradores();
        Set<AWTKeyStroke> forwardKeys = getFocusTraversalKeys(0);
        Set<AWTKeyStroke> newForwardKeys = new HashSet<AWTKeyStroke>(forwardKeys);
        newForwardKeys.add(KeyStroke.getKeyStroke(40, 0));
        setFocusTraversalKeys(0, newForwardKeys);
        Set<AWTKeyStroke> backwardKeys = getFocusTraversalKeys(1);
        Set<AWTKeyStroke> newBackwardKeys = new HashSet<AWTKeyStroke>(backwardKeys);
        newBackwardKeys.add(KeyStroke.getKeyStroke(38, 0));
        setFocusTraversalKeys(1, newBackwardKeys);
        forwardKeys = getFocusTraversalKeys(0);
        newForwardKeys = new HashSet<AWTKeyStroke>(forwardKeys);
        newForwardKeys.add(KeyStroke.getKeyStroke(34, 0));
        setFocusTraversalKeys(0, newForwardKeys);
        l.setFont(new Font(l.getFont().toString(), 0, 24));
        pan = new Panel1();
        //panel2 = new Panel2();
        panel2 = new Panel1();
        //panel3 = new Panel3();
        panel3 = new PanelMayoreo();
        pInicial = new JPanel();
        pInicial.add(l);
        p0 = new JPanel();
        p0.setLayout(new GridLayout(3, 1, 2, 2));
        p11 = new JPanel(new GridLayout(1, 2, 0, 0));
        p12 = new JPanel();
        p13 = new JPanel();
        cuenta = new Cuenta();
        //cuentaR = new Cuenta();
        b1 = new JButton("     HACER CUENTA        ");
        b2 = new JButton("     APUNTE MA\321ANA       ");
        b3 = new JButton("     CUENTA CLIENTE      ");
        b1.setActionCommand("cuenta1");
        b2.setActionCommand("cuenta2");
        b3.setActionCommand("creaArchivo");
        //itemSalir.addActionListener(new Object()     /* anonymous class not found */
        ///class _anm1 {
        //});
        itemCuenta[0] = new JMenuItem("HACER CUENTA");
        itemCuenta[1] = new JMenuItem("APUNTE MA\321ANA");
        itemCuenta[2] = new JMenuItem("CUENTA CLIENTE");
        itemCuenta[0].setAccelerator(KeyStroke.getKeyStroke(112, 0));
        itemCuenta[1].setAccelerator(KeyStroke.getKeyStroke(113, 0));
        itemCuenta[2].setAccelerator(KeyStroke.getKeyStroke(114, 0));
        bmenu.setMnemonic(79);
        menuNom.setMnemonic(78);
        bmenu.add(itemCuenta[0]);
        bmenu.add(itemCuenta[1]);
        bmenu.add(itemCuenta[2]);
        bmenu.add(itemHelados);
        bmenu.add(itemSalir);
        menuNom.add(itemNom);
        //itemCuenta[0].addActionListener(new Object()     /* anonymous class not found */
        //class _anm2 {
        //});
        //itemCuenta[1].addActionListener(new Object()     /* anonymous class not found */
        //class _anm3 {
        //});
        //itemCuenta[2].addActionListener(new Object()     /* anonymous class not found */
        //class _anm4 {
        //});
        //itemHelados.addActionListener(new Object()     /* anonymous class not found */
        //class _anm5 {
        //});
        bamenu.add(bmenu);
        bamenu.add(menuNom);
        pan.boton1.addActionListener(this);
        pan.boton2.addActionListener(this);
        pan.boton3.addActionListener(this);
        pan.boton4.addActionListener(this);
        pan.boton3.setActionCommand("IMPRIME1");
        pan.display1.addActionListener(this);
        //pan.display1.setActionCommand("CARGA");
        panel2.boton1.addActionListener(this);
        panel2.boton2.addActionListener(this);
        panel3.boton1.addActionListener(this);
        panel3.boton2.addActionListener(this);
        panel3.boton2.setActionCommand("EJECUTA2");
        panel3.boton3.addActionListener(this);
        panel3.boton3.setActionCommand("IMPRIME2");
        panel3.boton4.addActionListener(this);
    }

    public void GUI() {
        addWindowListener(this);
        setTitle("LA REYNA Test1");
        setSize(1024, 739);
        setResizable(false);
        setJMenuBar(bamenu);
        p0.add(b1);
        p0.add(b2);
        p0.add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        getContentPane().add(p0, "West");
        getContentPane().add(pInicial, "Center");
        setVisible(true);
    }

    public static void main(String args[])
        throws IOException {
        LaReynaApp mainFrame = new LaReynaApp();
        mainFrame.GUI();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("EJECUTA"))
            ejecuta(1);
        else if (e.getActionCommand().equals("EJECUTA2"))
            ejecuta(3);
        else if (e.getActionCommand().equals("BORRA"))
            borra();
        else if (e.getActionCommand().equals("CARGA"))
            carga();
        else if (e.getActionCommand().equals("GUARDA")) {
            //guarda();
        }
        else if (e.getActionCommand().equals("SALIR")) {
            System.out.println("Fin del programa...");
            System.exit(0);
        } else if (e.getActionCommand().equals("IMPRIME1"))
            imprime(1);
        else if (e.getActionCommand().equals("IMPRIME2"))
            imprime(3);
        else {
            cambiaPanel(e.getActionCommand());
        }
        //this.setVisible(true);
    }

    public void cambiaPanel(String st) {
        if (st.equals("cuenta1"))
            creaPanel1();
        else if (st.equals("cuenta2"))
            creaPanel2();
        else if (st.equals("creaArchivo"))
            creaPanel3();
        setVisible(true);
    }

    public void creaPanel1() {
        pan.limpia();
        if (estaPanelNumero != 1) {
            panel2.setVisible(false);
            panel3.setVisible(false);
            remove(getContentPane().getComponent(1));
            pan.setVisible(true);
            getContentPane().add(pan, "Center");
            setVisible(true);
            pan.display1.requestFocusInWindow();
            estaPanelNumero = 1;
        }
    }

    public void creaPanel2() {
        panel2.limpia();
        if (estaPanelNumero != 2) {
            pan.setVisible(false);
            panel3.setVisible(false);
            remove(getContentPane().getComponent(1));
            panel2.setVisible(true);
            getContentPane().add(panel2, "Center");
            setVisible(true);
            //panel2.focusDisplay();
            estaPanelNumero = 2;
        }
    }

    public void creaPanel3() {
        panel3.limpia();
        if (estaPanelNumero != 3) {
            panel2.setVisible(false);
            pan.setVisible(false);
            remove(getContentPane().getComponent(1));
            panel3.setVisible(true);
            getContentPane().add(panel3, "Center");
            setVisible(true);
            //panel3.focusDisplay();
            estaPanelNumero = 3;
        }
    }

    public void imprime(Cuenta c, String nom) {
        //Ticket ticket = new Ticket(c, nom);
        //ticket.imprime();
    }

    public void carga() {
        pan.setRegreso("");
        pan.setDisp2("");
        try {
            BufferedReader inFile = GetFileForReading();
            NumberField ida[] = new NumberField[13];
            for (int i = 0; i < 13; i++)
                ida[i] = new NumberField(inFile.readLine());

            String s = inFile.readLine();
            pan.setDisp2(s != null && !s.equals("0.0") ? s : "");
            inFile.close();
            pan.setIda(ida);
        } catch (IOException ioexception) {
        }
        pan.setEditable(true);
    }

    public void imprime(int i) {
        if(i == 1)
            imprime(cuenta, nombre);
        else
        if(i == 3)
            //imprime(cuentaR, nombre);
            imprime(cuenta, nombre);
    }

    public void ejecuta(int panel) {
        if (panel == 1) {
            String s = pan.getDisp2();
            double d;
            try {
                d = s.equals("") ? 0.0D : Double.parseDouble(s);
            } catch (NumberFormatException nfe) {
                d = 0.0D;
            }
            cuenta.setValues(pan.getIda(), pan.getRegreso(), d);
            pan.setDisp2("       //TODO " + NumberFormat.getCurrencyInstance().format(""));
            nombre = pan.getDisp1();
        } else if (panel == 3) {
            String s = panel3.getDisp2();
            double extra;
            try {
                extra = s.equals("") ? 0.0D : Double.parseDouble(s);
            } catch (NumberFormatException nfe) {
                extra = 0.0D;
            }
            String result = "";
            Optional<int[]> cantidadesOpt = panel3.getCantidades();
            if(!cantidadesOpt.isPresent()){
                result = "    Error    ";
            } else {
                try {
                    BigDecimal total = Cuenta.calculaResultado(cantidadesOpt.get(), BigDecimal.valueOf(extra));
                    result = "        " + NumberFormat.getCurrencyInstance().format(total);
                }
                catch(CuentaException cex){
                    result = cex.getMessage();
                    panel3.setError(cex.getMessage(), cex.getCantidades());
                }
            }
            panel3.setDisp2(result);
            nombre = "MOSTRADOR";
        }
    }

    public void borra() {
        d = 0.0D;
        pan.limpia();
        panel2.limpia();
        panel3.limpia();
        setVisible(true);
    }

    public void aceleradores() {
        acelerador[0] = new JMenuItem();
        acelerador[0].addActionListener(new ActionListener() {

                                            public void actionPerformed(ActionEvent e) {
                                                carga();
                                            }

                                        }
        );
        acelerador[1] = new JMenuItem();
        acelerador[1].addActionListener(new ActionListener() {

                                            public void actionPerformed(ActionEvent e) {
                                                if (estaPanelNumero == 2) {
                                                    //guarda();
                                                }
                                                else if (estaPanelNumero == 1 || estaPanelNumero == 3) {
                                                    ejecuta(estaPanelNumero);
                                                }
                                            }

                                        }
        );
        acelerador[2] = new JMenuItem();
        acelerador[2].addActionListener(new ActionListener() {

                                            public void actionPerformed(ActionEvent e) {
                                                imprime(estaPanelNumero);
                                            }

                                        }
        );
        acelerador[3] = new JMenuItem();
        acelerador[0].setAccelerator(KeyStroke.getKeyStroke(120, 0));
        acelerador[1].setAccelerator(KeyStroke.getKeyStroke(107, 0));
        acelerador[2].setAccelerator(KeyStroke.getKeyStroke(106, 0));
        acelerador[3].setAccelerator(KeyStroke.getKeyStroke(109, 0));
    }

    private BufferedReader GetFileForReading()
        throws IOException {
        try {
            new BufferedReader(new FileReader("./Archivos/" + pan.getDisp1() + ".lry"));
        } catch (FileNotFoundException fnfe) {
            pan.setDisp2("ERROR AL LEER");
        }
        return new BufferedReader(new FileReader("./Archivos/" + pan.getDisp1() + ".lry"));
    }

    public void windowOpened(WindowEvent windowevent) {
    }

    public void windowClosing(WindowEvent e) {
        System.out.println("Fin del programa...");
        System.exit(0);
    }

    public void windowClosed(WindowEvent windowevent) {
    }

    public void windowIconified(WindowEvent windowevent) {
    }

    public void windowDeiconified(WindowEvent windowevent) {
    }

    public void windowActivated(WindowEvent windowevent) {
    }

    public void windowDeactivated(WindowEvent windowevent) {
    }
}