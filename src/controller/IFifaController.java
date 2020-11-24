package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

public interface IFifaController {
    public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException;

    public void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException;

    public LinkedList<String> listaRevelacoes(String caminho, String nome) throws IOException;

    public void buscaListaBonsJovens(LinkedList<String> lista) throws IOException;
}