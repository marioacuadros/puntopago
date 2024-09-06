package com.company.puntopago.services;

import com.company.puntopago.dao.IOperadorDao;
import com.company.puntopago.model.Operador;
import com.company.puntopago.response.OperadorResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperadorServiceImpl implements IOperadorService {

    @Autowired
    private IOperadorDao operadorDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<OperadorResponseRest> search() {
        OperadorResponseRest response = new OperadorResponseRest();
        try{
            List<Operador> operador = (List<Operador>) operadorDao.findAll();
            response.getOperadorResponse().setOperador(operador);
            response.setMetadata("Ok", "200", "Exito");
        }catch (Exception e){
            response.setMetadata("Error", "400", "Ocurrio un error");
            return new ResponseEntity<OperadorResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<OperadorResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<OperadorResponseRest> searchById(Long id) {
        OperadorResponseRest response = new OperadorResponseRest();
        List<Operador> list = new ArrayList<>();
        try{
            Optional<Operador> operador = operadorDao.findById(id);
            if (operador.isPresent() ){
                list.add(operador.get());
                response.getOperadorResponse().setOperador(list);
                response.setMetadata("Ok", "200", "Operador encontrado");
            }else{
                response.setMetadata("Ok", "200", "Operador NO encontrado");
            }
        }catch (Exception e){
            response.setMetadata("Error", "400", "Ocurrio un error");
            return new ResponseEntity<OperadorResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<OperadorResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<OperadorResponseRest> save(Operador operador) {
        OperadorResponseRest response = new OperadorResponseRest();
        List<Operador> list = new ArrayList<>();
        try{
            Operador operadorSaved = operadorDao.save(operador);
            if (operadorSaved != null){
                list.add(operadorSaved);
                response.getOperadorResponse().setOperador(list);
                response.setMetadata("Ok", "200", "Registro almacenado");
            }else{
                response.setMetadata("Error", "400", "Error al guardar el registro");
            }
        }catch (Exception e){
            response.setMetadata("Error", "400", "Ocurrio un error");
            return new ResponseEntity<OperadorResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<OperadorResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<OperadorResponseRest> update(Operador operador, Long id) {
        OperadorResponseRest response = new OperadorResponseRest();
        List<Operador> list = new ArrayList<>();
        try{
            Optional<Operador> operadorSearch = operadorDao.findById(id);
            if (operadorSearch.isPresent()) {
                operadorSearch.get().setOperador(operador.getOperador());
                Operador operadorUpdate = operadorDao.save(operadorSearch.get());
                if (operadorUpdate != null){
                    list.add(operadorUpdate);
                    response.getOperadorResponse().setOperador(list);
                    response.setMetadata("Ok", "200", "Registro almacenado");
                }else{
                    response.setMetadata("Error", "400", "Error al guardar el registro");
                }
            }else{
                response.setMetadata("Error", "400", "Registro no encontrado");
            }
        }catch (Exception e){
            response.setMetadata("Error", "400", "Ocurrio un error");
            return new ResponseEntity<OperadorResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<OperadorResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<OperadorResponseRest> delete(Long id) {
        OperadorResponseRest response = new OperadorResponseRest();
        List<Operador> list = new ArrayList<>();
        try{
            Optional<Operador> operador = operadorDao.findById(id);
            if (operador.isPresent() ){
                list.add(operador.get());
                operadorDao.deleteById(id);
                response.getOperadorResponse().setOperador(list);
                response.setMetadata("Ok", "200", "Registro eliminado");
            }else{
                response.setMetadata("Error", "400", "Error al eliminar el registro");
            }
        }catch (Exception e){
            response.setMetadata("Error", "400", "Ocurrio un error");
            return new ResponseEntity<OperadorResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<OperadorResponseRest>(response, HttpStatus.OK);
    }
}
