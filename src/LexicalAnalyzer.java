import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyzer {
    static ArrayList<String> arrayListString = new ArrayList<>();
    static String classeRegex = "^[A-Z][a-zA-Z]*|(?:[A-Z][a-zA-Z]*){2}$";
    //Reconhece palavras que começam com letra maiusucla ou são duas palavras concatenadas que começam com letra maiuscula ex: Pizza ou PizzaVegetariana
    static String classeUnderRegex = "^[A-Z][a-zA-Z]*_[A-Z][a-zA-Z]*$";
    //Reconhece duas palavras concatenadas por _ que começam com letra maiuscula ex: Pizza_Vegetariana
    static String numeroRegex = "^[1-9]\\d*$";
    //Reconhece numeros de 0 a 9;
    static String hasRegex ="^has[A-Z][a-zA-Z0-9]*$";
    //Reconhece propriedades que começam com has seguidos por letra maiuscula ex: hasOnion
    static String isRegex ="^is[A-Z][czA-Z0-9]*$";
    //Reconhece propriedades que Começam com is seguidos por letra maiuscula ex: isSpice

    static String isCaracter ="[\\(\\)>=<=]|==|>";
    //Reconhece simbolos com ( ) >= <= == > <;
    static ArrayList<String> palavrasReservadas = new ArrayList<>();
    //Array das palavras reservadas da linguagem


    public static void iniciarPalavrasReservadas(){
        //Função para iniciar o array de palavras reservadas com os valores da linguagem
        palavrasReservadas.add("some");
        palavrasReservadas.add("only");
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
    public static void readFile(String caminhoArquivo) {
        //Função que recebe o arquivo txt ele lê cada linha e separa as palavras pelo caractere de espaço " " depois adiciona cada palavra ao vetor arrayListString
        iniciarPalavrasReservadas();
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

    public static String returnType(String palavra){
        //Função que retorna o tipo da palavra baseada no regex
        if (palavrasReservadas.contains(palavra.toLowerCase())){
            return "PALAVRA RESERVADA";
        }else if(palavra.matches(classeRegex) || palavra.matches(classeUnderRegex)){
            return "CLASSE";
        }else if(palavra.matches(numeroRegex)){
            return "NUMERO";
        }else if (palavra.matches(hasRegex) || palavra.matches(isRegex)){
            return "PROPRIEDADE";
        }else if (palavra.matches(isCaracter) ){
            return "SIMBOLO";
        }
        return "DESCONHECIDO";
    }

    //drawTable e padRight são funções só estéticas que fazem o papel de desenha a tabela no terminal pra melhor visualização
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
}
