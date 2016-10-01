package ru.alepadesign.hobbitcalck;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WoodPage extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_length, edt_width, edt_thickness;
    private double str_length, str_width, str_thickness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wood_page);

        setTitle("Рассчет количества досок");

        edt_length = (EditText) findViewById(R.id.edt_length);
        edt_width = (EditText) findViewById(R.id.edt_width);
        edt_thickness = (EditText) findViewById(R.id.edt_thickness);
        Button btn_calculate = (Button) findViewById(R.id.btn_calculate);

        btn_calculate.setOnClickListener(this);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getValues() {
        str_length = Integer.parseInt(edt_length.getText().toString());
        str_width = Integer.parseInt(edt_width.getText().toString());
        str_thickness = Integer.parseInt(edt_thickness.getText().toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_calculate:
                getValues();
                str_thickness = str_thickness / 1000;
                str_width = str_width / 1000;
                double cube_metr = str_length * str_width * str_thickness;
                double last = 1 / cube_metr;
                showAlertDialog(last);
                break;

        }
    }

    private void showAlertDialog(double cube_metr) {
        new AlertDialog.Builder(this)
                .setTitle("Количество досок в одном куб/м")
                .setMessage("Досок: " + cube_metr)
                .show();

    }


}
