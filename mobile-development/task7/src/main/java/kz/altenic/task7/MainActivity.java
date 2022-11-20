package kz.altenic.task7;

import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewDescription;
    private TextView textViewDefaultBranch;
    private TextView textViewLanguage;
    private TextView textViewUpdatedAt;
    private TextView searchText;
    private TextView errorText;
    private Button prevButton;
    private Button nextButton;
    private LinearLayout contentView;
    private LinearLayout errorView;
    private ProgressBar progressBar;

    private int page = 1;
    int maxPage = -1;
    private String owner = "proffix4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = findViewById(R.id.name);
        textViewDescription = findViewById(R.id.description);
        textViewDefaultBranch = findViewById(R.id.defaultBranch);
        textViewLanguage = findViewById(R.id.language);
        textViewUpdatedAt = findViewById(R.id.updatedAt);
        searchText = findViewById(R.id.searchText);
        errorText = findViewById(R.id.errorText);
        prevButton = findViewById(R.id.prev);
        nextButton = findViewById(R.id.next);
        contentView = findViewById(R.id.contentView);
        errorView = findViewById(R.id.errorView);
        progressBar = findViewById(R.id.progressBar);

        JSONRepositoryTask task = new JSONRepositoryTask(); // Создание потока определения погоды
        task.execute(owner, String.valueOf(page)); // Активация потока
        checkPage();
        searchText.setText(owner);
    }

    // Кнопка "Обновить"
    public void onRefresh(View view) {
        startLoading();
        new JSONRepositoryTask().execute(owner, String.valueOf(page)); // Создание и активация потока определения погоды
    }

    public void onSearch(View view) {
        owner = searchText.getText().toString();
        startLoading();
        new JSONRepositoryTask().execute(owner, String.valueOf(page)); // Создание и активация потока определения погоды
    }

    public void OnNextPage(View view) {
        page++;
        startLoading();
        new JSONRepositoryTask().execute(owner, String.valueOf(page)); // Создание и активация потока определения погоды
    }

    public void OnPrevPage(View view) {
        page--;
        checkPage();
        startLoading();
        new JSONRepositoryTask().execute(owner, String.valueOf(page)); // Создание и активация потока определения погоды
    }

    public void checkPage() {
        prevButton.setEnabled(page > 1);
        nextButton.setEnabled(maxPage < 0 || maxPage > page);
    }

    public void startLoading() {
        progressBar.setVisibility(View.VISIBLE);
        contentView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
    }

    private class JSONRepositoryTask extends AsyncTask<String, Void, Repository> {

        // Тут реализуем фоновую асинхронную загрузку данных, требующих много времени
        @Override
        protected Repository doInBackground(String... params) {
            try {
                return RepositoryBuilder.buildRepository(params[0], Integer.parseInt(params[1]));
            } catch (NotFoundException e) {
                progressBar.setVisibility(View.GONE);
                contentView.setVisibility(View.GONE);
                errorText.setText(R.string.error);
                errorView.setVisibility(View.VISIBLE);
            }
            return new Repository();
        }
        // ----------------------------------------------------------------------------

        // Тут реализуем что нужно сделать после окончания загрузки данных
        @Override
        protected void onPostExecute(final Repository repository) {
            super.onPostExecute(repository);

            contentView.post(new Runnable() { //  с использованием синхронизации UI
                @Override
                public void run() {
                    System.out.println(page);
                    progressBar.setVisibility(View.GONE);
                    contentView.setVisibility(View.VISIBLE);
                    errorView.setVisibility(View.GONE);
                    if (repository.getName() != null) {
                        textViewName.setText("");
                        textViewDescription.setText("");
                        textViewDefaultBranch.setText("");
                        textViewLanguage.setText("");
                        textViewUpdatedAt.setText("");
                        textViewName.setText(repository.getName());
                        if (repository.getDescription() != null && !Objects.equals(repository.getDescription(), "null")) textViewDescription.setText(repository.getDescription());
                        textViewDefaultBranch.setText(repository.getDefaultBranch());
                        if (repository.getLanguage() != null && !Objects.equals(repository.getLanguage(), "null")) textViewLanguage.setText(repository.getLanguage());
                        textViewUpdatedAt.setText(repository.getUpdatedAt());
                    } else {
                        page--;
                        maxPage = page;
                        checkPage();
                        Toast.makeText(getApplicationContext(), "На этом пока все", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
        // ------------------------------------------------------------------------------------

    }

}
