package com.aplication.rest.SpringBootRest.persistence.impl;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.Maker;
import com.aplication.rest.SpringBootRest.persistence.IMakerDAO;
import com.aplication.rest.SpringBootRest.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements IMakerDAO {

    /**
     * aqui en el DAO se implementa de la interface, por lo tanto todos los metodos definidos
     * se deben implementar aqui
     * para hacerlo nos traemos el repositorio donde estan las funiones a la base de datos CRUD
     * no se crearon, como hererdo de CRUDREPOSITORY podemos usar sus metodos
     */

    @Autowired
    private MakerRepository makerRepository;

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerRepository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepository.findById(id);
    }

    @Override
    public Maker save(Maker maker) {
        return makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerRepository.deleteById(id);
    }
}

