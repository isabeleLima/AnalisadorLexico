import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<String> arrayListString = new ArrayList<>();
    static String classeRegex = "^[A-Z][a-zA-Z]*|(?:[A-Z][a-zA-Z]*){2}$";
    static String classeUnderRegex = "^[A-Z][a-zA-Z]*_[A-Z][a-zA-Z]*$";
    static String numeroRegex = "^[1-9]\\d*$";
    static String hasRegex ="^has[A-Z][a-zA-Z0-9]*$";
    static String isRegex ="^is[A-Z][a-zA-Z0-9]*$";
    static ArrayList<String> palavrasReservadas = new ArrayList<>();

    public static void IniciarPalavrasReservadas(){
        palavrasReservadas.add("some");
        palavrasReservadas.add("all");
        palavrasReservadas.add("value");
        palavrasReservadas.add("min");
        palavrasReservadas.add("max");
        palavrasReservadas.add("exactly");
        palavrasReservadas.add("that");
        palavrasReservadas.add("not");
        palavrasReservadas.add("and");
        palavrasReservadas.add("or");
    }
    public static void lerArquivoTXT(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] vetorPalavras = linha.split(" ");
                for (String palavra : vetorPalavras) {
                    arrayListString.add(palavra);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String retornarTipo(String palavra){
        if (palavrasReservadas.contains(palavra.toLowerCase())){
            return "PALAVRA RESERVADA";
        }else if(palavra.matches(classeRegex) || palavra.matches(classeUnderRegex)){
            return "CLASSE";
        }else if(palavra.matches(numeroRegex)){
            return "NUMERO";
        }else if (palavra.matches(hasRegex)){
            return "PROPRIEDADE";
        }else if (palavra.matches(hasRegex) || palavra.matches(isRegex)){
            return "PROPRIEDADE";
        }
        return "DESCONHECIDO";
    }

    public static void drawTable(List<List<String>> data) {
        int numRows = data.size();
        int numColumns = data.get(0).size();

        // Calcular a largura das colunas
        int[] columnWidths = new int[numColumns];
        for (int col = 0; col < numColumns; col++) {
            for (int row = 0; row < numRows; row++) {
                int width = data.get(row).get(col).length();
                if (width > columnWidths[col]) {
                    columnWidths[col] = width;
                }
            }
        }

        // Desenhar a tabela
        for (int row = 0; row < numRows; row++) {
            List<String> rowData = data.get(row);
            for (int col = 0; col < numColumns; col++) {
                String cell = rowData.get(col);
                System.out.print("| " + padRight(cell, columnWidths[col]) + " ");
            }
            System.out.println("|");
            if (row == 0) {
                for (int col = 0; col < numColumns; col++) {
                    System.out.print("+");
                    for (int i = 0; i < columnWidths[col] + 2; i++) {
                        System.out.print("-");
                    }
                }
                System.out.println("+");
            }
        }
    }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
    public static void main(String[] args) {
        String caminhoArquivo = "caminho do cod.txt";
        lerArquivoTXT(caminhoArquivo);
        IniciarPalavrasReservadas();

        List<List<String>> dataForTable = new ArrayList<>(); //Só pra desenhar a tabela bonitinho

        List<String> firstRow = new ArrayList<>();
        firstRow.add("TOKEN");
        firstRow.add("TIPO");
        dataForTable.add(firstRow);

        for (String elemento : arrayListString) {
            List<String> row = new ArrayList<>();
            row.add(elemento);
            row.add(retornarTipo(elemento));
            dataForTable.add(row);
        }

        drawTable(dataForTable);
    }
}
