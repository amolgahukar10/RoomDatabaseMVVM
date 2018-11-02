package technologies.florasoft.amol.com.mymvvmexample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import technologies.florasoft.amol.com.mymvvmexample.database.model.Note;
import technologies.florasoft.amol.com.mymvvmexample.database.repository.NoteRepository;
import technologies.florasoft.amol.com.mymvvmexample.model.AddNote;

public class NoteViewModwl extends AndroidViewModel {
    NoteRepository repository;
    LiveData<List<Note>> allNote;
    AddNote addNote;

    public NoteViewModwl(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNote = repository.getAllNote();
        addNote = new AddNote();
    }

    public void insert(Note note){
        repository.insert(note);
    }

    public LiveData<List<Note>> getAllNote(){
        return allNote;
    }

}
