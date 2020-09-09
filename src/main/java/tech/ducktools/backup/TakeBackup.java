package tech.ducktools.backup;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import tech.ducktools.backup.Initialize;

import org.apache.commons.io.FileUtils;

import java.io.IOException;

public class TakeBackup {
    private static int ticksPassed;
    private static int tickCount;
    private static File world;
    private static File dest;

    public static void saveTickValue(int tickValue) {
        tickCount = tickValue;
    }
    public static void saveWorldValue(String worldPath){
       File world = new File(worldPath);
    }
    public static void saveDestinationValue(String destPath){
        File dest = new File(destPath);
     }
    public static void increaseTickCount() {
        ticksPassed = ticksPassed + 1;
        if(ticksPassed > tickCount){
            save();
        }
    }
    public static void save() {
        try{
            FileUtils.copyDirectory(world, dest);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
