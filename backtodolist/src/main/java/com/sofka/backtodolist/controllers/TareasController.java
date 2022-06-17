package com.sofka.backtodolist.controllers;


import com.sofka.backtodolist.model.SubTareaModel;
import com.sofka.backtodolist.model.TareaModel;
import com.sofka.backtodolist.services.ListTareaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

/**
 * Controlador para la Lista de Tareas y Subtareas
 *
 * @version 1.0.0 2022-06-17
 * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
 * @since 1.0.0
 */
@Slf4j
@CrossOrigin
@RestController
public class TareasController {

    /**
     * Servicio para el manejo de la listTarea
     */
    @Autowired
    ListTareaService listTareaService;

    /**
     * [Crea una nueva tarea en la base de datos
     * ]
     *
     * @param tareas Objeto tarea el cual se va a crear
     * @return tarea objeto en tipo json creado
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
    @PostMapping(path = "tarea")
    public TareaModel createTarea(@RequestBody TareaModel tareas) {
        return listTareaService.createTarea(tareas);
    }

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
    @PostMapping(path = "subTarea/{id}")
    public SubTareaModel createTarea(@RequestBody SubTareaModel subTarea, @PathVariable("id")  TareaModel tarea) {
        subTarea.setTareaTar(tarea);
        return listTareaService.createSubTarea(subTarea, tarea);
    }

    /**
     * [Solicita a la base de datos los elementos tipo Tarea y os almacena en un arreglo
     * ]
     *
     * @return arrayList con los objetos solicitados
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
    @GetMapping(path = "tarea")
    public List<TareaModel> getTarea() {
        return listTareaService.getTareas();
    }

    /**
     * [Solicita a la base de datos los elementos tipo subTarea y os almacena en un arreglo
     * ]
     *
     * @return arrayList con los objetos solicitados
     *
     * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
     *
     * @since [1.0.0]
     *
     */
    @GetMapping(path = "subTarea")
    public List<SubTareaModel> getSubTarea() {
        return listTareaService.getSubTareas();
    }

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
    @PostMapping(path = "subtarea/update/{id}")
    public SubTareaModel updateSubTarea(@PathVariable("id") Integer id, @RequestBody SubTareaModel subTarea) {
        return listTareaService.updateSubTarea(id, subTarea);
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
    @GetMapping(path = "buscarTarea/{name}")
    public Optional<TareaModel> getTareaByName(@PathVariable("name") String name) {
        return listTareaService.getTareaByName(name);
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
    @GetMapping(path = "buscarSubtarea/tarea/{id}")
    public List<SubTareaModel> getSubTareaByTarea(@PathVariable("id") TareaModel tarea) {
        return listTareaService.getSubTareasByTarea(tarea);
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
    @GetMapping(path = "tarea/{id}")
    public Optional<TareaModel> getTareaById(@PathVariable("id") Integer id) {
        return listTareaService.getTareaById(id);
    }

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
    @DeleteMapping(path = "tarea/delete/{id}")
    public String deleteTarea(@PathVariable("id") Integer id) {
        boolean ok = listTareaService.deleteTarea(id);
        if (ok) {
            return "Se eliminó la tarea con id " + id;
        } else {
            return "No pudo eliminar la tarea con id" + id;
        }
    }

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
    @DeleteMapping(path = "subTarea/delete/{id}")
    public String deleteSubTarea(@PathVariable("id") Integer id) {
        boolean ok = listTareaService.deleteSubTarea(id);
        if (ok) {
            return "Se eliminó la Subtarea con id " + id;
        } else {
            return "No pudo eliminar la Subtarea con id" + id;
        }
    }

}
