package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoUtil {

  public static void salvar(String caminho, String conteudo) {

    try {

      BufferedWriter buff = new BufferedWriter(new FileWriter(caminho, true));
      buff.write(conteudo);
      buff.newLine();

      buff.close();
    } catch (IOException e) {

      System.out.println("Erro ao salvar arquivo: " + e.getMessage());
    }
  }

  public static void ler(String caminho) {

    try {

      BufferedReader br = new BufferedReader(new FileReader(caminho));
      String linha;

      while ((linha = br.readLine()) != null) {
        System.out.println(linha);
      }

      br.close();

    } catch (IOException e) {

      System.out.println("Erro ao ler arquivo: " + e.getMessage());
    }
  }
}