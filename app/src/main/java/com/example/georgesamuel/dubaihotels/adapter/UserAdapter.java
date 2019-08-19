package com.example.georgesamuel.dubaihotels.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.paging.model.User;

public class UserAdapter extends PagedListAdapter<User, UserAdapter.UserViewHolder> {
    private Context context;
    private static final String TAG = UserAdapter.class.getSimpleName();

    public UserAdapter(Context context) {
        super(User.CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);
        User user = getItem(position);
        Glide.with(context)
                .load(user.getAvatar())
                .into(holder.profile);
        holder.tvName.setText(user.getFirstName() + ' ' + user.getLastName());
        holder.tvEmail.setText(user.getEmail());
        Log.d(TAG, "onBindViewHolder");
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView profile;
        private TextView tvName;
        private TextView tvEmail;
        private LinearLayout container;

        public UserViewHolder(View view) {
            super(view);
            profile = view.findViewById(R.id.ivUserProfile);
            tvName = view.findViewById(R.id.tvName);
            tvEmail = view.findViewById(R.id.tvEmail);
            container = view.findViewById(R.id.container);
        }
    }
}
