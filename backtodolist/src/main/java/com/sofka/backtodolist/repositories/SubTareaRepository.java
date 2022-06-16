package com.sofka.backtodolist.repositories;

import com.sofka.backtodolist.model.SubTareaModel;
import com.sofka.backtodolist.model.TareaModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubTareaRepository extends CrudRepository<SubTareaModel, Integer> {
    public abstract List<SubTareaModel> findByTareaTar(TareaModel tareaTar);

}