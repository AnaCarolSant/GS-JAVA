package br.com.model.beans;

import java.sql.Timestamp;

public class PerfilEnergetico {

    public PerfilEnergetico() {
    }

    private int idPerfilEnergetico;
    private int idEmpresa;
    private int consumoMensal;
    private String horarioPico;
    private String tipoEnergia;

    public PerfilEnergetico(int idPerfilEnergetico, int idEmpresa, int consumoMensal, String horarioPico, String tipoEnergia) {
        this.idPerfilEnergetico = idPerfilEnergetico;
        this.idEmpresa = idEmpresa;
        this.consumoMensal = consumoMensal;
        this.horarioPico = horarioPico;
        this.tipoEnergia = tipoEnergia;
    }

    public int getIdPerfilEnergetico() {
        return idPerfilEnergetico;
    }

    public void setIdPerfilEnergetico(int idPerfilEnergetico) {
        this.idPerfilEnergetico = idPerfilEnergetico;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getConsumoMensal() {
        return consumoMensal;
    }

    public void setConsumoMensal(int consumoMensal) {
        this.consumoMensal = consumoMensal;
    }

    public String getHorarioPico() {
        return horarioPico;
    }

    public void setHorarioPico(String horarioPico) {
        this.horarioPico = horarioPico;
    }

    public String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    @Override
    public String toString() {
        return "PerfilEnergeticoVO{" +
                "idPerfilEnergetico=" + idPerfilEnergetico +
                ", idEmpresa=" + idEmpresa +
                ", consumoMensal=" + consumoMensal +
                ", horarioPico=" + horarioPico +
                ", tipoEnergia='" + tipoEnergia + '\'' +
                '}';
    }
}
