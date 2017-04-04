package slovvik.pl.zad2b;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IntroduceYourself extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_yourself);
    }

    public void goBack(View view) {
        onBackPressed();
    }

    public void makeToast(View view) {
        String name = ((EditText) findViewById(R.id.name)).getText().toString();
        String surname = ((EditText) findViewById(R.id.surname)).getText().toString();
        if (name.equals("") || surname.equals("")) Toast.makeText(getApplicationContext()
                , "Nie podałeś imienia lub nazwiska"
                , Toast.LENGTH_LONG).show();
        else Toast.makeText(getApplicationContext()
                , "Twoje imię i nazwisko to: " + name + " " + surname
                , Toast.LENGTH_LONG).show();
    }

    public void sendData(View view) {
        Intent intent = new Intent(this, ReceiveData.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", ((EditText) findViewById(R.id.name)).getText().toString());
        bundle.putString("surname", ((EditText) findViewById(R.id.surname)).getText().toString());
        intent.putExtras(bundle);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            Bundle bundle = data.getExtras();
            String name = bundle.getString("name");
            String surname = bundle.getString("surname");
            TextView textView = (TextView) findViewById(R.id.received_name_surname);
            textView.setText(name + " " + surname);
        }

    }
}
