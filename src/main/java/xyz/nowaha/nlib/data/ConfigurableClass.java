package xyz.nowaha.nlib.data;

import org.bukkit.configuration.file.FileConfiguration;
import xyz.nowaha.nlib.utils.Coloring;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class ConfigurableClass {

    private FileConfiguration file;
    private String prefix;

    public ConfigurableClass(FileConfiguration file, String prefix) {
        this.file = file;
        this.prefix = prefix;
    }

    public void saveAndLoad() {
        var applicablePrefix = prefix.length() > 0 ? (prefix + ".") : "";

        try {
            Iterator<Field> iterator = Arrays.stream(this.getClass().getDeclaredFields()).iterator();
            while (iterator.hasNext()) {
                Field field = iterator.next();

                if (!Modifier.isStatic(field.getModifiers()) || !Modifier.isPublic(field.getModifiers()))
                    continue;

                String fieldAsPath = applicablePrefix + field.getName().toLowerCase().replace("__", ".");

                if (!file.isSet(fieldAsPath)) {
                    Object toSave = field.get(null);
                    if (toSave instanceof String) {
                        file.set(fieldAsPath, toSave.toString().replace("\u00a7", "&"));
                    } else {
                        file.set(fieldAsPath, toSave);
                    }
                } else {
                    Object saved = file.get(fieldAsPath);
                    if (saved instanceof String) {
                        field.set(null, Coloring.color(Objects.requireNonNull((String) saved)));
                    } else {
                        field.set(null, saved);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
