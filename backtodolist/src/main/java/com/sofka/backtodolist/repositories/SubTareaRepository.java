package com.sofka.backtodolist.repositories;

import com.sofka.backtodolist.model.SubTareaModel;
import com.sofka.backtodolist.model.TareaModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * [Interfaz que extiende de la clase CrudRepository para realizar metodos del crud
 * ]
 *
 * @version [1.0.0 2022-06-17]
 *
 * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
 *
 * @since [1.0.0]
 *
 */
public interface SubTareaRepository extends CrudRepository<SubTareaModel, Integer> {
    /**
     * [solicitar las subtareas relacionadas en la base de datos segun una tarea
     * ]
     *
     * @param tareaTar objeto tipo tarea el cual se busca en la base de datos
     * @return List arreglo de objetos tipo subtarea en tipo json
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
    List<SubTareaModel> findByTareaTar(TareaModel tareaTar);

}