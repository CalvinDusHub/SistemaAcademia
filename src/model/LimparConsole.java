package model;

import java.io.IOException;

public class LimparConsole {
  public static void limpar() {
    try {
      String sistemaOperacional = System.getProperty("os.name");

      if (sistemaOperacional.contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        Runtime.getRuntime().exec("clear");
      }
    } catch (IOException | InterruptedException e) {
      System.err.println("Erro ao tentar limpar o console: " + e.getMessage());
    }
  }
}
