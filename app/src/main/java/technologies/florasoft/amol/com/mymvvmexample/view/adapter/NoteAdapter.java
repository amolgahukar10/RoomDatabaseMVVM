package technologies.florasoft.amol.com.mymvvmexample.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import technologies.florasoft.amol.com.mymvvmexample.R;
import technologies.florasoft.amol.com.mymvvmexample.database.model.Note;
import technologies.florasoft.amol.com.mymvvmexample.databinding.NoteListBinding;
import technologies.florasoft.amol.com.mymvvmexample.view.ui.ViewNote;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private List<Note> noteList;
    NoteListBinding noteListBinding;
    ViewNote viewNote;

    public NoteAdapter(ViewNote viewNote) {
        this.viewNote = viewNote;
         noteList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        noteListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                ,R.layout.note_list, parent, false);
        return new ViewHolder(noteListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = noteList.get(position);
        holder.noteListBinding.setListNote(note);
        MyClickHandler myClickHandler = new MyClickHandler(viewNote);
        holder.noteListBinding.setHandler(myClickHandler);
    }

    public void addNote(List<Note> note) {
        this.noteList = note;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        NoteListBinding noteListBinding;
        public ViewHolder(NoteListBinding activityMainBinding) {
            super(activityMainBinding.getRoot());
            this.noteListBinding = activityMainBinding;
        }
    }

    public class MyClickHandler{
        Context context;
        public MyClickHandler(Context context){
            this.context = context;
        }

        public void clickview(View view , Note note){
            Toast.makeText(context, String.valueOf(note.getId()), Toast.LENGTH_SHORT).show();
        }
    }
}
