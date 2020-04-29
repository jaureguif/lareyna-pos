package com.lareyna.pos.gui;

import java.awt.Color;
import java.awt.TextField
;import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.JLabel;

public class NumberField extends TextField implements TextListener {

    private static Color DEFAULT_LABEL_BACKGROUND_COLOR = new JLabel().getBackground();
    private static Color HIGHLIGHT_COLOR = new Color(204, 204, 255);
    private static Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    private static Color ERROR_RED_COLOR = new Color(255, 164, 164);

    private boolean esUser, isErrorState;
    JLabel label = new JLabel();

    public NumberField()
    {
        esUser = true;
        isErrorState = false;
        addTextListener(this);
    }

    public NumberField(JLabel label)
    {
        super("");
        isErrorState = false;
        this.label = label;
        esUser = true;
        addTextListener(this);
    }

    public NumberField(String text)
    {
        super(text);
        esUser = true;
        isErrorState = false;
        addTextListener(this);
    }

    @Override
    public boolean hasFocus(){
        boolean hasFocus = super.hasFocus();
        if(hasFocus){
            setBackground(HIGHLIGHT_COLOR);
            label.setBackground(HIGHLIGHT_COLOR);
            isErrorState = false;
        } else if(!isErrorState){
            setBackground(DEFAULT_BACKGROUND_COLOR);
            label.setBackground(DEFAULT_LABEL_BACKGROUND_COLOR);
        }
        return hasFocus;
    }

    public void setEditable(boolean b)
    {
        super.setEditable(b);
        if(b)
            setBackground(DEFAULT_BACKGROUND_COLOR);
        else
            setBackground(new Color(204, 204, 204));
    }

    public void setErrorState(){
        setBackground(ERROR_RED_COLOR);
        label.setBackground(ERROR_RED_COLOR);
        isErrorState = true;
    }

    public void textValueChanged(TextEvent e)
    {
        if(esUser)
        {
            String s = getText();
            Stack stack = new Stack();
            Stack s2 = new Stack();
            boolean noPunto = true;
            for(int i = 0; i < s.length(); i++)
                try
                {
                    int c = Integer.parseInt(Character.valueOf(s.charAt(i)).toString());
                    stack.push(c);
                }
                catch(NumberFormatException nfe)
                {
                    if(s.charAt(i) == '.' && noPunto)
                    {
                        stack.push(".");
                        noPunto = false;
                    }
                }

            s = "";
            try
            {
                do
                    s2.push(stack.pop());
                while(true);
            }
            catch(EmptyStackException ese) { }
            try
            {
                do
                    s = s + s2.pop();
                while(true);
            }
            catch(EmptyStackException ese)
            {
                esUser = false;
            }
            setText(s);
            setSelectionStart(s.length());
        } else
        {
            esUser = true;
        }
    }
}
