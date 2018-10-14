package ru.webservice.calories.repository;

import ru.webservice.calories.model.Meal;

import java.util.Collection;

public interface MealRepository {
    Meal save(Meal meal);

    void delete(int id);

    Meal get(int id);

    Collection<Meal> getAll();
}
