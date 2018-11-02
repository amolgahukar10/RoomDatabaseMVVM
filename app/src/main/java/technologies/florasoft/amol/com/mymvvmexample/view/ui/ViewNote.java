package technologies.florasoft.amol.com.mymvvmexample.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import technologies.florasoft.amol.com.mymvvmexample.R;
import technologies.florasoft.amol.com.mymvvmexample.database.model.Note;
import technologies.florasoft.amol.com.mymvvmexample.view.adapter.NoteAdapter;
import technologies.florasoft.amol.com.mymvvmexample.viewmodel.NoteViewModwl;

public class ViewNote extends AppCompatActivity {

    private FloatingActionButton saveNote;
    private RecyclerView noteRecyclerView;
    private NoteViewModwl noteViewModwl;
    NoteAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        saveNote = findViewById(R.id.fab);
        noteRecyclerView = findViewById(R.id.note_recycler_view);
        mAdapter = new NoteAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        noteRecyclerView.setLayoutManager(mLayoutManager);
        noteRecyclerView.setItemAnimator(new DefaultItemAnimator());
        noteRecyclerView.setAdapter(mAdapter);

        noteViewModwl = ViewModelProviders.of(this).get(NoteViewModwl.class);
        noteViewModwl.getAllNote().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                Toast.makeText(ViewNote.this, String.valueOf(notes.size()), Toast.LENGTH_SHORT).show();
                mAdapter.addNote(notes);
            }
        });

        saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewNote.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
