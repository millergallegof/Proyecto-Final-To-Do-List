package com.sofka.backtodolist.repositories;

import com.sofka.backtodolist.model.TareaModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

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
public interface TareaRepository extends CrudRepository<TareaModel, Integer> {
    /**
     * [solicitar la tarea en la base de datos segun una el nombre
     * ]
     *
     * @param name String nombre del objeto a buscar
     * @return objeto tipo tarea en tipo json
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
    Optional<TareaModel> findByName(String name);
}