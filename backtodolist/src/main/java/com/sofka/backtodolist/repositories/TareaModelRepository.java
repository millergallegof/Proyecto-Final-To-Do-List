package com.sofka.backtodolist.repositories;

import com.sofka.backtodolist.model.TareaModel;
import org.springframework.data.repository.CrudRepository;

public interface TareaModelRepository extends CrudRepository<TareaModel, Integer> {
}