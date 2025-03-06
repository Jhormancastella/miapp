package com.miapp;

import com.miapp.application.usecase.client.ClientUseCase;
import com.miapp.domain.repository.ClientRespository;
import com.miapp.infrastructure.database.ConnectionFactory;
import com.miapp.infrastructure.persistence.client.ClientRepositoryImpl;



public class Main {
    public static void main(String[] args) {
        ClientRespository repositorio = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
        ClientUseCase clientUseCase = new ClientUseCase(repositorio);
    }
}