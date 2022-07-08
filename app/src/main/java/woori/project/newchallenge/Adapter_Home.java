package woori.project.newchallenge;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Home extends RecyclerView.Adapter<Adapter_Home.ViewHolder_Home> {

    private ArrayList<ChallengeData> challengelist;
    private Context context;
    @NonNull
    @Override
    public ViewHolder_Home onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_detail,viewGroup,false);
        return new ViewHolder_Home(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Home holder, int position) {
        holder.onBind(challengelist.get(position));
    }

    @Override
    public int getItemCount() {
        return challengelist.size();
    }

    public void setChallengelist(ArrayList<ChallengeData> list)
    {
        this.challengelist=list;
        notifyDataSetChanged();
    }


    class ViewHolder_Home extends RecyclerView.ViewHolder {

        // android:id="@+id/detailviewitem_profile_image"
        // android:id="@+id/detailviewitem_profile_textview"
        // android:id="@+id/card_view"
        // android:id="@+id/detailviewitem_imageview_content"
        // android:id="@+id/detailviewitem_favorite_imageview"
        // android:id="@+id/detailviewitem_explain_textview"
        private ImageView profile_image;
        private TextView profile_textview;
        //private final CardView card_view;
        private ImageButton content_image;
        private ImageView favorite_imageview;
        private TextView explain_textview;

        public ViewHolder_Home(@NonNull View itemView) {
            super(itemView);
            profile_image = (ImageView) itemView.findViewById(R.id.detailviewitem_profile_image);
            profile_textview = (TextView)itemView.findViewById(R.id.detailviewitem_profile_textview);
            content_image = (ImageButton) itemView.findViewById(R.id.detailviewitem_imageview_content);
            content_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailActivity_miracle.class);
                    context.startActivity(intent);
                }
            });
            favorite_imageview = (ImageView) itemView.findViewById(R.id.detailviewitem_favorite_imageview);
            explain_textview = (TextView) itemView.findViewById(R.id.detailviewitem_explain_textview);
        }
        void onBind(ChallengeData challengeitem){
            //Glide.with(context).load(url).into(content_image);
            profile_image.setImageResource(challengeitem.getProfile_image());
            profile_textview.setText(challengeitem.getProfile_textview());
            content_image.setImageResource(challengeitem.getContent_image());

            favorite_imageview.setImageResource(challengeitem.getFavorite_imageview());
            explain_textview.setText(challengeitem.getExplain_textview());
        }
    }

}
