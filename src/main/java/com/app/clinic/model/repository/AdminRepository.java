package com.app.clinic.model.repository;

import com.app.clinic.model.entity.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 * Product clinicApp
 * Created by artem_000 on 12/15/2018.
 */

public interface AdminRepository extends CrudRepository<Admin, Long> {
}
