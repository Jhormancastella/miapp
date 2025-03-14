package com.miapp.infrastructure.persistence.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.miapp.domain.entity.Client;
import com.miapp.domain.repository.ClientRespository;
import com.miapp.infrastructure.database.ConnectionDb;

public class ClientRepositoryImpl implements ClientRespository {
    private final ConnectionDb connection;
    
    public ClientRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void guardar(Client clientes) {
        String sql = "INSERT INTO client (id, name, email) VALUES (?, ?, ?)";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, clientes.getId());
             stmt.setString(2, clientes.getName());
                stmt.setString(3, clientes.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client buscarPorId(int id) {
        String sql = "SELECT * FROM client WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Client(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el cliente por ID", e);
        }
        return null; // Retorna null si no se encuentra el cliente
    }

    @Override
    public List<Client> listarTodos() {
        List<Client> client = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (Connection conexion = connection.getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                client.add(new Client(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void actualizar(Client cliente) {
        String sql = "UPDATE client SET name = ?, email = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getName());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM client WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}