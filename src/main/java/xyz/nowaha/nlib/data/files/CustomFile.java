package xyz.nowaha.nlib.data.files;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * @author Noah Verkaik
 * This class can be extended to create custom configuration files.
 */
public abstract class CustomFile {
	
    private final File file;
    protected YamlConfiguration config;

    public CustomFile(File directory, String fileName) {
        this.file = new File(directory, fileName);
    }

    public abstract void save();
    public abstract void reload();
    public abstract void reset();

    public YamlConfiguration getConfig() {
        return config;
    }

    public File getFile() {
		return file;
	}
    
}
