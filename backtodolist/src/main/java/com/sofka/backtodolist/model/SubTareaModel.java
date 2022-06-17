package com.sofka.backtodolist.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

/**
 * [Creqacion de entidad con nombre SubTarea
 * ]
 *
 * @version [1.0.0 2022-06-17]
 *
 * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
 *
 * @since [1.0.0]
 *
 */
@Entity
@Data
@Table(name = "sub_tarea")
public class SubTareaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id", nullable = false)
    private Integer id;

    @Column(name = "sub_name", nullable = false, length = 100)
    private String name;

    @Column(name = "sub_complete", nullable = false)
    private Boolean complete;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sub_tarea_id", nullable = false)
    @JsonBackReference
    private TareaModel tareaTar;


}