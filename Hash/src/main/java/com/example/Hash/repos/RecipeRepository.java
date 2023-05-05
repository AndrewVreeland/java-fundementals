package com.example.Hash.repos;


import com.example.Hash.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    public Recipe getRecipeByIngredients(String ingredients);
}