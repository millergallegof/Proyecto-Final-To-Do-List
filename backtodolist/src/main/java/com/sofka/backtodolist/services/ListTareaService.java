package com.sofka.backtodolist.services;

import com.sofka.backtodolist.model.SubTareaModel;
import com.sofka.backtodolist.model.TareaModel;
import com.sofka.backtodolist.repositories.SubTareaRepository;
import com.sofka.backtodolist.repositories.TareaRepository;
import com.sofka.backtodolist.services.interfaces.IListTareas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListTareaService implements IListTareas {

    @Autowired
    SubTareaRepository subTareaRepository;

    @Autowired
    TareaRepository tareaRepository;

    @Override
    @Transactional
    public TareaModel createTarea(TareaModel tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    @Transactional
    public SubTareaModel createSubTarea(SubTareaModel subTarea, TareaModel tarea) {
        subTarea.setComplete(false);
        return subTareaRepository.save(subTarea);
    }

    @Override
    @Transactional
    public List<TareaModel> getTareas() {
        return (List<TareaModel>) tareaRepository.findAll();
    }

    @Override
    @Transactional
    public List<SubTareaModel> getSubTareas() {
        return (List<SubTareaModel>) subTareaRepository.findAll();
    }

    @Override
    @Transactional
    public SubTareaModel updateSubTarea(Integer id, SubTareaModel subTarea) {
        subTarea.setId(id);
        return subTareaRepository.save(subTarea);
    }

    @Override
    @Transactional
    public Optional<TareaModel> getTareaByName(String name) {
        return tareaRepository.findByName(name);
    }

    @Override
    public Optional<TareaModel> getTareaById(Integer id) {
        return tareaRepository.findById(id);
    }

    @Override
    @Transactional
    public List<SubTareaModel> getSubTareasByTarea(TareaModel tarea) {
        return subTareaRepository.findByTareaTar(tarea);
    }

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
