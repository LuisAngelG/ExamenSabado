package com.lgastelu.examensabado.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lgastelu.examensabado.R;
import com.lgastelu.examensabado.models.Notas;
import com.lgastelu.examensabado.repositories.NotasRepository;
import com.lgastelu.examensabado.repositories.UserRepository;

import java.util.List;
import java.util.Objects;

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.ViewHolder>{

    private List<Notas> notas;

    public NotasAdapter(List<Notas> notas){
        this.notas = notas;
    }

    public void setNotas(List<Notas> notas) {
        this.notas = notas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView content;
        public ImageButton button;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_txt);
            content = (TextView) itemView.findViewById(R.id.content_txt);
            button = (ImageButton) itemView.findViewById(R.id.archive_check);
        }
    }
    @Override
    public NotasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notas, parent, false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(NotasAdapter.ViewHolder viewHolder,final int position) {
        final Notas notas = this.notas.get(position);
        viewHolder.title.setText(notas.getTitle());
        viewHolder.content.setText(notas.getContent());

        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotasRepository.delete(notas.getId());
                notas.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());
            }
        });

    }
    @Override
    public int getItemCount() {
        return this.notas.size();
    }

}