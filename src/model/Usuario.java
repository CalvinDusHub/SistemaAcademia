package model;

import java.util.ArrayList;

public class Usuario {

  private String login;
  private String senha;
  private ArrayList<String> historicoSenhas;

  public Usuario() {
    historicoSenhas = new ArrayList<>();
  }

  public Usuario(String login, String senha) {
    this.login = login;
    this.senha = senha;

    historicoSenhas = new ArrayList<>();
    historicoSenhas.add(senha);
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public boolean validarLogin(String login, String senha) {

    return this.login.equals(login)
        && this.senha.equals(senha);
  }

  public boolean trocarSenha(String novaSenha) {

    if (historicoSenhas.contains(novaSenha)) {
      return false;
    }

    senha = novaSenha;

    historicoSenhas.add(novaSenha);

    if (historicoSenhas.size() > 3) {
      historicoSenhas.remove(0);
    }

    return true;
  }

  @Override
  public String toString() {

    return "Login: " + login;
  }
}