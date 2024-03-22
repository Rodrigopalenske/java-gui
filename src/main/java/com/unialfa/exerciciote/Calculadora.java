package com.unialfa.exerciciote;

import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame{
    private JTextField campoValor1;
    private JTextField campoValor2;
    private JButton botaoSomar;


    public Calculadora(){
        setTitle("Calculadora que só Soma");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        var painel = new JPanel(new GridBagLayout());
        var constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);

        var label1 = new JLabel("Label1:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painel.add(label1, constraints);

        campoValor1 = new JTextField(10);
        constraints.gridx = 0;
        constraints.gridy = 1;
        painel.add(campoValor1, constraints);


        var label2 = new JLabel("Label2:");
        constraints.gridx = 1;
        constraints.gridy = 0;
        painel.add(label2, constraints);

        campoValor2 = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painel.add(campoValor2, constraints);

        botaoSomar = new JButton("Somar");
        botaoSomar.addActionListener(e -> somar());
        constraints.gridx = 2;
        constraints.gridy = 0;
        painel.add(botaoSomar, constraints);

        add(painel);
        setLocationRelativeTo(null);
    }

    private void somar() {
        boolean campo1Valido;
        boolean campo2Valido;
        Integer valor1 = 0;
        Integer valor2 = 0;

        try{
            valor1 = verificarCampo1();
            campo1Valido = true;
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, "Label1 não for preenchido");
            campo1Valido = false;
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Label1 não é um número");
            campo1Valido = false;

        }

        try {
            valor2 = verificarCampo2();
            campo2Valido = true;
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, "Label2 não for preenchido");
            campo2Valido = false;
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Label2 não é um número");
            campo2Valido = false;
        }
        if (campo1Valido && campo2Valido){
            var total = valor1 + valor2;
            JOptionPane.showMessageDialog(this, "Resultado: " + total);
        }
    }

    private Integer verificarCampo1() throws NumberFormatException, NullPointerException{
        try{
            return Integer.parseInt(campoValor1.getText());
        } catch (Exception e){
            var valor1 = campoValor1.getText();
            if(valor1.isEmpty()){
                throw new NullPointerException();
            } else {
                throw new NumberFormatException();
            }
        }
    }
    private Integer verificarCampo2() throws NumberFormatException, NullPointerException{
        try{
            return Integer.parseInt(campoValor2.getText());
        } catch (Exception e){
            var valor2 = campoValor2.getText();
            if(valor2.isEmpty()){
                throw new NullPointerException();
            } else {
                throw new NumberFormatException();
            }
        }
    }
}
