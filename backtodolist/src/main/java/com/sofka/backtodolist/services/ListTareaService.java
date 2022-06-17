package com.sofka.backtodolist.services;

import com.sofka.backtodolist.model.SubTareaModel;
import com.sofka.backtodolist.model.TareaModel;
import com.sofka.backtodolist.repositories.SubTareaRepository;
import com.sofka.backtodolist.repositories.TareaRepository;
import com.sofka.backtodolist.services.interfaces.IListTareas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * [Servicio que implementa la interfaz listTarea en donde se procesan los metodos crud
 * ]
 *
 * @version [1.0.0 2022-06-17]
 *
 * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
 *
 * @since [1.0.0]
 *
 */
@Service
public class ListTareaService implements IListTareas {

    /**
     * Servicio para el manejo del repositorio Subtarea
     */
    @Autowired
    SubTareaRepository subTareaRepository;

    /**
     * Servicio para el manejo del repositorio tarea
     */
    @Autowired
    TareaRepository tareaRepository;

    /**
     * [Crea una nueva tarea en la base de datos utilizando el metodo de crudRepository
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
    @Override
    @Transactional
    public TareaModel createTarea(TareaModel tarea) {
        return tareaRepository.save(tarea);
    }

    /**
     * [Crea una nueva Subtarea en la base de datos utilizando los metodos del Crudrepository
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
    @Override
    @Transactional
    public SubTareaModel createSubTarea(SubTareaModel subTarea, TareaModel tarea) {
        subTarea.setComplete(false);
        return subTareaRepository.save(subTarea);
    }

    /**
     * [Solicita a la base de datos los elementos tipo Tarea y os almacena en un arreglo utiliza el metodo de CrudRepository
     * ]
     *
     * @return arrayList con los objetos solicitados
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
    @Override
    @Transactional
    public List<TareaModel> getTareas() {
        return (List<TareaModel>) tareaRepository.findAll();
    }

    /**
     * [Solicita a la base de datos los elementos tipo subTarea y los almacena en un arreglo utilizando metodos de CrudRepository
     * ]
     *
     * @return arrayList con los objetos solicitados
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
    @Override
    @Transactional
    public List<SubTareaModel> getSubTareas() {
        return (List<SubTareaModel>) subTareaRepository.findAll();
    }

    /**
     * [actualiza una Subtarea en la base de datos utilizando los metodos de CrudRepository
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
    @Override
    @Transactional
    public SubTareaModel updateSubTarea(Integer id, SubTareaModel subTarea) {
        subTarea.setId(id);
        return subTareaRepository.save(subTarea);
    }

    /**
     * [solicitar una tarea en la base de datos segun el nombre de dicha tarea
     * ]
     *
     * @param name string con el elemento el cual se va a buscar
     * @return tarea objeto en tipo json que se busca
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
    @Override
    @Transactional
    public Optional<TareaModel> getTareaByName(String name) {
        return tareaRepository.findByName(name);
    }

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
    @Override
    public Optional<TareaModel> getTareaById(Integer id) {
        return tareaRepository.findById(id);
    }

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
    @Override
    @Transactional
    public List<SubTareaModel> getSubTareasByTarea(TareaModel tarea) {
        return subTareaRepository.findByTareaTar(tarea);
    }

    /**
     * [elimina una tarea en la base de datos segun el id
     * ]
     *
     * @param id integer el cual corresponde al elemento buscado
     * @return boolean que indica si la peticion fue exitosa
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
    @Override
    @Transactional
    public boolean deleteTarea(Integer id) {
        try {
            tareaRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    /**
     * [elimina una Subtarea en la base de datos segun el id
     * ]
     *
     * @param id integer el cual corresponde al elemento buscado
     * @return boolean que indica si la peticion fue exitosa
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
    @Override
    @Transactional
    public boolean deleteSubTarea(Integer id) {
        try {
            subTareaRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
