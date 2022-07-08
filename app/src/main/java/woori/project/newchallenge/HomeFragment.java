package woori.project.newchallenge;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private final String bug = "bug";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView myrecyclerview;
    private Adapter_Home mAdapter_Home;
    private ArrayList<ChallengeData> list;

    //private Button challenge_btn;

    private FirebaseFirestore fire_db;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter_Home = new Adapter_Home();
        myrecyclerview = view.findViewById(R.id.recycler_view);
        myrecyclerview.setAdapter(mAdapter_Home);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        //fire_db = FirebaseFirestore.getInstance(); //Init Firestore

        list = new ArrayList<>();
        /*
        fire_db.collection("ChallengeList")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    Map<String,Object> data = new HashMap<>();

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document:task.getResult()){
                                data = document.getData();
                                Log.d("!!!!!",data.toString());
                                list.add(new ChallengeData(R.drawable.ic_baseline_person_24,data.get("TeamName").toString(),
                                        R.drawable.miracle_clock, R.drawable.ic_baseline_comment_24, data.get("ChallengeName").toString()));
                            }
//                            mAdapter_Home.setChallengelist(list);
                        }
                    }
                });
        */

        list.add(new ChallengeData(R.drawable.ic_baseline_person_24,"직원만족센터",
                R.drawable.miracle_clock, R.drawable.ic_baseline_comment_24, "미라클모닝 (기간: 7/7 ~ 7/14)"));

        list.add(new ChallengeData(R.drawable.ic_baseline_person_24,"디지털전략부",
                R.drawable.quiz_img, R.drawable.ic_baseline_comment_24, "디지털 퀴즈 (기간: 7/21 ~ 7/28)"));
        mAdapter_Home.setChallengelist((list));

//        final View temp =myrecyclerview.getChildAt(0); //.findViewById(R.id.detailviewitem_imageview_content);
//        Log.d(bug, temp.toString());

        /*
        challenge_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailActivity_miracle.class);
                startActivity(intent);
            }
        });
         */
    }
}