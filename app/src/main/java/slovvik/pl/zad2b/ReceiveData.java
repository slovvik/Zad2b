package slovvik.pl.zad2b;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiveData extends AppCompatActivity {

    private Intent data;
    private String name;
    private String surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);

        data = getIntent();
        Bundle bundle = data.getExtras();
        name = bundle.getString("name");
        surname = bundle.getString("surname");
        TextView textView = (TextView) findViewById(R.id.name_surname);
        textView.setText("Twoje imię i nazwisko to:");
        TextView tvName = (TextView) findViewById(R.id.yourName);
        TextView tvSurname = (TextView) findViewById(R.id.yourSurname);
        tvName.setText(name);
        tvSurname.setText(surname);
    }

    public void goBack(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("name", name.toUpperCase());
        returnIntent.putExtra("surname", surname.toUpperCase());
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    public void makeToast(View view) {
        if (name.equals("") || surname.equals("")) Toast.makeText(getApplicationContext()
                , "Pobrane wartości są puste"
                , Toast.LENGTH_LONG).show();
        else Toast.makeText(getApplicationContext()
                , "Twoje imię i nazwisko to: " + name + " " + surname
                , Toast.LENGTH_LONG).show();
    }
}
