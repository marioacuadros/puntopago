package com.company.puntopago.services;

import com.company.puntopago.dao.IOperadorDao;
import com.company.puntopago.dao.IVendedorDao;
import com.company.puntopago.model.Operador;
import com.company.puntopago.model.Vendedor;
import com.company.puntopago.response.OperadorResponseRest;
import com.company.puntopago.response.VendedorResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendedorServiceImpl implements IVendedorService{
    @Autowired
    private IVendedorDao vendedorDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<VendedorResponseRest> search() {
        VendedorResponseRest response = new VendedorResponseRest();
        try{
            List<Vendedor> vendedor = (List<Vendedor>) vendedorDao.findAll();
            response.getVendedorResponse().setVendedor(vendedor);
            response.setMetadata("Ok", "200", "Exito");
        }catch (Exception e){
            response.setMetadata("Error", "400", "Ocurrio un error");
            return new ResponseEntity<VendedorResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<VendedorResponseRest>(response, HttpStatus.OK);
    }
}
