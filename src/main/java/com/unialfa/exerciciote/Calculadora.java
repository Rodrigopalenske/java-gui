package com.unialfa.exerciciote;

import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame{
    public static final String CAMPO_1 = "Campo 1";
    public static final String CAMPO_2 = "Campo 2";
    private JTextField campoValor1;
    private JTextField campoValor2;
    private JButton botaoSomar;
    private Boolean falha = Boolean.FALSE;

    public Calculadora(){
        setTitle("Calculadora que só Soma");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        var painel = new JPanel(new GridBagLayout());
        var constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);

        var labelValor1 = new JLabel(CAMPO_1);
        constraints.gridx = 0;
        constraints.gridy = 0;
        painel.add(labelValor1, constraints);

        var labelValor2 = new JLabel(CAMPO_2);
        constraints.gridx = 1;
        constraints.gridy = 0;
        painel.add(labelValor2, constraints);

        campoValor1 = new JTextField(10);
        constraints.gridx = 0;
        constraints.gridy = 1;
        painel.add(campoValor1, constraints);

        campoValor2 = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painel.add(campoValor2, constraints);

        botaoSomar = new JButton("Somar");
        botaoSomar.addActionListener(e -> somar());
        constraints.gridx = 2;
        constraints.gridy = 1;
        painel.add(botaoSomar, constraints);

        add(painel);
        setLocationRelativeTo(null);
    }

    private Integer converter(String valorStr, String campo) {
        try {
            if (valorStr.isEmpty()) throw new CalculadoraException("O valor do " + campo + " não pode ser vazio");
            if (valorStr.isBlank()) throw new CalculadoraException("O valor do %s não pode ser espaços".formatted(campo));
            return Integer.parseInt(valorStr);
        } catch (NumberFormatException n){
            this.falha = Boolean.TRUE;
            JOptionPane.showMessageDialog(this, "O valor do %s não é válido, é necessário ser um número".formatted(campo));
            return 0;
        } catch (CalculadoraException e) {
            this.falha = e.isFalha();
            JOptionPane.showMessageDialog(this, e.getMessage());
            return 0;
        }
    }

    private void somar() {
        var valor1 = converter(campoValor1.getText(), CAMPO_1);
        var valor2 = converter(campoValor2.getText(), CAMPO_2);
        if (this.falha){
            this.falha = Boolean.FALSE;
            return;
        }
        Integer total = valor1 + valor2;
        JOptionPane.showMessageDialog(this, "Resultado: " + total);

    }
    private void salvar(String valor){

    }




}
