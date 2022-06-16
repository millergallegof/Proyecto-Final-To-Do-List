package com.sofka.backtodolist.controllers;


import com.sofka.backtodolist.model.SubTareaModel;
import com.sofka.backtodolist.model.TareaModel;
import com.sofka.backtodolist.services.ListTareaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin
@RestController
public class TareasController {

    @Autowired
    ListTareaService listTareaService;

    @PostMapping(path = "tarea")
    public TareaModel createTarea(@RequestBody TareaModel tarea) {
        return listTareaService.createTarea(tarea);
    }

    @PostMapping(path = "subTarea/{id}")
    public SubTareaModel createTarea(@RequestBody SubTareaModel subTarea, @PathVariable("id")  TareaModel tarea) {
        subTarea.setTareaTar(tarea);
        return listTareaService.createSubTarea(subTarea, tarea);
    }

    @GetMapping(path = "tarea")
    public List<TareaModel> getTarea() {
        return listTareaService.getTareas();
    }

    @GetMapping(path = "subTarea")
    public List<SubTareaModel> getSubTarea() {
        return listTareaService.getSubTareas();
    }

    @PostMapping(path = "subtarea/update/{id}")
    public SubTareaModel updateSubTarea(@PathVariable("id") Integer id, @RequestBody SubTareaModel subTarea) {
        return listTareaService.updateSubTarea(id, subTarea);
    }

    @GetMapping(path = "tarea/{name}")
    public Optional<TareaModel> getTareaByName(@PathVariable("name") String name) {
        return listTareaService.getTareaByName(name);
    }

    @GetMapping(path = "tarea/{id}")
    public Optional<TareaModel> getTareaById(@PathVariable("id") Integer id) {
        return listTareaService.getTareaById(id);
    }

    @DeleteMapping(path = "tarea/delete/{id}")
    public String deleteTarea(@PathVariable("id") Integer id) {
        boolean ok = listTareaService.deleteTarea(id);
        if (ok) {
            return "Se eliminó la tarea con id " + id;
        } else {
            return "No pudo eliminar la tarea con id" + id;
        }
    }

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
