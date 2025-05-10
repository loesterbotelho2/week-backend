package com.nexuscare.recipe.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "receita_medicamentos")
public class ReceitaMedicamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "receita_id", nullable = false)
    private Receita receita;

    @ManyToOne
    @JoinColumn(name = "medicamento_id", nullable = false)
    private NomeMedicamentos medicamento;

    private String dosagem;

    private Integer quantidade;

    @Column(columnDefinition = "TEXT")
    private String instrucoes;

    public ReceitaMedicamentos() {
    }

    public ReceitaMedicamentos(Long id, Receita receita, NomeMedicamentos medicamento, String dosagem, Integer quantidade, String instrucoes) {
        this.id = id;
        this.receita = receita;
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.quantidade = quantidade;
        this.instrucoes = instrucoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public NomeMedicamentos getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(NomeMedicamentos medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }

    @Override
    public String toString() {
        return "ReceitaMedicamentos [id=" + id + ", receita=" + receita + ", medicamento=" + medicamento + ", dosagem="
                + dosagem + ", quantidade=" + quantidade + ", instrucoes=" + instrucoes + "]";
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
        ReceitaMedicamentos other = (ReceitaMedicamentos) obj;
        return Objects.equals(id, other.id);
    }
}
