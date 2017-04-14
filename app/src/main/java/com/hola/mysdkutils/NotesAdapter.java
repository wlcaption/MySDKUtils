package com.hola.mysdkutils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/14.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private NoteClickListener clickListener;
    private List<Note> dataset;
    public interface NoteClickListener{
        void onNoteClick(int position);
    }
    static class NoteViewHolder extends RecyclerView.ViewHolder{

        public TextView text;
        public TextView comment;

        public NoteViewHolder(View itemView,final NoteClickListener clickListener) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textViewNoteText);
            comment = (TextView) itemView.findViewById(R.id.textViewNoteComment);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(clickListener != null){
                        clickListener.onNoteClick(getAdapterPosition());
                    }
                }
            });

        }
    }

    public NotesAdapter(NoteClickListener clickListener){
        this.clickListener = clickListener;
        this.dataset = new ArrayList<Note>();
    }

    public void setNotes(@NotNull List<Note> notes){
        dataset = notes;
        notifyDataSetChanged();
    }

    public Note getNote(int position){
        return dataset.get(position);
    }

    @Override
    public NotesAdapter.NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note,parent,false);
        return new NoteViewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note note = dataset.get(position);
        holder.text.setText(note.getText());
        holder.comment.setText(note.getComment());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
