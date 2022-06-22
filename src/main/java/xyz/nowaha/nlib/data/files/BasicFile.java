package xyz.nowaha.nlib.data.files;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class BasicFile extends CustomFile {

    public static Plugin pluginInstance;

    private long lastReload;

    public BasicFile(File directory, String filename) {
        super(directory, filename);
    }

    public void save() {
    	try {
    		File file = this.getFile();
    		if(!file.exists())
    			file.createNewFile();
    		
            this.getConfig().save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
    	File file = this.getFile();

    	if(!file.exists()) {
            file.getParentFile().mkdirs();

    		try {
                pluginInstance.saveResource(file.getName(), false);
    		} catch (Exception ignored) {
    			try {
    				file.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    return;
                }
    		}
    	}

        this.config = YamlConfiguration.loadConfiguration(this.getFile());
        this.lastReload = System.currentTimeMillis();
    }

    public void reset() {
    	File file = this.getFile();
        if(file.exists())
        	file.delete();

        this.reload();
    }

    public long getLastReload() {
        return lastReload;
    }

    public String getName() {
        return this.getFile().getName();
    }

}
