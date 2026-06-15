package model;

public class Aluno extends Pessoa {

  private String objetivo;
  private String plano;

  public Aluno() {
  }

  public Aluno(String nome,
      String cpf,
      int idade,
      String objetivo,
      String plano) {

    super(nome, cpf, idade);

    this.objetivo = objetivo;
    this.plano = plano;
  }

  public String getObjetivo() {
    return objetivo;
  }

  public void setObjetivo(String objetivo) {
    this.objetivo = objetivo;
  }

  public String getPlano() {
    return plano;
  }

  public void setPlano(String plano) {
    this.plano = plano;
  }

  @Override
  public String toString() {

    return super.toString()
        + "\nObjetivo: " + objetivo
        + "\nPlano: " + plano;
  }
}