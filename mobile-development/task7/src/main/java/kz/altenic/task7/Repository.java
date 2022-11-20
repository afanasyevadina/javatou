package kz.altenic.task7;

import android.graphics.Bitmap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Класс погоды
public class Repository {
    private String name;
    private String fullName;
    private String description;
    private String url;
    private String createdAt;
    private String updatedAt;
    private String pushedAt;
    private String language;
    private String defaultBranch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreatedAt() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Date.parse(createdAt));
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        try {
            return new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(updatedAt));
        } catch (ParseException e) {
            return updatedAt;
        }
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPushedAt() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Date.parse(pushedAt));
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }
}
