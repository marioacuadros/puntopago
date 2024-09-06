package com.company.puntopago.services;

import com.company.puntopago.dao.IOperadorDao;
import com.company.puntopago.dao.IVendedorDao;
import com.company.puntopago.dao.IVentaDao;
import com.company.puntopago.model.Operador;
import com.company.puntopago.model.Vendedor;
import com.company.puntopago.model.Venta;
import com.company.puntopago.response.VentaResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements IVentaService{

    @Autowired
    private IVentaDao ventaDao;

    @Autowired
    private IVendedorDao vendedorDao;

    @Autowired
    private IOperadorDao operadorDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<VentaResponseRest> search() {
        VentaResponseRest response = new VentaResponseRest();
        try{
            List<Venta> venta = (List<Venta>) ventaDao.findAll();
            response.getVentaResponse().setVenta(venta);
            response.setMetadata("Ok", "200", "Exito");
        }catch (Exception e){
            response.setMetadata("Error", "400", "Ocurrio un error");
            return new ResponseEntity<VentaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<VentaResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<VentaResponseRest> searchById(Long id) {
        VentaResponseRest response = new VentaResponseRest();
        List<Venta> list = new ArrayList<>();
        try{
            Optional<Venta> venta = ventaDao.findById(id);
            if (venta.isPresent() ){
                list.add(venta.get());
                response.getVentaResponse().setVenta(list);
                response.setMetadata("Ok", "200", "Operador encontrado");
            }else{
                response.setMetadata("Ok", "200", "Operador NO encontrado");
            }
        }catch (Exception e){
            response.setMetadata("Error", "400", "Ocurrio un error");
            return new ResponseEntity<VentaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<VentaResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<VentaResponseRest> save(Venta venta, Long idOperador, Long idVendedor) {
        VentaResponseRest response = new VentaResponseRest();
        List<Venta> list = new ArrayList<>();
        try{
            Optional<Vendedor> vendedor = vendedorDao.findById(idVendedor);
            Optional<Operador> operador = operadorDao.findById(idOperador);
            venta.setVendedor(vendedor.get());
            venta.setOperador(operador.get());
            Venta ventaSaved = ventaDao.save(venta);
            if (ventaSaved != null){
                list.add(ventaSaved);
                response.getVentaResponse().setVenta(list);
                response.setMetadata("Ok", "200", "Registro almacenado");
            }else{
                response.setMetadata("Error", "400", "Error al guardar el registro");
            }
        }catch (Exception e){
            response.setMetadata("Error", "400", "Ocurrio un error");
            return new ResponseEntity<VentaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<VentaResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<VentaResponseRest> update(Venta venta, Long id) {
        VentaResponseRest response = new VentaResponseRest();
        List<Venta> list = new ArrayList<>();
        try{
            Optional<Venta> ventaSearch = ventaDao.findById(id);
            if (ventaSearch.isPresent()) {
                ventaSearch.get().setOperador(venta.getOperador());
                Venta ventaUpdate = ventaDao.save(ventaSearch.get());
                if (ventaUpdate != null){
                    list.add(ventaUpdate);
                    response.getVentaResponse().setVenta(list);
                    response.setMetadata("Ok", "200", "Registro almacenado");
                }else{
                    response.setMetadata("Error", "400", "Error al guardar el registro");
                }
            }else{
                response.setMetadata("Error", "400", "Registro no encontrado");
            }
        }catch (Exception e){
            response.setMetadata("Error", "400", "Ocurrio un error");
            return new ResponseEntity<VentaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<VentaResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<VentaResponseRest> delete(Long id) {
        VentaResponseRest response = new VentaResponseRest();
        List<Venta> list = new ArrayList<>();
        try{
            Optional<Venta> venta = ventaDao.findById(id);
            if (venta.isPresent() ){
                list.add(venta.get());
                ventaDao.deleteById(id);
                response.getVentaResponse().setVenta(list);
                response.setMetadata("Ok", "200", "Registro eliminado");
            }else{
                response.setMetadata("Error", "400", "Error al eliminar el registro");
            }
        }catch (Exception e){
            response.setMetadata("Error", "400", "Ocurrio un error");
            return new ResponseEntity<VentaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<VentaResponseRest>(response, HttpStatus.OK);
    }
}
