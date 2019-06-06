package com.example.homework332;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        final Spinner languages = findViewById(R.id.languages);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languages.setAdapter(adapter);

        final Spinner indent = findViewById(R.id.indent);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.indent, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        indent.setAdapter(adapter);

        final Button apply = findViewById(R.id.apply);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indent.getSelectedItem().toString().equals(getResources().getString(R.string.small))) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_SMALL);
                }
                if (indent.getSelectedItem().toString().equals(getResources().getString(R.string.average))) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_AVERAGE);
                }
                if (indent.getSelectedItem().toString().equals(getResources().getString(R.string.big))) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_BIG);
                }
                if (languages.getSelectedItem().toString().equals(getResources().getString(R.string.english))) {
                    Locale locale = new Locale("en");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                } else if (languages.getSelectedItem().toString().equals(getResources().getString(R.string.russian))) {
                    Locale locale = new Locale("ru");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }
            }
        });
    }
}
