package com.sofka.backtodolist.controllers;


import com.sofka.backtodolist.model.SubTareaModel;
import com.sofka.backtodolist.model.TareaModel;
import com.sofka.backtodolist.services.ListTareaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
