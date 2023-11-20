package com.nmbz.servicedev.components;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.ByteArrayInputStream;

public class ConnectToServer {
    private String user;
    private String host;
    private int port;
    private String password;
    private String remoteFilePath;
    public ConnectToServer(String user, String host, int port, String password, String remoteFilePath) {
        this.user = user;
        this.host = host;
        this.port = port;
        this.password = password;
        this.remoteFilePath = remoteFilePath;
    }
    public void startMonitoring() {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            // It is recommended to use a known hosts file
            // for security reasons.
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;

            while (true) {
                // Here, we're just using the current timestamp as the file content.
                // Replace this with your own logic.
                sftpChannel.put(new ByteArrayInputStream(Long.toString(System.currentTimeMillis()).getBytes()), remoteFilePath);

                // Adjust the sleep duration based on your needs.
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


