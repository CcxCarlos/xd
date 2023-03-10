package com.example.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@AttributeOverride(name = "idClient", column = @Column(name = "id_client", insertable = false, updatable = false))
public class Comptes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nCuenta")
    private String nCuenta;
    @Basic
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Basic
    @Column(name = "id_client")
    private int idClient;
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    private Clients client;

    public Comptes() {
    }

    public Comptes(String nCuenta, BigDecimal saldo) {
        this.nCuenta = nCuenta;
        this.saldo = saldo;
        this.idClient = 6;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comptes comptes = (Comptes) o;

        if (id != comptes.id) return false;
        if (idClient != comptes.idClient) return false;
        if (nCuenta != null ? !nCuenta.equals(comptes.nCuenta) : comptes.nCuenta != null) return false;
        if (saldo != null ? !saldo.equals(comptes.saldo) : comptes.saldo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nCuenta != null ? nCuenta.hashCode() : 0);
        result = 31 * result + (saldo != null ? saldo.hashCode() : 0);
        result = 31 * result + idClient;
        return result;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }
}
