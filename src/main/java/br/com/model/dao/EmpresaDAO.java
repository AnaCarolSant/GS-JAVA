package br.com.model.dao;

import br.com.conexao.DatabaseConnection;
import br.com.model.beans.Empresa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {

    // Método para inserir uma nova empresa
    public void inserirEmpresa(Empresa empresa) throws SQLException {
        String sql = "INSERT INTO tb_empresa (id_empresa, nome_empresa, num_cnpj, setor, localizacao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, empresa.getIdEmpresa());
            stmt.setString(2, empresa.getNomeEmpresa());
            stmt.setString(3, empresa.getNumCnpj());
            stmt.setString(4, empresa.getSetor());
            stmt.setString(5, empresa.getLocalizacao());
            stmt.executeUpdate();
        }
    }

    // Método para atualizar uma empresa existente
    public void atualizarEmpresa(Empresa empresa) throws SQLException {
        String sql = "UPDATE tb_empresa SET nome_empresa = ?, num_cnpj = ?, setor = ?, localizacao = ? WHERE id_empresa = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empresa.getNomeEmpresa());
            stmt.setString(2, empresa.getNumCnpj());
            stmt.setString(3, empresa.getSetor());
            stmt.setString(4, empresa.getLocalizacao());
            stmt.setInt(5, empresa.getIdEmpresa());
            stmt.executeUpdate();
        }
    }

    // Método para excluir uma empresa
    public void excluirEmpresa(int idEmpresa) throws SQLException {
        String sql = "DELETE FROM tb_empresa WHERE id_empresa = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEmpresa);
            stmt.executeUpdate();
        }
    }

    // Método para buscar uma empresa pelo ID
    public Empresa buscarEmpresaPorId(int idEmpresa) throws SQLException {
        String sql = "SELECT * FROM tb_empresa WHERE id_empresa = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEmpresa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Empresa(
                        rs.getInt("id_empresa"),
                        rs.getString("num_cnpj"),
                        rs.getString("nome_empresa"),
                        rs.getString("setor"),
                        rs.getString("localizacao")
                );
            }
        }
        return null;
    }

    // Método para listar todas as empresas
    public List<Empresa> listarEmpresas() throws SQLException {
        List<Empresa> empresas = new ArrayList<>();
        String sql = "SELECT * FROM tb_empresa";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Empresa empresa = new Empresa(
                        rs.getInt("id_empresa"),
                        rs.getString("num_cnpj"),
                        rs.getString("nome_empresa"),
                        rs.getString("setor"),
                        rs.getString("localizacao")
                );
                empresas.add(empresa);
            }
        }
        return empresas;
    }
}
