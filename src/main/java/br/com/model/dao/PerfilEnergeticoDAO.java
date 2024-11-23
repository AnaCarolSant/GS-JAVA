package br.com.model.dao;

import br.com.conexao.DatabaseConnection;
import br.com.model.beans.PerfilEnergetico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerfilEnergeticoDAO {

    // Método para inserir um novo perfil energético
    public void inserirPerfilEnergetico(PerfilEnergetico perfil) throws SQLException {
        String sql = "INSERT INTO tb_perfil_energetico (id_perfil_energetico, id_empresa, consumo_mensal, horario_pico, tipo_energia) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, perfil.getIdPerfilEnergetico());
            stmt.setInt(2, perfil.getIdEmpresa());
            stmt.setInt(3, perfil.getConsumoMensal());
            stmt.setString(4, perfil.getHorarioPico());
            stmt.setString(5, perfil.getTipoEnergia());
            stmt.executeUpdate();
        }
    }

    // Método para atualizar um perfil energético existente
    public void atualizarPerfilEnergetico(PerfilEnergetico perfil) throws SQLException {
        String sql = "UPDATE tb_perfil_energetico SET id_empresa = ?, consumo_mensal = ?, horario_pico = ?, tipo_energia = ? WHERE id_perfil_energetico = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, perfil.getIdEmpresa());
            stmt.setInt(2, perfil.getConsumoMensal());
            stmt.setString(3, perfil.getHorarioPico());
            stmt.setString(4, perfil.getTipoEnergia());
            stmt.setInt(5, perfil.getIdPerfilEnergetico());
            stmt.executeUpdate();
        }
    }

    // Método para excluir um perfil energético
    public void excluirPerfilEnergetico(int idPerfilEnergetico) throws SQLException {
        String sql = "DELETE FROM tb_perfil_energetico WHERE id_perfil_energetico = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPerfilEnergetico);
            stmt.executeUpdate();
        }
    }

    // Método para buscar um perfil energético pelo ID
    public PerfilEnergetico buscarPerfilEnergeticoPorId(int idPerfilEnergetico) throws SQLException {
        String sql = "SELECT * FROM tb_perfil_energetico WHERE id_perfil_energetico = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPerfilEnergetico);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new PerfilEnergetico(
                        rs.getInt("id_perfil_energetico"),
                        rs.getInt("id_empresa"),
                        rs.getInt("consumo_mensal"),
                        rs.getString("horario_pico"),
                        rs.getString("tipo_energia")
                );
            }
        }
        return null;
    }

    // Método para listar todos os perfis energéticos
    public List<PerfilEnergetico> listarPerfisEnergeticos() throws SQLException {
        List<PerfilEnergetico> perfis = new ArrayList<>();
        String sql = "SELECT * FROM tb_perfil_energetico";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                PerfilEnergetico perfil = new PerfilEnergetico(
                        rs.getInt("id_perfil_energetico"),
                        rs.getInt("id_empresa"),
                        rs.getInt("consumo_mensal"),
                        rs.getString("horario_pico"),
                        rs.getString("tipo_energia")
                );
                perfis.add(perfil);
            }
        }
        return perfis;
    }
}
