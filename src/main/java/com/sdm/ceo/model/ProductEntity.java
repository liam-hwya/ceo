package com.sdm.ceo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import com.sdm.core.model.DefaultEntity;


@Entity(name = "ProdutEntity")
@Table(name = "tbl_products")
public class ProductEntity extends DefaultEntity{

    private static final long serialVersionUID = 739168064520778219L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(name = "`group`")
    private String group;

    @Column
    private Long price;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tbl_product_extras", joinColumns = @JoinColumn(name = "productId", nullable = false))
    @MapKeyColumn(name = "`key`")
    @Column(name = "value")
    private Map<String, String> extras = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tbl_product_attachments", joinColumns = @JoinColumn(name = "productId", nullable = false))
    @Column(name = "fileId")
    private List<String> file = new ArrayList<String>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Map<String, String> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, String> extras) {
        this.extras = extras;
    }

    public List<String> getFile() {
        return file;
    }

    public void setFile(List<String> file) {
        this.file = file;
    }
}