package woori.project.newchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity_miracle extends AppCompatActivity {
    private Button start_challenge_btn;
    private Button cancel_miracle;

    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.miracle_detail);

        start_challenge_btn=findViewById(R.id.start_challenge_btn);
        cancel_miracle = findViewById(R.id.miracle_cancle);

        start_challenge_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity_miracle.this, AlarmActivity.class);
                startActivity(intent);
            }
        });

        cancel_miracle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity_miracle.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
