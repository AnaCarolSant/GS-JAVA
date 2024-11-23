package br.com.controller;

import br.com.model.bo.EmpresaBO;
import br.com.model.beans.Empresa;

import java.sql.SQLException;
import java.util.List;

public class EmpresaController {

    private EmpresaBO empresaBO = new EmpresaBO();

    public void adicionarEmpresa(Empresa empresa) {
        try {
            empresaBO.adicionarEmpresa(empresa);
            System.out.println("Empresa adicionada com sucesso!");
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("Erro ao adicionar empresa: " + e.getMessage());
        }
    }

    public Empresa buscarEmpresaPorId(int idEmpresa) {
        try {
            return empresaBO.buscarEmpresaPorId(idEmpresa);
        } catch (SQLException e) {
            System.out.println("Erro ao buscar empresa: " + e.getMessage());
            return null;
        }
    }

    public void atualizarEmpresa(Empresa empresa) {
        try {
            empresaBO.atualizarEmpresa(empresa);
            System.out.println("Empresa atualizada com sucesso!");
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("Erro ao atualizar empresa: " + e.getMessage());
        }
    }

    public void deletarEmpresa(int idEmpresa) {
        try {
            empresaBO.deletarEmpresa(idEmpresa);
            System.out.println("Empresa deletada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar empresa: " + e.getMessage());
        }
    }

    public List<Empresa> listarEmpresas() {
        try {
            return empresaBO.listarEmpresas();
        } catch (SQLException e) {
            System.out.println("Erro ao listar empresas: " + e.getMessage());
            return null;
        }
    }
}
