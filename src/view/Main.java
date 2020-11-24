package view;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import controller.FifaController;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<String> pilha = new Stack<>();
        LinkedList<String> listaEncadeada = new LinkedList<String>();
        FifaController fc = new FifaController();
        String diretorio = "C:/temp/";
        String arquivo = "data.csv";
        int opc = 0;
        Scanner scan = new Scanner(System.in);
        while (opc != 9) {
            System.out.println("**************************************************************");
            System.out.println("MENU PRINCIPAL\nEscolha uma opcao:\n\n"
            + "1- Empilhar brasileiros.\n"
            + "2- Desempilhar bons brasileiros.\n"
            + "3- Lista revelacoes.\n"
            + "4- Busca bons jovens.\n"
            + "9- Finalizar programa.");
            System.out.println("**************************************************************\n");
            opc = scan.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("\nEmpilhando brasileiros...");
                    pilha = fc.empilhaBrasileiros(diretorio, arquivo);
                    System.out.println("\nBrasileiros empilhados com sucesso!");
                    System.out.println("------------------------------------------------------------\n");
                    break;
                case 2:
                    if (!pilha.empty()) {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("\nDesempilhando brasileiros...");
                        fc.desmpilhaBonsBrasileiros(pilha);
                        System.out.println("\nBrasileiros desempilhados com sucesso!");
                        System.out.println("------------------------------------------------------------\n");
                    } else {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Ops, a pilha está vazia!");
                        System.out.println("------------------------------------------------------------\n");
                    }
                    break;
                case 3:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("\nListando revelacoes...");
                    listaEncadeada = fc.listaRevelacoes(diretorio, arquivo);
                    System.out.println("\nRevelacoes listadas com sucesso!");
                    System.out.println("------------------------------------------------------------\n");
                    break;
                case 4:
                    if (!listaEncadeada.isEmpty()) {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("\nBuscando bons jovens...");
                        fc.buscaListaBonsJovens(listaEncadeada);
                        System.out.println("\nBons jovens encontrados com sucesso!");
                        System.out.println("------------------------------------------------------------\n");
                    } else {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Ops, a lista está vazia!");
                        System.out.println("------------------------------------------------------------\n");
                    }
                    break;
                case 9:
                    System.out.println("FINALIZANDO PROGRAMA...");
                    break;
                default:
                    System.out.println("Ops, opcao invalida!");
                    break;
            }
        }
    }
}