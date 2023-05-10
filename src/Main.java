import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            //inicia a classe LexicalAnalyzer e recebe o arquivo txt com o cod
            LexicalAnalyzer lexical = new LexicalAnalyzer();

            String FilePath = "C:/Users/Isabelle Cristina/Documents/Semestre6/compiladores/AnalisadorLexico/src/cod.txt";
            lexical.readFile(FilePath);


            //Lista para impressão da tabela no terminal
            List<List<String>> dataForTable = new ArrayList<>();

            //primeira linha da tabela com o nome das colunas
            List<String> firstRow = new ArrayList<>();
            firstRow.add("TOKEN");
            firstRow.add("TIPO");
            dataForTable.add(firstRow);


            //foreach que percorre o arrayListString que contem todas as palavras do txt cria uma nova linha com o token e o tipo e adiciona na tabela
            for (String elemento : lexical.arrayListString) {
                List<String> row = new ArrayList<>();

                row.add(elemento);//token
                row.add(lexical.returnType(elemento));//tipo do token

                dataForTable.add(row);
            }
            //desenha a tabela
            lexical.drawTable(dataForTable);
    }
}
