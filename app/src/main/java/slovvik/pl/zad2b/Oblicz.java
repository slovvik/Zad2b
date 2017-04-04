package slovvik.pl.zad2b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class Oblicz extends AppCompatActivity {

    int wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oblicz);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int liczba1 = bundle.getInt("liczba1");
        int liczba2 = bundle.getInt("liczba2");
        boolean dodaj = bundle.getBoolean("dodaj");

        if (dodaj) {
            wynik = liczba1 + liczba2;
        }
        else {
            wynik = liczba1 - liczba2;
        }

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar2);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void obliczPowrot(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("wynik", String.valueOf(wynik));
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
