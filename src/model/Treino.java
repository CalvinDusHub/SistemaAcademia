package model;

import java.util.ArrayList;

public class Treino {

  private String nome;
  private ArrayList<Exercicio> exercicios;

  public Treino() {
    exercicios = new ArrayList<>();
  }

  public Treino(String nome) {

    this.nome = nome;
    exercicios = new ArrayList<>();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public ArrayList<Exercicio> getExercicios() {
    return exercicios;
  }

  public void adicionarExercicio(Exercicio exercicio) {
    exercicios.add(exercicio);

  }

  @Override
  public String toString() {

    String texto = "\nTreino: " + nome + "\n";

    for (Exercicio e : exercicios) {

      texto += e.toString() + "\n";
    }

    return texto;
  }
}