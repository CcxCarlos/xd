package com.example.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Clients {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "idFiscal")
    private String idFiscal;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "pais")
    private String pais;
    @OneToMany(mappedBy = "client")
    private List<Comptes> comptes;

    public Clients() {
    }

    public Clients(String idFiscal, String nom, String email, String pais) {
        this.idFiscal = idFiscal;
        this.nom = nom;
        this.email = email;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdFiscal() {
        return idFiscal;
    }

    public void setIdFiscal(String idFiscal) {
        this.idFiscal = idFiscal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clients clients = (Clients) o;

        if (id != clients.id) return false;
        if (nom != null ? !nom.equals(clients.nom) : clients.nom != null) return false;
        if (idFiscal != null ? !idFiscal.equals(clients.idFiscal) : clients.idFiscal != null) return false;
        if (email != null ? !email.equals(clients.email) : clients.email != null) return false;
        if (pais != null ? !pais.equals(clients.pais) : clients.pais != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (idFiscal != null ? idFiscal.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        return result;
    }

    public List<Comptes> getComptes() {
        return comptes;
    }

    public void setComptes(List<Comptes> comptes) {
        this.comptes = comptes;
    }
}
