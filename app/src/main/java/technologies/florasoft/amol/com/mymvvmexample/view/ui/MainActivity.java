package technologies.florasoft.amol.com.mymvvmexample.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import technologies.florasoft.amol.com.mymvvmexample.R;
import technologies.florasoft.amol.com.mymvvmexample.database.model.Note;
import technologies.florasoft.amol.com.mymvvmexample.databinding.ActivityMainBinding;
import technologies.florasoft.amol.com.mymvvmexample.model.AddNote;
import technologies.florasoft.amol.com.mymvvmexample.viewmodel.NoteViewModwl;

public class MainActivity extends AppCompatActivity {

    private NoteViewModwl noteViewModwl;
    AddNote addNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding amb = DataBindingUtil.setContentView(this, R.layout.activity_main);
        addNote = new AddNote();
        amb.setNote(addNote);
        noteViewModwl = ViewModelProviders.of(this).get(NoteViewModwl.class);


    }


    public void SaveData(View view) {
        Note note = new Note(addNote.getTitle(),addNote.getDiscription());
        noteViewModwl.insert(note);
        Toast.makeText(getApplication(),"Note Added", Toast.LENGTH_SHORT).show();
        Intent intent =  new Intent(this,ViewNote.class);
        startActivity(intent);
        finish();
    }


}
