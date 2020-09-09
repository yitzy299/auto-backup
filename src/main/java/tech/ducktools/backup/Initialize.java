package tech.ducktools.backup;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Initialize {
    String path = "autobackup.config";

    public static void createFile(String path) throws IOException {
        FileWriter write = new FileWriter(path, true);
        PrintWriter print_line = new PrintWriter(write);
        print_line.printf( "%s" + "%n" , "ticks=1000");
        print_line.close();
    }

	public static void configSetup() {
        try{
            Initialize.createFile("autobackup.config");
        }
        catch(IOException e){		
        } 
	}
}
