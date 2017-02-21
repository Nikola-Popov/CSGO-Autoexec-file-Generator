package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {
    BufferedWriter writer = null;

    public FileOutput(String toWrite) throws IOException {
        try {

            writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "/Desktop/autoexec.cfg"));
            writer.write(toWrite);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
