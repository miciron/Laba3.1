package com.gnfosst.tbs;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dataView extends AppCompatActivity {
    private DBHelper dbHelper;
    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        dbHelper = new DBHelper(this);
        displayText = findViewById(R.id.text);

        dataDisplay();
    }

    private void dataDisplay() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBHelper.TABLE_NAME, null);

        StringBuilder stringBuilder = new StringBuilder();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ID2));
            String fio = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_FIO2));
            String timestamp = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TIME2));

            stringBuilder.append("ID: ").append(id)
                    .append(", ФИО: ").append(fio)
                    .append(", Дата создания: ").append(timestamp)
                    .append("\n");
        }

        cursor.close();
        db.close();

        displayText.setText(stringBuilder.toString());
    }

}
