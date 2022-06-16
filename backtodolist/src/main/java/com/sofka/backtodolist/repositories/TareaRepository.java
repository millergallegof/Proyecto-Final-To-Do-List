package com.sofka.backtodolist.repositories;

import com.sofka.backtodolist.model.TareaModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TareaRepository extends CrudRepository<TareaModel, Integer> {
    public abstract Optional<TareaModel> findByName(String name);
}