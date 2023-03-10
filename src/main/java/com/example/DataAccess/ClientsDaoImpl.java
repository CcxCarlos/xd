package com.example.DataAccess;

import com.example.Model.Clients;

import java.util.List;

public class ClientsDaoImpl extends Dao implements ClientsDao{

    @Override
    public Clients getClientByIdFiscal(int idFiscal) {
        return getValues(executeQuery(Querys.CLIENTS_BY_ID_FISCAL, Querys.getParameter(Querys.CLIENTS_BY_ID_FISCAL), String.valueOf(idFiscal), Clients.class)).get(0);
    }

    @Override
    public Clients getClientByCuenta(String cuenta) {
        return getValues(executeQuery(Querys.CLIENT_BY_CUENTA, Querys.getParameter(Querys.CLIENT_BY_CUENTA), cuenta, Clients.class)).get(0);
    }

    @Override
    public List<Clients> getAllClients() {
        return getValues(executeQuery(Querys.ALL_CLIENTS, Clients.class));
    }

    @Override
    public List<Clients> getClientsByEmail(String email) {
        return getValues(executeQuery(Querys.CLIENTS_BY_EMAIL, Querys.getParameter(Querys.CLIENTS_BY_EMAIL), email, Clients.class));
    }

    @Override
    public List<Clients> getClientsByNombre(String name) {
        return getValues(executeQuery(Querys.CLIENTS_BY_NAME, Querys.getParameter(Querys.CLIENTS_BY_NAME),name, Clients.class));
    }

    @Override
    public List<Clients> getClientsByPais(String pais) {
        return getValues(executeQuery(Querys.CLIENTS_BY_PAIS, Querys.getParameter(Querys.CLIENTS_BY_PAIS), pais, Clients.class));
    }
}
