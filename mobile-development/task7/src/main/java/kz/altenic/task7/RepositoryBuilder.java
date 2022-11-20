package kz.altenic.task7;

import static kz.altenic.task7.HttpClient.getHTMLData;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONObject;

// СОЗДАТЕЛЬ ПОГОДЫ
public class RepositoryBuilder {

    // Получение JSON html-данных погоды по городу и языку
    private static String getRepositoryData(String owner, int page) {
        String BASE_URL = "https://api.github.com/users/" + owner + "/repos?per_page=1&sort=updated";
        String url = BASE_URL + "&page=" + page;
        return getHTMLData(url);
    }

    // Парсинг даты в формате JSON с созданием объекта погоды
    private static Repository dataParsing(String json) throws NotFoundException {
        if (json == null) throw new NotFoundException();
        Repository repository = new Repository();
        try {
            JSONArray jsonArray = new JSONArray(json);
            if (jsonArray.length() > 0) {
                JSONObject _repository = jsonArray.getJSONObject(0);
                JSONObject _owner = _repository.getJSONObject("owner");
                repository.setName(_repository.getString("name"));
                repository.setFullName(_repository.getString("full_name"));
                repository.setDescription(_repository.getString("description"));
                repository.setUrl(_repository.getString("html_url"));
                repository.setLanguage(_repository.getString("language"));
                repository.setDefaultBranch(_repository.getString("default_branch"));
                repository.setCreatedAt(_repository.getString("created_at"));
                repository.setUpdatedAt(_repository.getString("updated_at"));
                repository.setPushedAt(_repository.getString("pushed_at"));
            }
        } catch (Exception ignore) {
        }
        return repository;
    }

    // Получение готового объекта погоды по городу и языку
    public static Repository buildRepository (String owner, int page) throws NotFoundException {
        return dataParsing(getRepositoryData(owner, page));
    }
}