package com.sofka.backtodolist.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;

/**
 * [Creacion de entidad con nombre Tarea
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
@Table(name = "tarea")
public class TareaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tar_id", nullable = false)
    private Integer id;

    @Column(name = "tar_name", nullable = false, length = 70)
    private String name;

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = SubTareaModel.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "tareaTar")
    @JsonManagedReference
    private List<SubTareaModel> subTareas = new ArrayList<>();


}