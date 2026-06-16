package model;

public class Instrutor extends Pessoa {

    private String cref;
    private String especialidade;

    public Instrutor() {
        super();
    }

    public Instrutor(String nome, String cpf, int idade,
                     String cref, String especialidade) {

        super(nome, cpf, idade);
        this.cref = cref;
        this.especialidade = especialidade;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}