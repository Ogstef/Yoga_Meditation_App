package acg.edu.yoga_meditation_app.activities;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Locale;
import acg.edu.yoga_meditation_app.R;

import acg.edu.yoga_meditation_app.StopwatchActivity;
import acg.edu.yoga_meditation_app.models.Person;


public class DetailActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Gson gson = new Gson();
        Person person = gson.fromJson(getIntent().getStringExtra("person"), Person.class);
        ((TextView) findViewById(R.id.name)).setText(person.getName());
        ((TextView) findViewById(R.id.surname)).setText(person.getSurname().toUpperCase());
        SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy", Locale.getDefault());
        String gender = person.getGender();
        if(gender.isEmpty()) {
            gender = getString(R.string.gender_unknown);
        }
        ((TextView) findViewById(R.id.info)).setText(String.format(getString(R.string.info), gender, sdf.format(person.getDob())));
        ((TextView) findViewById(R.id.weight)).setText(String.format(getString(R.string.weight), person.getWeight()));
        ImageView genderImage = findViewById(R.id.gender);
        switch (person.getGender()) {
            case "Male":
                genderImage.setImageResource(R.mipmap.male);
                break;
            case "Female":
                genderImage.setImageResource(R.mipmap.woman);
                break;
            default:
                genderImage.setImageResource(R.mipmap.unknown);
        }

        findViewById(R.id.display_exercises).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.stopwatch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, StopwatchActivity.class);
                startActivity(intent);
            }
        });

        Button picture = findViewById(R.id.progress_picture);
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        findViewById(R.id.email_self).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, EmailActivity.class);
                startActivity(intent);
            }
        });
    }
}