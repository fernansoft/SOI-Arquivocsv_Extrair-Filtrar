package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class FifaController implements IFifaController {

    @Override
    public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
        Stack<String> pilha = new Stack<String>();
        FileInputStream fluxo = new FileInputStream(caminho + nome);
        InputStreamReader leitor = new InputStreamReader(fluxo);
        BufferedReader buffer = new BufferedReader(leitor);
        String linha = buffer.readLine();
        linha = buffer.readLine();
        while (linha != null) {
            String[] dados = linha.split(",");
            if (dados[5].compareToIgnoreCase("brazil") == 0) {
                pilha.push(linha);
            }
            linha = buffer.readLine();
        }
        fluxo.close();
        leitor.close();
        buffer.close();
        return pilha;
    }

    @Override
    public void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException {
        while (!pilha.empty()) {
            String[] dados = pilha.pop().split(",");
            if (Integer.parseInt(dados[7]) > 80) {
                System.out.println("\n==>Nome: " + dados[2] + "\n>>>Overall: " + dados[7]);
            }
        }
    }

    @Override
    public LinkedList<String> listaRevelacoes(String caminho, String nome) throws IOException {
        LinkedList<String> listaEncadeada = new LinkedList<String>();
        FileInputStream fluxo = new FileInputStream(caminho + nome);
        InputStreamReader leitor = new InputStreamReader(fluxo);
        BufferedReader buffer = new BufferedReader(leitor);
        String linha = buffer.readLine();
        linha = buffer.readLine();
        while (linha != null) {
            String[] dados = linha.split(",");
            if (Integer.parseInt(dados[3]) <= 20) {
                listaEncadeada.add(linha);
            }
            linha = buffer.readLine();
        }
        fluxo.close();
        leitor.close();
        buffer.close();
        return listaEncadeada;
    }

    @Override
    public void buscaListaBonsJovens(LinkedList<String> lista) throws IOException {
        for (int i = lista.size() - 1; i >= 0; i--) {
            String[] dados = lista.get(i).split(",");
            if (Integer.parseInt(dados[7]) > 80 && Integer.parseInt(dados[3]) <= 20) {
                System.out.println("\n==>Nome: " + dados[2] + "\n***Idade: " + dados[3] + "\n>>>Overall: " + dados[7]);
            }
        }
    }
}