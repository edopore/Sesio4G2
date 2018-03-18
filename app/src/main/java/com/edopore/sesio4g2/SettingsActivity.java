package com.edopore.sesio4g2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {
    EditText eProyecto, eAvance, ePractica;
    Button bGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        eProyecto = findViewById(R.id.ePracticas);
        eAvance = findViewById(R.id.eAvances);
        ePractica = findViewById(R.id.eFinal);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            eAvance.setText(String.valueOf(extras.getInt("lab")));
            eProyecto.setText(String.valueOf(extras.getInt("proy")));
            ePractica.setText(String.valueOf(extras.getInt("avance")));
        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        finish();
        super.onBackPressed();
    }

    public void onButtonClicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("proy",Integer.parseInt(eProyecto.getText().toString()));
        intent.putExtra("lab",Integer.parseInt(eAvance.getText().toString()));
        intent.putExtra("avance",Integer.parseInt(ePractica.getText().toString()));
    }
}
