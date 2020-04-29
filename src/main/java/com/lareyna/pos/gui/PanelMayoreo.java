package com.lareyna.pos.gui;

import java.awt.*;
import java.util.Optional;

import javax.swing.*;

import static com.lareyna.pos.uitl.Constantes.SIZE;

public class PanelMayoreo extends JPanel {

    public JButton boton1;
    public JButton boton2;
    public JButton boton3;
    public JButton boton4;
    private JTextField display2;
    private NumberField[] txf;

    public PanelMayoreo() {
        setLayout(new BorderLayout());
        JPanel p2 = new JPanel(new GridLayout(1, 2, 0, 0));
        JPanel p3 = new JPanel(new GridLayout(2, 2, 0, 0));
        JPanel p4 = new JPanel(new GridLayout(SIZE, 2, 2, 2));
        boton1 = new JButton("");
        boton2 = new JButton("EJECUTA");
        boton2.setMnemonic(107);
        boton3 = new JButton("IMPRIME");
        boton3.setMnemonic(106);
        boton4 = new JButton("BORRA");
        boton4.setMnemonic(109);
        JLabel[] label1 = new JLabel[SIZE];
        label1[0] = new JLabel("  BOLIS");
        label1[1] = new JLabel("  GALLETAS");
        label1[2] = new JLabel("  TROMPOS");
        label1[3] = new JLabel("  PALETONES");
        label1[4] = new JLabel("  CHICAS");
        label1[5] = new JLabel("  LECHE MED");
        label1[6] = new JLabel("  VASOS");
        label1[7] = new JLabel("  ESP DE FRUTAS");
        label1[8] = new JLabel("  ESP DE CREMA");
        label1[9] = new JLabel("  HELADOS");
        label1[10] = new JLabel("  NIEVES");
        label1[11] = new JLabel("  CHOCOLATE");
        label1[12] = new JLabel("  PROMOCION");
        for(int i = 0; i < SIZE; i++) {
            label1[i].setFont(new Font(label1[i].getFont().toString(), 0, 24));
            label1[i].setOpaque(true);
        }

        display2 = new JTextField();
        display2.setFont(new Font("Helv\351tica", Font.PLAIN, 52));
        display2.setForeground(Color.RED);
        txf = new NumberField[SIZE];
        for(int i = 0; i < SIZE; i++)
        {
            txf[i] = new NumberField(label1[i]);
            txf[i].setFont(new Font("Helv\351tica", 0, 24));
            txf[i].setForeground(Color.BLACK);
        }

        p3.add(boton1);
        p3.add(boton2);
        p3.add(boton3);
        p3.add(boton4);
        p2.add(p3);
        p2.add(display2);
        for(int i = 0; i < SIZE; i++)
        {
            p4.add(label1[i]);
            p4.add(txf[i]);
        }

        add(p4, "Center");
        add(p2, "South");
        setVisible(true);
    }

    public String getDisp2() {
        return display2.getText();
    }

    public void setDisp2(String s) {
        display2.setText(s);
    }

    public NumberField getTxf(int index) {
        return txf[index];
    }

    public Optional<int[]> getCantidades() {
        int[] qty = new int[SIZE];
        for (int i = 0; i < txf.length; i++){
            Optional<Integer> optInt = parseInt(txf[i]);
            if(!optInt.isPresent()){
                return Optional.empty();
            }
            qty[i] = optInt.get();
        }
        return Optional.of(qty);
    }

    private Optional<Integer> parseInt(NumberField txf){
        if(txf == null || txf.getText() == null || txf.getText().trim().isEmpty()){
            return Optional.of(0);
        }

        Optional<Integer> result;
        try {
            result = Optional.ofNullable(Integer.parseInt(txf.getText()));
        } catch (NumberFormatException nfe){
            txf.setErrorState();
            result = Optional.empty();
        }
        return result;
    }

    public void limpia()
    {
        display2.setText("");
        for(int i = 0; i < SIZE; i++)
            txf[i].setText("");

        setEditable(true);
        focusDisplay();
    }

    public void setEditable(boolean b) {
        if(b)
        {
            for(int i = 0; i < SIZE; i++)
                txf[i].setEditable(b);

            display2.setEditable(b);
        } else
        {
            display2.setEditable(b);
        }
    }

    public void focusDisplay()
    {
        txf[0].requestFocusInWindow();
    }

    public void setError(String message, int[] cantidades){
        display2.setText(message);
        for (int i = 0; i < SIZE; i++){
            if(cantidades[i] < 0 ){
                getTxf(i).setErrorState();
            }
        }
    }
}

