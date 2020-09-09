package tech.ducktools.backup;

import net.fabricmc.api.ModInitializer;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner; 

import tech.ducktools.backup.TakeBackup;

import net.fabricmc.fabric.api.event.server.ServerTickCallback;
import net.fabricmc.fabric.api.event.server.ServerStartCallback;

public class AutoBackup implements ModInitializer {
	@Override
	public void onInitialize() {
		int configLine = 1;
		int readLine = 0;
		int configInt;
		try {
			File myObj = new File("autobackup.config");
			Scanner configRead = new Scanner(myObj);
			while (configRead.hasNextLine()) {
				//update line counter
				readLine++;
				String data = configRead.nextLine();
				//load tick amount
				if(readLine==1){
					String configString = data.replaceFirst("ticks=", "      ");
					configString = configString.trim();
					configInt = Integer.parseInt(configString);
					TakeBackup.saveTickValue(configInt);
					System.out.println("Loaded autobackup.config option ticks, proceeding");
				}
				//load world folder
				if(readLine==2){
					String configString = data.replaceFirst("world=", "      ");
					configString = configString.trim();
					
					System.out.println("Loaded autobackup.config option ticks, proceeding");
				}
			}
			configRead.close();
		  }
		   catch (FileNotFoundException e) {
				System.out.println("Config file not found, creating one. For config file info, see the github page at https://github.com/yitzy299/auto-backup");
				Initialize.configSetup();
			}
		System.out.println("Auto-Backup by Ducktools initialized");
		//call backup checker every tick

	}
}
