package com.nexuscare.recipe.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", length = 150, nullable = false)
    private String nomeCompleto;

    @Column(name = "endereco_completo", columnDefinition = "TEXT", nullable = false)
    private String enderecoCompleto;

    @Column(name = "codigo_pronto", length = 50, nullable = false, unique = true)
    private String codigoPronto;

    @Column(name = "codigo_cns", length = 20, nullable = false, unique = true)
    private String codigoCns;

    @Column(nullable = false, length = 1)
    private String sexo;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    public Paciente() {
    }

    public Paciente(Long id, String nomeCompleto, String enderecoCompleto, String codigoPronto,
                    String codigoCns, String sexo, LocalDate dataNascimento) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.enderecoCompleto = enderecoCompleto;
        this.codigoPronto = codigoPronto;
        this.codigoCns = codigoCns;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public String getCodigoPronto() {
        return codigoPronto;
    }

    public void setCodigoPronto(String codigoPronto) {
        this.codigoPronto = codigoPronto;
    }

    public String getCodigoCns() {
        return codigoCns;
    }

    public void setCodigoCns(String codigoCns) {
        this.codigoCns = codigoCns;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Paciente [id=" + id + ", nomeCompleto=" + nomeCompleto + ", enderecoCompleto=" + enderecoCompleto
                + ", codigoPronto=" + codigoPronto + ", codigoCns=" + codigoCns + ", sexo=" + sexo
                + ", dataNascimento=" + dataNascimento + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Paciente))
            return false;
        Paciente other = (Paciente) obj;
        return Objects.equals(id, other.id);
    }
}
