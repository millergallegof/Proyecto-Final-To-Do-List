package com.sofka.backtodolist.services.interfaces;

import com.sofka.backtodolist.model.SubTareaModel;
import com.sofka.backtodolist.model.TareaModel;

import java.util.List;
import java.util.Optional;

/**
 * [Interfaz la cual genere los metodos que se desean realizar en la API
 * ]
 *
 * @version [1.0.0 2022-06-17]
 *
 * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
 *
 * @since [1.0.0]
 *
 */
public interface IListTareas {
    /**
     * [Crea una nueva tarea en la base de datos
     * ]
     *
     * @param tarea Objeto tarea el cual se va a crear
     * @return tarea objeto en tipo json creado
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
     TareaModel createTarea(TareaModel tarea);

    /**
     * [Crea una nueva Subtarea en la base de datos
     * ]
     *
     * @param subTarea Objeto subtarea el cual se va a crear
     * @param tarea Objeto tarea el cual se agregara como atributo de subtarea
     * @return subtarea objeto en tipo json creado
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
     SubTareaModel createSubTarea(SubTareaModel subTarea, TareaModel tarea);

    /**
     * [Solicita a la base de datos los elementos tipo Tarea y los almacena en un arreglo
     * ]
     *
     * @return arrayList con los objetos solicitados
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
     List<TareaModel> getTareas();

    /**
     * [Solicita a la base de datos los elementos tipo subTarea y los almacena en un arreglo
     * ]
     *
     * @return arrayList con los objetos solicitados
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
     List<SubTareaModel> getSubTareas();

    /**
     * [actualiza una Subtarea en la base de datos
     * ]
     *
     * @param id id del objeto el cual se desea atualizar
     * @param subTarea Objeto subtarea el cual contiene la informacion actualizar
     * @return subtarea objeto en tipo json actualizado
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
     SubTareaModel updateSubTarea(Integer id, SubTareaModel subTarea);

    /**
     * [solicitar una tarea en la base de datos segun el nombre de dicha tarea
     * ]
     *
     * @param name string con el elemento el cual se va a buscar
     * @return objeto tipo tarea en tipo json que se busca
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
     Optional<TareaModel> getTareaByName(String name);

    /**
     * [solicitar una tarea en la base de datos segun el id
     * ]
     *
     * @param id integer el cual corresponde al elemento buscado
     * @return objeto tipo tarea en tipo json
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
     Optional<TareaModel> getTareaById(Integer id);

    /**
     * [solicitar una subtarea en la base de datos segun el id
     * ]
     *
     * @param tarea objeto tipo tarea el cual se busca en la base de datos por el endpoint
     * @return List arreglo de objetos tipo subtarea en tipo json
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
     List<SubTareaModel> getSubTareasByTarea(TareaModel tarea);

    /**
     * [elimina una tarea en la base de datos segun el id
     * ]
     *
     * @param id integer el cual corresponde al elemento buscado
     * @return String con mensaje resultante de la peticion
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
     boolean deleteTarea(Integer id);

    /**
     * [elimina una Subtarea en la base de datos segun el id
     * ]
     *
     * @param id integer el cual corresponde al elemento buscado
     * @return String con mensaje resultante de la peticion
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
     boolean deleteSubTarea(Integer id);
}
