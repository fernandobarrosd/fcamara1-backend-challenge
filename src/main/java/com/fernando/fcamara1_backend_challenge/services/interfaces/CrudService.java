package com.fernando.fcamara1_backend_challenge.services.interfaces;

public interface CrudService<RQ, RS> {
    void save(RQ requestDTO);
    RS findByID(Long id);

    void delete(Long id);

    void update(Long id, RQ requestDTO);
}
