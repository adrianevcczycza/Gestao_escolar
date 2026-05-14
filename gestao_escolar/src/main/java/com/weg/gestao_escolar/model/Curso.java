package com.weg.gestao_escolar.model;

public class Curso {

    private Long id;

    private String nome, email, codigo;

    public Curso(Long id, String nome, String email, String codigo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.codigo = codigo;
    }

    public Curso(String nome, String email, String codigo) {
        this.nome = nome;
        this.email = email;
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
