package model;

public class Exercicio {

    private String nome;
    private String grupoMuscular;
    private int series;
    private int repeticoes;

    public Exercicio() {
    }

    public Exercicio(String nome, String grupoMuscular,
                     int series, int repeticoes) {
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }
}