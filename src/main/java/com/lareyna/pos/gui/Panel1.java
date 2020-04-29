package com.lareyna.pos.gui;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class Panel1 extends JPanel {

    public JButton boton1;
    public JButton boton2;
    public JButton boton3;
    public JButton boton4;
    public NumberField display1;
    private JLabel[] label3;
    private NumberField[] txf;
    private NumberField display2;
    private final int SIZE = 13;

    public Panel1() {
        setLayout(new BorderLayout());
        Set<AWTKeyStroke> forwardKeys = getFocusTraversalKeys(0);
        Set<AWTKeyStroke> newForwardKeys = new HashSet<AWTKeyStroke>(forwardKeys);
        newForwardKeys.add(KeyStroke.getKeyStroke(40, 0));
        setFocusTraversalKeys(0, newForwardKeys);
        Set<AWTKeyStroke> backwardKeys = getFocusTraversalKeys(1);
        Set<AWTKeyStroke> newBackwardKeys = new HashSet<AWTKeyStroke>(backwardKeys);
        newBackwardKeys.add(KeyStroke.getKeyStroke(38, 0));
        setFocusTraversalKeys(1, newBackwardKeys);
        JPanel p1 = new JPanel(new GridLayout(1, 2, 0, 0));
        JPanel p2 = new JPanel(new GridLayout(1, 2, 0, 0));
        JPanel p3 = new JPanel(new GridLayout(2, 2, 0, 0));
        JPanel p4 = new JPanel(new GridLayout(SIZE, 4, 2, 2));
        boton1 = new JButton("CARGA");
        boton1.setMnemonic(111);
        boton2 = new JButton("EJECUTA");
        boton2.setMnemonic(107);
        boton3 = new JButton("IMPRIME");
        boton3.setMnemonic(106);
        boton4 = new JButton("BORRA");
        boton4.setMnemonic(109);
        JLabel label = new JLabel("                       ESCRIBE EL NOMBRE:");
        JLabel[] label1 = new JLabel[SIZE];
        JLabel[] label2 = new JLabel[SIZE];
        label3 = new JLabel[SIZE];
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
        label2[0] = new JLabel("  BOLIS");
        label2[1] = new JLabel("  GALLETAS");
        label2[2] = new JLabel("  TROMPOS");
        label2[3] = new JLabel("  PALETONES");
        label2[4] = new JLabel("  CHICAS");
        label2[5] = new JLabel("  LECHE MED");
        label2[6] = new JLabel("  VASOS");
        label2[7] = new JLabel("  ESP DE FRUTAS");
        label2[8] = new JLabel("  ESP DE CREMA");
        label2[9] = new JLabel("  HELADOS");
        label2[10] = new JLabel("  NIEVES");
        label2[11] = new JLabel("  CHOCOLATE");
        label2[12] = new JLabel("  PROMOCION");
        for (int i = 0; i < label1.length; i++) {
            label1[i].setFont(new Font(label1[i].getFont().toString(), Font.PLAIN, 24));
            label2[i].setFont(new Font(label2[i].getFont().toString(), Font.PLAIN, 24));
        }

        for (int i = 0; i < label3.length; i++) {
            label3[i] = new JLabel("");
            label3[i].setFont(new Font("Helv\351tica", Font.PLAIN, 24));
            label3[i].setForeground(Color.black);
        }

        display1 = new NumberField();
        display2 = new NumberField();
        display1.setFont(new Font("Helv\351tica", Font.PLAIN, 30));
        display1.setForeground(Color.blue);
        display2.setFont(new Font("Helv\351tica", Font.PLAIN, 50));
        display2.setForeground(Color.red);
        display2.setEditable(false);
        txf = new NumberField[SIZE];
        for (int i = 0; i < SIZE; i++) {
            txf[i] = new NumberField("");
            txf[i].setFont(new Font("Helv\351tica", Font.PLAIN, 24));
            txf[i].setForeground(Color.black);
            txf[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        setEditable(false);
        limpia();
        label.setFont(new Font(label.getFont().toString(), Font.PLAIN, 19));
        p1.add(label);
        p1.add(display1);
        p3.add(boton1);
        p3.add(boton2);
        p3.add(boton3);
        p3.add(boton4);
        p2.add(p3);
        p2.add(display2);
        for (int i = 0; i < SIZE; i++) {
            p4.add(label1[i]);
            p4.add(label3[i]);
            p4.add(label2[i]);
            p4.add(txf[i]);
        }

        add(p1, "North");
        add(p4, "Center");
        add(p2, "South");
        display1.requestFocusInWindow();
        setVisible(true);
        display1.requestFocusInWindow();
    }

    public String getDisp1() {
        return display1.getText();
    }

    public String getDisp2() {
        return display2.getText();
    }

    public void setDisp1(String s) {
        display1.setText(s);
    }

    public void setDisp2(String s) {
        display2.setText(s);
    }

    public void setIda(NumberField[] ida) {
        for (int i = 0; i < SIZE; i++)
            label3[i].setText("         " + ida[i].getText());

    }

    public void setRegreso(NumberField[] reg) {
        for (int i = 0; i < SIZE; i++)
            txf[i].setText(reg[i].getText());

    }

    public void setRegreso(String s) {
        for (int i = 0; i < SIZE; i++)
            txf[i].setText(s);

    }

    public NumberField[] getIda() {
        NumberField[] text = new NumberField[SIZE];
        for (int i = 0; i < SIZE; i++)
            text[i] = new NumberField(label3[i].getText());

        return text;
    }

    public NumberField[] getRegreso() {
        return txf;
    }

    public void limpia() {
        display1.requestFocusInWindow();
        setVisible(false);
        setEditable(true);
        display1.setText("");
        display2.setText("");
        for (int i = 0; i < SIZE; i++) {
            txf[i].setText("");
            label3[i].setText("");
        }

        setEditable(false);
        setVisible(true);
        display1.requestFocusInWindow();
    }

    public void setEditable(boolean b) {
        for (int i = 0; i < SIZE; i++)
            txf[i].setEditable(b);

        display2.setEditable(b);
    }
}
