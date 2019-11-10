package com.lgastelu.examensabado.repositories;

import com.lgastelu.examensabado.models.Notas;
import com.orm.SugarRecord;

import java.util.List;

public class NotasRepository {
    public static List<Notas> list(){
        List<Notas>notas= SugarRecord.listAll(Notas.class);
        return notas;
    }

    public static Notas read(Long id){
        Notas notas=SugarRecord.findById(Notas.class, id);
        return notas;
    }

    public static void create(String title, String content){
        Notas notas=new Notas(title, content);
        SugarRecord.save(notas);
    }

    public static void update(String title, String content, Long id){
        Notas notas=SugarRecord.findById(Notas.class, id);
        notas.setTitle(title);
        notas.setContent(content);
        SugarRecord.save(notas);
    }

    public static void delete(Long id){
        Notas notas=SugarRecord.findById(Notas.class, id);
        SugarRecord.delete(notas);
    }

}
