package slovvik.pl.zad2b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void introduceYourself(View view) {
        Intent intent = new Intent(this, IntroduceYourself.class);
        startActivity(intent);
    }

    public void wellBeing(View view) {
        Intent intent = new Intent(this, Wellbeing.class);
        startActivity(intent);
    }

    public void kalkulator(View view) {
        Intent intent = new Intent(this, Kalkulator.class);
        startActivity(intent);
    }
}
