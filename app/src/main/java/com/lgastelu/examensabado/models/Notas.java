package com.lgastelu.examensabado.models;

import com.orm.dsl.Table;

@Table
public class Notas {
    private Long id;
    private String title;
    private String content;

    public Notas(){
    }

    public Notas(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        return "Notas{" +
                "id="+id+
                ",title='"+title+'\''+
                ",content='"+content+'\''+
                '}';
    }

}
