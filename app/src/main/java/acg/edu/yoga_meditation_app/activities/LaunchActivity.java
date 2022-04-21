package acg.edu.yoga_meditation_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import acg.edu.yoga_meditation_app.R;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ImageView yogi = findViewById(R.id.yogi);
        Button start = findViewById(R.id.get_started);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("Before calling list intent");

                Intent intentlist = new Intent(LaunchActivity.this, ShowPeopleActivity.class);
                startActivity(intentlist);
            }
        });
    }
}


