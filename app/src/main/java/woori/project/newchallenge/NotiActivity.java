package woori.project.newchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotiActivity extends AppCompatActivity {
    private Button reward_confirm_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);

        reward_confirm_btn=findViewById(R.id.noti_confirm);
        reward_confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotiActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
