package slovvik.pl.app2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    @Override
//    protected void onRestar() {
//        super.onResume();
//
//    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext()
                , "Znowu jestem"
                , Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext()
                , "Jeszcze tu wróce"
                , Toast.LENGTH_LONG).show();
    }

    public void appOne(View view) {
        Intent intent = new Intent("slovvik.pl.zad2b.ANOTHER_ACTIVITY");
        startActivity(intent);
    }

    public void call(View view) {
        Uri number = Uri.parse("tel:5551234");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void web(View view) {
        Uri webpage = Uri.parse("http://www.google.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }

    public void gallery(View view) {
        Uri gallery = Uri.parse("content://media/internal/images/media");
        Intent intent = new Intent(Intent.ACTION_VIEW, gallery);
        startActivity(intent);
    }
}
