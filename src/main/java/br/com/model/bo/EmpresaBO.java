package br.com.model.bo;

import br.com.model.dao.EmpresaDAO;
import br.com.model.beans.Empresa;

import java.sql.SQLException;
import java.util.List;

public class EmpresaBO {

    private EmpresaDAO empresaDAO = new EmpresaDAO();

    public void adicionarEmpresa(Empresa empresa) throws SQLException {
        // Validação de negócio (exemplo): CNPJ único, não nulo
        if (empresa.getNumCnpj() == null || empresa.getNumCnpj().isEmpty()) {
            throw new IllegalArgumentException("CNPJ não pode ser nulo ou vazio");
        }
        empresaDAO.inserirEmpresa(empresa);
    }

    public Empresa buscarEmpresaPorId(int idEmpresa) throws SQLException {
        return empresaDAO.buscarEmpresaPorId(idEmpresa);
    }

    public void atualizarEmpresa(Empresa empresa) throws SQLException {
        if (empresa.getIdEmpresa() <= 0) {
            throw new IllegalArgumentException("ID da empresa inválido");
        }
        empresaDAO.atualizarEmpresa(empresa);
    }

    public void deletarEmpresa(int idEmpresa) throws SQLException {
        empresaDAO.excluirEmpresa(idEmpresa);
    }

    public List<Empresa> listarEmpresas() throws SQLException {
        return empresaDAO.listarEmpresas();
    }
}
