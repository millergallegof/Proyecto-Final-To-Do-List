package com.sofka.backtodolist.services.interfaces;

import com.sofka.backtodolist.model.SubTareaModel;
import com.sofka.backtodolist.model.TareaModel;

import java.util.List;
import java.util.Optional;

public interface IListTareas {
    public TareaModel createTarea(TareaModel tarea);

    public SubTareaModel createSubTarea(SubTareaModel subTarea, TareaModel tarea);

    public List<TareaModel> getTareas();

    public List<SubTareaModel> getSubTareas();

    public SubTareaModel updateSubTarea(Integer id, SubTareaModel subTarea);

    public Optional<TareaModel> getTareaByName(String name);

    public Optional<TareaModel> getTareaById(Integer id);

    public List<SubTareaModel> getSubTareasByTarea(TareaModel tarea);

    public boolean deleteTarea(Integer id);

    public boolean deleteSubTarea(Integer id);
}
