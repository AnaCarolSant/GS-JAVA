package br.com.controller;

import br.com.model.bo.PerfilEnergeticoBO;
import br.com.model.beans.PerfilEnergetico;

import java.sql.SQLException;
import java.util.List;

public class PerfilEnergeticoController {

    private PerfilEnergeticoBO perfilEnergeticoBO = new PerfilEnergeticoBO();

    public void adicionarPerfilEnergetico(PerfilEnergetico perfilEnergetico) {
        try {
            perfilEnergeticoBO.adicionarPerfilEnergetico(perfilEnergetico);
            System.out.println("Perfil energético adicionado com sucesso!");
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("Erro ao adicionar perfil energético: " + e.getMessage());
        }
    }

    public PerfilEnergetico buscarPerfilEnergeticoPorId(int idPerfilEnergetico) {
        try {
            return perfilEnergeticoBO.buscarPerfilEnergeticoPorId(idPerfilEnergetico);
        } catch (SQLException e) {
            System.out.println("Erro ao buscar perfil energético: " + e.getMessage());
            return null;
        }
    }

    public void atualizarPerfilEnergetico(PerfilEnergetico perfilEnergetico) {
        try {
            perfilEnergeticoBO.atualizarPerfilEnergetico(perfilEnergetico);
            System.out.println("Perfil energético atualizado com sucesso!");
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("Erro ao atualizar perfil energético: " + e.getMessage());
        }
    }

    public void deletarPerfilEnergetico(int idPerfilEnergetico) {
        try {
            perfilEnergeticoBO.deletarPerfilEnergetico(idPerfilEnergetico);
            System.out.println("Perfil energético deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar perfil energético: " + e.getMessage());
        }
    }

    public List<PerfilEnergetico> listarPerfisEnergeticos() {
        try {
            return perfilEnergeticoBO.listarPerfisEnergeticos();
        } catch (SQLException e) {
            System.out.println("Erro ao listar perfis energéticos: " + e.getMessage());
            return null;
        }
    }
}
