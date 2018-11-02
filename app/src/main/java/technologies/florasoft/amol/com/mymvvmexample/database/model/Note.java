package technologies.florasoft.amol.com.mymvvmexample.database.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id ;

    @ColumnInfo(name = "title")
    private String Title ;

    @ColumnInfo(name = "discription")
    private String Description;

    public Note(String title, String description) {
        Title = title;
        Description = description;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Note(){ }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public class noteDetail{
        @ForeignKey(entity = Note.class , parentColumns = "id",childColumns = "uid",onDelete = CASCADE)
        int uid;
    }
}


