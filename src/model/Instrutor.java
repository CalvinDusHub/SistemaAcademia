package model;

public class Instrutor extends Pessoa {

  private String especialidade;

  public Instrutor() {
  }

  public Instrutor(String nome,
      String cpf,
      int idade,
      String especialidade) {

    super(nome, cpf, idade);

    this.especialidade = especialidade;
  }

  public String getEspecialidade() {
    return especialidade;
  }

  public void setEspecialidade(String especialidade) {
    this.especialidade = especialidade;
  }

  @Override
  public String toString() {

    return super.toString()
        + "\nEspecialidade: "
        + especialidade;
  }
}