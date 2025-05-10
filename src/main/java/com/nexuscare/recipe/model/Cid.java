package com.nexuscare.recipe.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "cid")
public class Cid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;

    public Cid() {
    }

    public Cid(Long id, String codigo, String descricao) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Cid [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + "]";
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
        Cid other = (Cid) obj;
        return Objects.equals(id, other.id);
    }
}
