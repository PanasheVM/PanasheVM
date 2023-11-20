package com.nmbz.servicedev;

import com.nmbz.servicedev.components.ConnectToServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class ServicedevApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicedevApplication.class, args);
        String user = "panashem";
        String host = "127.0.0.1";
        int port = 22;
        String password = "Pvm@8941";
        String remoteFilePath = "/home/panashem/";

        ConnectToServer connectToServer = new ConnectToServer(user, host, port, password, remoteFilePath);
        connectToServer.startMonitoring();
    }

}
