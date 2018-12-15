package com.app.clinic.service;

import com.app.clinic.model.entity.Admin;
import com.app.clinic.model.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Product clinicApp
 * Created by artem_000 on 12/15/2018.
 */
@Slf4j
@Component
public class AdminService {

    private final AdminRepository adminRepository;
    private final Admin mainAdmin;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
        this.mainAdmin = new Admin(-1,"Общий Пользователь");
    }

    public List<Admin> loadAdminsForComboBox() {
        List<Admin> result = new ArrayList<>();
        result.add(getMainAdmin());
        Iterable<Admin> admins = adminRepository.findAll();
        admins.forEach(result::add);
        return result;
    }

    public Admin getMainAdmin() {
        return mainAdmin;
    }
}
