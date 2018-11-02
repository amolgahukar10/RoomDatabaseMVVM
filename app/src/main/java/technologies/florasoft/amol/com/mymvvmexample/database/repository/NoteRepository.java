package technologies.florasoft.amol.com.mymvvmexample.database.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import technologies.florasoft.amol.com.mymvvmexample.database.NoteDatabase;
import technologies.florasoft.amol.com.mymvvmexample.database.dao.NoteDao;
import technologies.florasoft.amol.com.mymvvmexample.database.model.Note;

public class NoteRepository {

  private NoteDao noteDao;
  private LiveData<List<Note>> allNote;

  public void insert(Note note){
        new InsertAsyncTask(noteDao).execute(note);
  }

  public LiveData<List<Note>> getAllNote(){
      return allNote;
  }

  public NoteRepository(Application application){
      NoteDatabase database = NoteDatabase.getInstances(application);
      noteDao = database.noteDao();
      allNote = noteDao.getAllNote();
  }



  class InsertAsyncTask extends AsyncTask<Note,Void,Void>{

      NoteDao noteDao;

      public InsertAsyncTask(NoteDao noteDao) {
          this.noteDao = noteDao;
      }

      @Override
      protected Void doInBackground(Note... notes) {
          noteDao.insert(notes[0]);
          return null;
      }
  }


}
