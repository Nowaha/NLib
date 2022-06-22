package xyz.nowaha.nlib.data.files;

import org.bukkit.ChatColor;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Objects;

public class MessagesFile extends BasicFile {
	
    public MessagesFile(File directory, String filename) {
        super(directory, filename);
    }

    public String loadRawMessage(String path) {
        return Objects.requireNonNull(getConfig().getString(path, path));
    }

    public ArrayList<String> loadRawMessages(String path) {
        return new ArrayList<>(getConfig().getStringList(path));
    }

    public MessageBuilder loadMessage(String path) {
        return new MessageBuilder(path);
    }

    public MessageListBuilder loadMessages(String path) {
        return new MessageListBuilder(path);
    }

    public class MessageBuilder {
        private String message;

        public MessageBuilder(String path) {
            this.message = loadRawMessage(path);
        }

        public MessageBuilder color() {
            this.message = ChatColor.translateAlternateColorCodes('&', message);
            return this;
        }

        @SuppressWarnings("unchecked")
		public MessageBuilder placeholders(Entry<String, String>... placeholders) {
            for (int i = 0; i < placeholders.length; i++) {
            	Entry<String, String> placeholder = placeholders[i];
                this.message = this.message.replace(placeholder.getKey(), placeholder.getValue());
            }

            return this;
        }	

        public String build() {
            return message;
        }
    }

    public class MessageListBuilder {
        private ArrayList<String> messages;

        public MessageListBuilder(String path) {
            this.messages = loadRawMessages(path);
        }

        public MessageListBuilder color() {
            ArrayList<String> newList = new ArrayList<>();

            for (String line : messages) {
                newList.add(ChatColor.translateAlternateColorCodes('&', line));
            }

            this.messages = newList;
            return this;
        }

        @SuppressWarnings("unchecked")
		public MessageListBuilder placeholders(Entry<String, String>... placeholders) {
            ArrayList<String> newList = new ArrayList<>();

            for (String line : messages) {
                for (int i = 0; i < placeholders.length; i++) {
                	Entry<String, String> placeholder = placeholders[i];
                    line = line.replace(placeholder.getKey(), placeholder.getValue());
                }

                newList.add(ChatColor.translateAlternateColorCodes('&', line));
            }

            this.messages = newList;

            return this;
        }

        public ArrayList<String> build() {
            return messages;
        }
    }

}