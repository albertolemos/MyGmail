package com.example.mygmail;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygmail.model.Email;
import com.example.mygmail.model.Emails;
import com.mooveit.library.Fakeit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EmailAdapter emailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fakeit.init();
        setContentView(R.layout.activity_main);

        emailAdapter = new EmailAdapter(new ArrayList<>(Emails.fakeEmails()));
        final RecyclerView recyclerView = findViewById(R.id.recycler_view_main);
        recyclerView.setAdapter(emailAdapter);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEmail();
                recyclerView.scrollToPosition(0);
            }
        });

        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHandler(0,
                        ItemTouchHelper.LEFT)
        );

        helper.attachToRecyclerView(recyclerView);
    }

    private class ItemTouchHandler extends ItemTouchHelper.SimpleCallback {
        public ItemTouchHandler(int dragDirs, int swipeDirs) {
            super(dragDirs, swipeDirs);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int from = viewHolder.getAdapterPosition();
            int to = target.getAdapterPosition();

            Collections.swap(emailAdapter.getEmails(), from, to);
            emailAdapter.notifyItemMoved(from, to);
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            emailAdapter.getEmails().remove(viewHolder.getAdapterPosition());
            emailAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
        }
    }

    private void addEmail() {
        try {
            Date sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR")).parse(
                    Fakeit.dateTime().dateFormatter()
            );

            StringBuilder preview = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                preview.append(Fakeit.lorem().words());
                preview.append(" ");
            }

            emailAdapter.getEmails().add(0, Email.EmailBuilder.builder()
                    .setStared(false)
                    .setUnread(true)
                    .setUser(Fakeit.name().firstName())
                    .setSubject(Fakeit.company().name())
                    .setDate(new SimpleDateFormat("d MMM",
                            new Locale("pt", "BR")).format(sdf))
                    .setPreview(preview.toString())
                    .build()
            );
        } catch (ParseException e) {}

        emailAdapter.notifyItemInserted(0);
    }
}