package com.academia; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.google.gson.Gson;

public class CadastroAluno {

    public static void main(String[] args) {
        // Criação da janela principal
        JFrame frame = new JFrame("Cadastro de Aluno - Academia");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 2));

        // Criação dos campos
        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();

        JLabel idadeLabel = new JLabel("Idade:");
        JTextField idadeField = new JTextField();

        JLabel pesoLabel = new JLabel("Peso (kg):");
        JTextField pesoField = new JTextField();

        JLabel alturaLabel = new JLabel("Altura (m):");
        JTextField alturaField = new JTextField();

        JLabel objetivoLabel = new JLabel("Objetivo:");
        JTextField objetivoField = new JTextField();

        // Botões
        JButton incluirButton = new JButton("Incluir");
        JButton limparButton = new JButton("Limpar");
        JButton apresentarButton = new JButton("Apresentar Dados");
        JButton sairButton = new JButton("Sair");

        // Adiciona os componentes à janela
        frame.add(nomeLabel);
        frame.add(nomeField);
        frame.add(idadeLabel);
        frame.add(idadeField);
        frame.add(pesoLabel);
        frame.add(pesoField);
        frame.add(alturaLabel);
        frame.add(alturaField);
        frame.add(objetivoLabel);
        frame.add(objetivoField);
        frame.add(incluirButton);
        frame.add(limparButton);
        frame.add(apresentarButton);
        frame.add(sairButton);

        // Ação do botão "Incluir"
        incluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simula a inclusão no banco de dados (apenas mensagem por enquanto)
                JOptionPane.showMessageDialog(frame, "Dados incluídos no banco de dados.");
            }
        });

        // Ação do botão "Limpar"
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeField.setText("");
                idadeField.setText("");
                pesoField.setText("");
                alturaField.setText("");
                objetivoField.setText("");
            }
        });

        // Ação do botão "Apresentar Dados"
        apresentarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coleta os dados preenchidos
                String nome = nomeField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                float peso = Float.parseFloat(pesoField.getText());
                float altura = Float.parseFloat(alturaField.getText());
                String objetivo = objetivoField.getText();

                // Converte os dados para JSON
                Gson gson = new Gson();
                Aluno aluno = new Aluno(nome, idade, peso, altura, objetivo);
                String json = gson.toJson(aluno);

                // Apresenta os dados em formato JSON
                JOptionPane.showMessageDialog(frame, "Dados em JSON:\n" + json);
            }
        });

        // Ação do botão "Sair"
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Exibe a janela
        frame.setVisible(true);
    }

    // Classe para representar os dados do aluno
    static class Aluno {
        private String nome;
        private int idade;
        private float peso;
        private float altura;
        private String objetivo;

        public Aluno(String nome, int idade, float peso, float altura, String objetivo) {
            this.nome = nome;
            this.idade = idade;
            this.peso = peso;
            this.altura = altura;
            this.objetivo = objetivo;
        }

        // Getters e setters (opcional se precisar)
    }
}
