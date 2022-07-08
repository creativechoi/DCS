package woori.project.newchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity_quiz extends AppCompatActivity {
    private Button start_quiz_btn;
    private Button cancel_miracle;

    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.quiz_detail);

        start_quiz_btn=findViewById(R.id.start_quiz_btn);
        cancel_miracle = findViewById(R.id.quiz_cancle);

        start_quiz_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity_quiz.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        cancel_miracle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity_quiz.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
