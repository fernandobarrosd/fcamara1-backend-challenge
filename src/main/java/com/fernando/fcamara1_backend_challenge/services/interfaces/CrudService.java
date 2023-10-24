package com.fernando.fcamara1_backend_challenge.services.interfaces;

import java.util.List;

public interface CrudService<RQ, RS> {
    void save(RQ requestDTO);
    RS findByID(Long id);

    List<RS> findAll();

    void delete(Long id);

    void update(Long id, RQ requestDTO);
}
