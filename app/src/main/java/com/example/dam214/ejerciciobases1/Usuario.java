package com.example.dam214.ejerciciobases1;

public class Usuario {
    String nombre, login, password, email, plataforma, genero;
    int id;

    public Usuario(String nombre, String login, String password, int id) {
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public Usuario(String nombre, String login, String password, String email, String plataforma, String genero) {
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.email = email;
        this.plataforma = plataforma;
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
