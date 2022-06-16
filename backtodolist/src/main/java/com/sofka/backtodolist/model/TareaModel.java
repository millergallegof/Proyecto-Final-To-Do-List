package com.sofka.backtodolist.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "tarea")
public class TareaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tar_id", nullable = false)
    private Integer id;

    @Column(name = "tar_name", nullable = false, length = 70)
    private String tarName;

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = SubTareaModel.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "tareaTar")
    @JsonManagedReference
    private List<SubTareaModel> subTareas = new ArrayList<>();


}