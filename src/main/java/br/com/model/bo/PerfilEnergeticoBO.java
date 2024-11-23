package br.com.model.bo;

import br.com.model.dao.PerfilEnergeticoDAO;
import br.com.model.dao.EmpresaDAO;
import br.com.model.beans.PerfilEnergetico;

import java.sql.SQLException;
import java.util.List;

public class PerfilEnergeticoBO {

    private PerfilEnergeticoDAO perfilEnergeticoDAO = new PerfilEnergeticoDAO();
    private EmpresaDAO empresaDAO = new EmpresaDAO();

    public void adicionarPerfilEnergetico(PerfilEnergetico perfil) throws SQLException {
        if (empresaDAO.buscarEmpresaPorId(perfil.getIdEmpresa()) == null) {
            throw new IllegalArgumentException("Empresa não existe.");
        }
        perfilEnergeticoDAO.inserirPerfilEnergetico(perfil);
    }

    public PerfilEnergetico buscarPerfilEnergeticoPorId(int idPerfilEnergetico) throws SQLException {
        return perfilEnergeticoDAO.buscarPerfilEnergeticoPorId(idPerfilEnergetico);
    }

    public void atualizarPerfilEnergetico(PerfilEnergetico perfil) throws SQLException {
        if (empresaDAO.buscarEmpresaPorId(perfil.getIdEmpresa()) == null) {
            throw new IllegalArgumentException("Empresa não existe.");
        }
        perfilEnergeticoDAO.atualizarPerfilEnergetico(perfil);
    }

    public void deletarPerfilEnergetico(int idPerfilEnergetico) throws SQLException {
        perfilEnergeticoDAO.excluirPerfilEnergetico(idPerfilEnergetico);
    }

    public List<PerfilEnergetico> listarPerfisEnergeticos() throws SQLException {
        return perfilEnergeticoDAO.listarPerfisEnergeticos();
    }
}
