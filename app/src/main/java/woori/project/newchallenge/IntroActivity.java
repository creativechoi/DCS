package woori.project.newchallenge;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import kotlinx.coroutines.android.HandlerDispatcher;

public class IntroActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
/*
    private void init(boolean delay)
    {
        if(delay)
        {
            long DELAY_MILLIS = 1500L;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startLoginActivity();
                }
            },DELAY_MILLIS);
        }
    }

    private void startLoginActivity(){
        finish();
        //ActivityOptions options = ActivityOptions.makeCustomAnimation(this, com.google.android.material.R.anim.fragment_fade_enter, com.google.android.material.R.anim.fragment_fade_exit);
        Intent intent = new Intent(IntroActivity.this, LoginActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    }
 */

}
