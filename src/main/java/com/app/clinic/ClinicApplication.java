package com.app.clinic;

import com.app.clinic.view.LoginFrame;
import javafx.application.Application;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Product clinicApp
 * Created by artem_000 on 12/12/2018.
 */
@Slf4j
@SpringBootApplication
public class ClinicApplication extends Application {

    private ConfigurableApplicationContext context;

    public static void main(String[] args) {
        log.info("========================================Starting Application========================================");
        try {
            launch(args);
        } catch (Exception ex) {
            log.error("Error starting application", ex);
            throw ex;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        this.context = SpringApplication.run(ClinicApplication.class);
        context.getBean(LoginFrame.class).startFrame(primaryStage);
        log.info("========================================Application running========================================");
    }

    @Override
    public void stop() throws Exception {
        log.info("========================================Stopping Application========================================");
        super.stop();
        log.info("========================================Application stopped========================================");
    }
}
