package technologies.florasoft.amol.com.mymvvmexample.database.dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import technologies.florasoft.amol.com.mymvvmexample.database.model.Note;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM `table`")
    void deleteAll();

    @Query("SELECT * FROM `table`" )
    LiveData<List<Note>> getAllNote();
}
