package slovvik.pl.zad2b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class Wellbeing extends AppCompatActivity {

    private int progress;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellbeing);
    }

    public void goBack(View view) {
        onBackPressed();
    }

    public void onRadioButtonClicked(View view) {
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        progress = seekBar.getProgress();
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_21:
                if (checked)
                    if (progress > 75) message = "To bardzo dobry wynik";
                    else if (progress > 50 && progress <= 75) message = "To dobry wynik";
                    else if (progress > 25 && progress <= 50) message = "To zły wynik";
                    else if (progress <= 25) message = "To bardzo zły wynik";
                break;
            case R.id.radio_31:
                if (checked)
                    if (progress > 75) message = "To bardzo dobry wynik";
                    else if (progress > 50 && progress <= 75) message = "To dobry wynik";
                    else if (progress > 25 && progress <= 50) message = "To zły wynik";
                    else if (progress <= 25) message = "To bardzo zły wynik";
                    break;
            case R.id.radio_41:
                if (checked)
                    if (progress > 75) message = "To bardzo dobry wynik";
                    else if (progress > 50 && progress <= 75) message = "To dobry wynik";
                    else if (progress > 25 && progress <= 50) message = "To zły wynik";
                    else if (progress <= 25) message = "To bardzo zły wynik";
                    break;
            case R.id.radio_51:
                if (checked)
                    if (progress > 50) message = "To bardzo dobry wynik";
                    else if (progress > 37 && progress <= 50) message = "To dobry wynik";
                    else if (progress > 25 && progress <= 37) message = "To zły wynik";
                    else if (progress <= 25) message = "To bardzo zły wynik";
                    break;
        }
    }

    public void makeToast(View view) {
        Toast.makeText(getApplicationContext()
                , message
                , Toast.LENGTH_LONG).show();
    }
}
