package com.example.mygmail;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygmail.model.Email;

import java.util.List;

class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {

    private final List<Email> emails;

    EmailAdapter(List<Email> emails) {
        this.emails = emails;
    }

    public List<Email> getEmails() {
        return emails;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.email_item, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        Email email = emails.get(position);
        holder.bind(email);
    }

    @Override
    public int getItemCount() {
        return emails.size();
    }

class EmailViewHolder extends RecyclerView.ViewHolder {
    TextView txtUser;
    TextView txtIcon;
    TextView txtSubject;
    TextView txtPreview;
    TextView txtDate;
    ImageView imgStar;


    EmailViewHolder(@NonNull View itemView) {
        super(itemView);
        txtUser = itemView.findViewById(R.id.txt_user);
        txtIcon = itemView.findViewById(R.id.txt_icon);
        txtSubject = itemView.findViewById(R.id.txt_subject);
        txtPreview = itemView.findViewById(R.id.txt_preview);
        txtDate = itemView.findViewById(R.id.txt_date);
        imgStar = itemView.findViewById(R.id.img_star);
    }

    void bind(Email email) {
        int hash = email.getUser().hashCode();
        txtIcon.setText(String.valueOf(email.getUser().charAt(0)));
        txtIcon.setBackground(oval(Color.rgb(hash, hash / 2, 0), txtIcon));
        txtUser.setText(email.getUser());
        txtSubject.setText(email.getSubject());
        txtPreview.setText(email.getPreview());
        txtDate.setText(email.getDate());

        txtUser.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
        txtSubject.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
        txtDate.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);

        imgStar.setImageResource(email.isStared() ? R.drawable.ic_baseline_star_24 : R.drawable.ic_baseline_star_border_24);
    }
}

    private static ShapeDrawable oval(@ColorInt int color, View view) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(view.getHeight());
        shapeDrawable.setIntrinsicWidth(view.getWidth());
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }
}
