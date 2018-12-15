package com.app.clinic.view;

import com.app.clinic.model.entity.Admin;
import com.app.clinic.model.enums.ButtonTitle;
import com.app.clinic.model.repository.AdminRepository;
import com.app.clinic.service.AdminService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Product clinicApp
 * Created by artem_000 on 12/15/2018.
 */
@Slf4j
@Component
public class LoginFrame {

    private final AdminService adminService;
    private Stage stage;

    @Autowired
    public LoginFrame(AdminService adminService) {
        this.adminService = adminService;
    }

    public void startFrame(Stage primaryStage) {
        log.info("--------------------Starting LoginFrame--------------------");
        setUpStage(primaryStage);
        primaryStage.show();
    }

    private void setUpStage(Stage primaryStage) {
        this.stage = primaryStage;
        try {
            ComboBox<String> adminComboBox = createAminDropBox();
            Button loginButton = createLoginButton();
            Button cancelButton = createCancelButton();
            HBox buttons = layoutNodes(adminComboBox, loginButton, cancelButton);


            VBox vBox = new VBox();

            HBox comboBoxHBox = new HBox();
            HBox buttonsHBox = new HBox();



            comboBoxHBox.getChildren().add(adminComboBox);
//            comboBoxHBox.getChildren().add(loginButton);
//            comboBoxHBox.getChildren().add(cancelButton);

            vBox.getChildren().add(comboBoxHBox);
            vBox.getChildren().add(buttons);

            stage.setTitle("Hello World!");

            StackPane root = new StackPane();
            root.getChildren().add(vBox);
            root.setPadding(new Insets(20,20,20,20));
            Scene scene = new Scene(root, 500, 350);
            scene.setFill(Color.BLUE);
            scene.setOnMouseClicked(event -> System.out.println("mouse clicked"));
            stage.setScene(scene);

        } catch (Exception ex) {
            log.error("Error setting up login frame", ex);
            throw ex;
        }






    }

    private HBox layoutNodes(ComboBox<String> adminComboBox, Button loginButton, Button cancelButton) {
        HBox buttonsHBox = new HBox();
        buttonsHBox.getChildren().add(loginButton);
        buttonsHBox.getChildren().add(cancelButton);
        buttonsHBox.setPadding(new Insets(20,20,20,20));
        return buttonsHBox;
    }

    private void startMainFrame() {

    }

    private Button createCancelButton() {
        Button button = new Button();
        button.setText(ButtonTitle.CANCEL.getTitle());
        button.setOnAction(event -> {
            stage.close();
        });
        return button;
    }

    private Button createLoginButton() {
        Button button = new Button();
        button.setText(ButtonTitle.LOGIN.getTitle());
        button.setOnAction(event -> {
            startMainFrame();
        });
        return button;
    }

    private ComboBox<String> createAminDropBox() {
        ComboBox<String> comboBox = new ComboBox<>();
        List<Admin> admins = adminService.loadAdminsForComboBox();
        admins.forEach(admin -> {
            comboBox.getItems().add(admin.getFio());
        });
        return comboBox;
    }

    public String checkRepository(AdminRepository adminRepository) {
        Iterable<Admin> all = adminRepository.findAll();
        all.forEach(admin -> {
            System.out.println("Admin: " + admin);
        });
        Admin admin1 = new Admin();
        admin1.setFio("Fio 8");
        adminRepository.save(admin1);

        Admin admin2 = new Admin();
        admin2.setFio("Fio 9");
        adminRepository.save(admin2);


        Admin admin3 = new Admin();
        admin3.setFio("Fio 10");
        adminRepository.save(admin3);

        Admin admin4 = new Admin();
        admin4.setFio("Fio 11");
        adminRepository.save(admin4);

        return "checkRepository";
    }
}
