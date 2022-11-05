package kz.altenic.task6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MySQLite extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2; // НОМЕР ВЕРСИИ БАЗЫ ДАННЫХ И ТАБЛИЦ !

    static final String DATABASE_NAME = "notebooks"; // Имя базы данных

    static final String TABLE_NAME = "notebooks"; // Имя таблицы
    static final String ID = "id"; // Поле с ID
    static final String NAME = "name";
    static final String PAGES = "pages";
    static final String IMAGE = "image";
    static final String LINK = "link";
    static final String ARTICUL = "articul";

    static final String ASSETS_FILE_NAME = "notebooks.txt"; // Имя файла из ресурсов с данными для БД
    static final String DATA_SEPARATOR = "|"; // Разделитель данных в файле ресурсов с телефонами

    private Context context; // Контекст приложения

    public MySQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    // Метод создания базы данных и таблиц в ней
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTEBOOKS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY,"
                + NAME + " TEXT,"
                + ARTICUL + " TEXT,"
                + PAGES + " INTEGER,"
                + IMAGE + " TEXT,"
                + LINK + " TEXT" + ")";
        db.execSQL(CREATE_NOTEBOOKS_TABLE);
        loadDataFromAsset(context, ASSETS_FILE_NAME,  db);
    }

    // Метод при обновлении структуры базы данных и/или таблиц в ней
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Добавление нового контакта в БД
    public void addData(SQLiteDatabase db, String name, String articul, int pages, String image, String link) {
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(ARTICUL, articul);
        values.put(PAGES, pages);
        values.put(IMAGE, image);
        values.put(LINK, link);
        db.insert(TABLE_NAME, null, values);
    }

    // Добавление записей в базу данных из файла ресурсов
    public void loadDataFromAsset(Context context, String fileName, SQLiteDatabase db) {
        BufferedReader in = null;

        try {
            // Открываем поток для работы с файлом с исходными данными
            InputStream is = context.getAssets().open(fileName);
            // Открываем буфер обмена для потока работы с файлом с исходными данными
            in = new BufferedReader(new InputStreamReader(is));

            String str;
            while ((str = in.readLine()) != null) { // Читаем строку из файла
                String strTrim = str.trim(); // Убираем у строки пробелы с концов
                if (!strTrim.equals("")) { // Если строка не пустая, то
                    StringTokenizer st = new StringTokenizer(strTrim, DATA_SEPARATOR); // Нарезаем ее на части
                    String articul = st.nextToken().trim();
                    String name = st.nextToken().trim();
                    int pages = Integer.parseInt(st.nextToken().trim());
                    String image = st.nextToken().trim();
                    String link = st.nextToken().trim();
                    addData(db, name, articul, pages, image, link);
                }
            }

        // Обработчики ошибок
        } catch (IOException ignored) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ignored) {
                }
            }
        }

    }

    // Получение значений данных из БД в виде строки с фильтром
    public String getData(String filter) {

        String selectQuery; // Переменная для SQL-запроса

        selectQuery = "SELECT  * FROM " + TABLE_NAME + " WHERE (" + NAME + " LIKE '%" +
                filter.toLowerCase() + "%' OR " + ARTICUL + " LIKE '%" +
                filter.toLowerCase() + "%'" + ") ORDER BY " + NAME;
        SQLiteDatabase db = this.getReadableDatabase(); // Доступ к БД
        Cursor cursor = db.rawQuery(selectQuery, null); // Выполнение SQL-запроса

        StringBuilder data = new StringBuilder(); // Переменная для формирования данных из запроса

        if (cursor.moveToFirst()) { // Если есть хоть одна запись, то
            do { // Цикл по всем записям результата запроса
                String name = cursor.getString(1); // Чтение названия организации
                String articul = cursor.getString(2);
                String pages = cursor.getString(3);
                String image = cursor.getString(4);
                String link = cursor.getString(5);
                data.append("<div class=\"item\"><div class=\"img\"><img src=\"" + image + "\" alt=\"\"/></div><div class=\"text\"><h4>" + name + "</h4><small>" + articul + " | " + pages + " листов</small><br><br><a href=\"" + link + "\">Купить</a></div></div>");
            } while (cursor.moveToNext()); // Цикл пока есть следующая запись
        }
        return data.toString(); // Возвращение результата
    }

}