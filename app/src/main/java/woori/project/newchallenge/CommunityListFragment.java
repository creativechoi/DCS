package woori.project.newchallenge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CommunityListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CommunityListFragment extends Fragment {
    //Data
    ArrayList<SampleData> sampleDataList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FloatingActionButton reg_button;

    public CommunityListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CommunityListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CommunityListFragment newInstance(String param1, String param2) {
        CommunityListFragment fragment = new CommunityListFragment();
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
        return inflater.inflate(R.layout.fragment_community_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.InitializeData();
        Context thisContext = getActivity(); // main activity context
        ListView listView = view.findViewById(R.id.community_list);
        final MyAdapter myAdapter = new MyAdapter(thisContext,sampleDataList);

        listView.setAdapter(myAdapter);

        // 버튼 컴포넌트 초기화
        reg_button = view.findViewById(R.id.reg_button);

        // 버튼 이벤트 추가
        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

// userid 를 가지고 RegisterActivity 로 이동
                Intent intent = new Intent(thisContext, CommunityWriting.class);
//                intent.putExtra("userid", userid);
                startActivity(intent);
            }
        });
    }
    public void InitializeData(){
        sampleDataList = new ArrayList<SampleData>();
        sampleDataList.add(new SampleData("제목1","내용1","1","2"));
        sampleDataList.add(new SampleData("제목2","내용2mmmmㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ","12","22"));
        sampleDataList.add(new SampleData("제목3","내용3","13","23"));
        sampleDataList.add(new SampleData("제목3","내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3","13","23"));
        sampleDataList.add(new SampleData("제목3","내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3","13","23"));
        sampleDataList.add(new SampleData("제목3","내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3","13","23"));
        sampleDataList.add(new SampleData("제목3","내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3","13","23"));
        sampleDataList.add(new SampleData("제목3","내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3","13","23"));
        sampleDataList.add(new SampleData("제목3","내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3","13","23"));
        sampleDataList.add(new SampleData("제목3","내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3","13","23"));

    }
}

class SampleData{
    private String title;
    private String content;
    private String likeNumber;
    private String commentNumber;

    public SampleData(String title, String content, String likeNumber, String commentNumber){
        this.title= title;
        this.content=content;
        this.likeNumber=likeNumber;
        this.commentNumber = commentNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCommentNumber() {
        return commentNumber;
    }

    public String getLikeNumber() {
        return likeNumber;
    }
}

class MyAdapter extends BaseAdapter{
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<SampleData> sample;
    public MyAdapter(Context context, ArrayList<SampleData> data){
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public SampleData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.community_item,null);

        TextView titleView = view.findViewById(R.id.title);
        TextView contentView = view.findViewById(R.id.content);
        TextView likeNumView = view.findViewById(R.id.like_number);
        TextView commentNumView = view.findViewById(R.id.comment_number);

        titleView.setText(sample.get(position).getTitle());
        contentView.setText(sample.get(position).getContent());
        likeNumView.setText(sample.get(position).getLikeNumber());
        commentNumView.setText(sample.get(position).getCommentNumber());

        return view;
    }

}