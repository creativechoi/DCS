package woori.project.newchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class CommunityWriting extends AppCompatActivity {
    private Button cancleButton;
    private Button registerButton;
    private FirebaseFirestore communitydb;
    private String selectedChallange;
    private EditText title;
    private EditText content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_writing);

        communitydb = FirebaseFirestore.getInstance(); //Init Firestore

        title = findViewById(R.id.community_title_tv);
        content = findViewById(R.id.community_content_tv);


        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                // 선택한 아이템
                selectedChallange = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        cancleButton = findViewById(R.id.community_cancle);

        cancleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("community",2);
                startActivity(intent);

            }
        });

        registerButton = findViewById(R.id.community_register);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                String titleText = title.getText().toString();
                String contentText = content.getText().toString();

                communitydb.collection("CommunityList")
                        .document()
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                DocumentSnapshot document = task.getResult();
                                document.getReference().set(new MyBoard(selectedChallange,titleText,contentText));

                                Log.d("DM","커뮤니티 잘 작성됨");
                                intent.putExtra("community",2);
                                startActivity(intent);
                            }
                        });

            }
        });

    }





}