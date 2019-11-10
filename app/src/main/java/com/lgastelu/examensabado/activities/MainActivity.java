package com.lgastelu.examensabado.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lgastelu.examensabado.R;
import com.lgastelu.examensabado.adapters.NotasAdapter;
import com.lgastelu.examensabado.models.Notas;
import com.lgastelu.examensabado.repositories.NotasRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView notasList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    notasList = (RecyclerView)findViewById(R.id.notas_list);
    notasList.setLayoutManager(new LinearLayoutManager(this));
    List<Notas> notas = NotasRepository.list();
    notasList.setAdapter(new NotasAdapter(notas));
    }
    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, NotasActivity.class), 100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        NotasAdapter adapter = (NotasAdapter)notasList.getAdapter();
        List<Notas> notas = NotasRepository.list();
        adapter.setNotas(notas);
        adapter.notifyDataSetChanged();
    }
}
