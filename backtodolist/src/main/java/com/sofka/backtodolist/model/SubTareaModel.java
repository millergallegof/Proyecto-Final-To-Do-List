package com.sofka.backtodolist.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "sub_tarea")
public class SubTareaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id", nullable = false)
    private Integer id;

    @Column(name = "sub_name", nullable = false, length = 100)
    private String subName;

    @Column(name = "sub_complete", nullable = false)
    private Integer subComplete;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tarea_tar_id", nullable = false)
    @JsonBackReference
    private TareaModel tareaTar;


}