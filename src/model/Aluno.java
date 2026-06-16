package model;

public class Aluno extends Pessoa {

    private double mensalidade;
    private String plano;

    public Aluno() {
        super();
    }

    public Aluno(String nome, String cpf, int idade,
                 double mensalidade, String plano) {

        super(nome, cpf, idade);
        this.mensalidade = mensalidade;
        this.plano = plano;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }
}