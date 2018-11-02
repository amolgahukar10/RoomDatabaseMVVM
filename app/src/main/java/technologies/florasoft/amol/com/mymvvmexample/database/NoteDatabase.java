package technologies.florasoft.amol.com.mymvvmexample.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import technologies.florasoft.amol.com.mymvvmexample.database.dao.NoteDao;
import technologies.florasoft.amol.com.mymvvmexample.database.model.Note;


@Database(entities = {Note.class} , version = 1)
public abstract class NoteDatabase  extends RoomDatabase{

    private static NoteDatabase instances;
    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstances(Context context){
       if (instances == null){
            instances = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class,"note_database").fallbackToDestructiveMigration()
                    .build();
       }

       return instances;
    }


    /*private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            //new PopulatDBAsync(instances).execute();
        }
    };


   private static class PopulatDBAsync extends AsyncTask<Void,Void,Void>{

        private NoteDao noteDao;

        public PopulatDBAsync(NoteDatabase db) {
            this.noteDao = db.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("Abc","xyz"));
            noteDao.insert(new Note("Abc","xyz"));
            noteDao.insert(new Note("Abc","xyz"));
            return null;
        }
    }*/
}
