package slovvik.pl.zad2b;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Kalkulator extends AppCompatActivity {

    boolean dodaj;
    boolean odejmij;
    boolean czyOgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);
    }

    public void oblicz(View view) {
        Intent intent = new Intent(this, Oblicz.class);
        Bundle bundle = new Bundle();
        bundle.putInt("liczba1", Integer.valueOf(((EditText) findViewById(R.id.liczba1)).getText().toString()));
        bundle.putInt("liczba2", Integer.valueOf(((EditText) findViewById(R.id.liczba2)).getText().toString()));
        bundle.putBoolean("dodaj", this.dodaj);
        bundle.putBoolean("odejmij", this.odejmij);
        bundle.putBoolean("czyOgr", this.czyOgr);
        intent.putExtras(bundle);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            Bundle bundle = data.getExtras();
            String wynik = bundle.getString("wynik");
            TextView textView = (TextView) findViewById(R.id.tvOblicz);
            textView.setText(wynik);
        }
    }

    public void czyOgr(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        if (checkBox.isChecked()) czyOgr = true;
        else czyOgr = false;
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.dodaj:
                if (checked)
                    this.dodaj = true;
                this.odejmij = false;
                break;
            case R.id.odejmij:
                if (checked)
                    this.dodaj = false;
                this.odejmij = true;
                break;

        }
    }

}

