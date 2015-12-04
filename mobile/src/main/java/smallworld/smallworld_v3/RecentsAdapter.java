package smallworld.smallworld_v3;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by felixliu on 12/3/15.
 */
public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.UserViewHolder> {

    List<User> users;

    RecentsAdapter(List<User> users){
        this.users = users;

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_card, viewGroup, false);
        UserViewHolder pvh = new UserViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(UserViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(users.get(i).name);
        personViewHolder.personPhoto.setImageResource(users.get(i).photoId);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView personName;
        ImageView personPhoto;

        UserViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            Typeface tf = Typeface.createFromAsset(itemView.getContext().getAssets(),
                    "fonts/muli.ttf");
            personName.setTypeface(tf);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
            itemView.setOnClickListener(this);
        }

        // Handles the row being being clicked
        @Override
        public void onClick(View view) {
            Log.d("do", "something");
            Intent intent = new Intent(view.getContext(), ComplicatedProfile.class);
            view.getContext().startActivity(intent);
        }

    }
}
