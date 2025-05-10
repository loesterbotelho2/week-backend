package com.nexuscare.recipe.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "nome_medicamentos")
public class NomeMedicamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_comercial", length = 150, nullable = false)
    private String nomeComercial;

    @Column(name = "principio_ativo", length = 150)
    private String principioAtivo;

    @Column(name = "para_que_serve", length = 255)
    private String paraQueServe;

    public NomeMedicamentos() {
    }

    public NomeMedicamentos(Long id, String nomeComercial, String principioAtivo, String paraQueServe) {
        this.id = id;
        this.nomeComercial = nomeComercial;
        this.principioAtivo = principioAtivo;
        this.paraQueServe = paraQueServe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getParaQueServe() {
        return paraQueServe;
    }

    public void setParaQueServe(String paraQueServe) {
        this.paraQueServe = paraQueServe;
    }

    @Override
    public String toString() {
        return "NomeMedicamento [id=" + id + ", nomeComercial=" + nomeComercial + ", principioAtivo=" + principioAtivo
                + ", paraQueServe=" + paraQueServe + "]";
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
        NomeMedicamentos other = (NomeMedicamentos) obj;
        return Objects.equals(id, other.id);
    }
}
