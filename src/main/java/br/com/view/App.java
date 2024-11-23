package br.com.view;

import br.com.controller.EmpresaController;
import br.com.controller.PerfilEnergeticoController;
import br.com.model.beans.Empresa;
import br.com.model.beans.PerfilEnergetico;

import java.sql.Timestamp;

public class App {

    public static void main(String[] args) {
        EmpresaController empresaController = new EmpresaController();
        PerfilEnergeticoController perfilEnergeticoController = new PerfilEnergeticoController();

        // CRUD Empresa
        Empresa empresa = new Empresa(1, "12345678000198", "Empresa X", "Tecnologia", "São Paulo");
        empresaController.adicionarEmpresa(empresa);
        Empresa empresa2 = new Empresa(2, "12345678000199", "Empresa Z", "Tecnologia", "São Paulo");
        empresaController.adicionarEmpresa(empresa2);

        empresa = empresaController.buscarEmpresaPorId(1);
        System.out.println("Empresa buscada: " + empresa);

        empresa.setNomeEmpresa("Empresa Y");
        empresaController.atualizarEmpresa(empresa);


        // CRUD PerfilEnergetico
        PerfilEnergetico perfilEnergetico = new PerfilEnergetico(1, 1, 5000, "17:00", "Solar");
        perfilEnergeticoController.adicionarPerfilEnergetico(perfilEnergetico);
        PerfilEnergetico perfilEnergetico2 = new PerfilEnergetico(2, 2, 4000, "15:00", "EÓLICA");
        perfilEnergeticoController.adicionarPerfilEnergetico(perfilEnergetico2);

        perfilEnergetico = perfilEnergeticoController.buscarPerfilEnergeticoPorId(1);
        System.out.println("Perfil energético buscado: " + perfilEnergetico);

        perfilEnergetico.setConsumoMensal(6000);
        perfilEnergeticoController.atualizarPerfilEnergetico(perfilEnergetico);

        perfilEnergeticoController.deletarPerfilEnergetico(1);
        empresaController.deletarEmpresa(1);

    }
}
