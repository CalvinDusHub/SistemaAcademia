package model;

public class Matricula {

  private Aluno aluno;
  private Instrutor instrutor;
  private Treino treino;

  public Matricula() {
  }

  public Matricula(Aluno aluno,
      Instrutor instrutor,
      Treino treino) {

    this.aluno = aluno;
    this.instrutor = instrutor;
    this.treino = treino;
  }

  public Aluno getAluno() {
    return aluno;
  }

  public void setAluno(Aluno aluno) {
    this.aluno = aluno;
  }

  public Instrutor getInstrutor() {
    return instrutor;
  }

  public void setInstrutor(
      Instrutor instrutor) {

    this.instrutor = instrutor;
  }

  public Treino getTreino() {
    return treino;
  }

  public void setTreino(Treino treino) {
    this.treino = treino;
  }

  @Override
  public String toString() {

    return "\n===== MATRÍCULA =====\n"
        + aluno
        + "\n\n"
        + instrutor
        + "\n\n"
        + treino;
  }
}