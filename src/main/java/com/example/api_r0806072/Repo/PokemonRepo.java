package com.example.api_r0806072.Repo;

import com.example.api_r0806072.Model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepo extends JpaRepository<Pokemon, Long> {
}
