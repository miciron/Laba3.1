package com.gnfosst.tbs;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class dataUpdate extends AppCompatActivity {
    private DBHelper dbHelper;
    private EditText inputData;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        dbHelper = new DBHelper(this);
        inputData = findViewById(R.id.input);
    }

    public void svRec(View view){
        String Data = inputData.getText().toString().trim();

        if (!Data.isEmpty()) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DBHelper.COLUMN_FIO, Data);

            long rowID = db.insert(DBHelper.TABLE_NAME, null, values);

            if (rowID != -1) {
                setResult(RESULT_OK);
                finish();
            } else {
                setResult(RESULT_CANCELED);
                finish();
            }

            db.close();
        }
    }

}
