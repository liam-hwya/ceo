package com.sdm.ceo.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import com.sdm.core.model.DefaultEntity;

@Entity(name = "ContactEntity")
@Table(name = "tbl_contacts")
public class ContactEntity extends DefaultEntity{

    private static final long serialVersionUID = 739168064520778219L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column
    private String note;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "`key`")
    @Column(name = "value")
    @CollectionTable(name = "tbl_contact_extras", joinColumns = @JoinColumn(name = "contact_id", nullable = false))
    private Map<String, String> extras = new HashMap<>();

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Map<String, String> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, String> extras) {
        this.extras = extras;
    }

    public void addExtras(String key, String value){
        if(this.extras == null){
            this.extras = new HashMap<>();
        }
        this.extras.put(key, value);
    }
}