package com.example.dam214.ejerciciobases1;

public interface UsuarioDAO {
    Usuario getUsuario(String login, String password);
    boolean insertarUsuario(Usuario usr);
}
