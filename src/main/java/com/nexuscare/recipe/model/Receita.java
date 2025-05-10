package com.nexuscare.recipe.model;

import java.util.Objects;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "receita")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "cid_id")
    private Cid cid;

    @Column(name = "data_emissao", nullable = false)
    private LocalDate dataEmissao;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public Receita() {
    }

    public Receita(Long id, Paciente paciente, Medico medico, Cid cid, LocalDate dataEmissao, String observacoes) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.cid = cid;
        this.dataEmissao = dataEmissao;
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Cid getCid() {
        return cid;
    }

    public void setCid(Cid cid) {
        this.cid = cid;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Receita [id=" + id + ", paciente=" + paciente + ", medico=" + medico + ", cid=" + cid + ", dataEmissao=" + dataEmissao + ", observacoes=" + observacoes + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Receita other = (Receita) obj;
        return Objects.equals(id, other.id);
    }
}
