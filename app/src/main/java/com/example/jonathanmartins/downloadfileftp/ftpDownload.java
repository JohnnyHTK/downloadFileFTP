package com.example.jonathanmartins.downloadfileftp;

import org.apache.commons.net.ftp.FTPClient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by jonathan.martins on 23/02/2018.
 */

public class ftpDownload {
    public static void main(String[] args) {
        // The local filename and remote filename to be downloaded.
        String filename = "images.jpeg";

        FTPClient client = new FTPClient();
        try (OutputStream os = new FileOutputStream(filename)) {
            client.connect("f19-preview.awardspace.net");
            client.login("2630818_jonathan", "Controle5");

            // Download file from FTP server.
            boolean status = client.retrieveFile(filename, os);
            System.out.println("status = " + status);
            System.out.println("reply  = " + client.getReplyString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
