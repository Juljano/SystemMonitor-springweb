package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
@RestController
public class Main {

    private static SensorStateData sensorStateData;

    /**
     * check if a connection is available to google.de
     * then yes, springweb is started
     */
    public Boolean CheckConnection() {
        try {

            URL url = new URL("https://www.google.de/");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            return true;

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }


    @GetMapping("/index")
    public String setValuesInHtml(Model model) {
        if (sensorStateData == null) {

            sensorStateData = new SensorStateData();
        }

        model.addAttribute("values" + sensorStateData);
        return "index";
    }


    public static void main(String[] args) {

        Main main = new Main();
        if (!main.CheckConnection()) {

            System.out.println("No connection available, please try it again!");

            return;

        }


        SpringApplication.run(Main.class, args);
        SensorState sensorState = new SensorState();
        sensorState.getHardwareState();
        sensorState.getDiskInfo();
        sensorState.getOperationSystemInfo();
        sensorState.getNetworkInfo();

    }

}