package com.example.api_r0806072.Controller;

import com.example.api_r0806072.Model.Pokemon;
import com.example.api_r0806072.Repo.PokemonRepo;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ApiController {
    @Autowired
    private PokemonRepo repo;

    @GetMapping("/")
    public String getHome(){
        return "Welkom bij create pokémon api";
    }
    @GetMapping("/pokemons")
    public List<Pokemon> getOverview(){
        return repo.findAll();
    }

    @GetMapping("/pokemon/{id}")
    public Pokemon getFact(@PathVariable long id) {
        return repo.findById(id).get();
    }
    @PostMapping("/new")
    public String newFact(@RequestBody Pokemon pokemon) {
        repo.save(pokemon);
        return "Pokemon added";
    }

    @PutMapping(value = "/update/{id}")
    public String updateFact(@PathVariable long id, @RequestBody Pokemon pokemon) {
        Pokemon p = repo.findById(id).get();
        System.out.println(pokemon.getName());
        p.update(pokemon);
        repo.save(p);
        return "Pokemon updated";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteFact(@PathVariable long id) {
        Pokemon deletePokemon = repo.findById(id).get();
        repo.delete(deletePokemon);
        return "Pokemon with id " + id + " deleted";
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, ServiceException.class, ResponseStatusException.class})
    public Map<String, String> handleValidationExceptions(Exception e){
        Map<String, String> errors = new HashMap<>();
        if (e instanceof MethodArgumentNotValidException) {
            ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
        } else if (e instanceof ServiceException) {
            errors.put(((ServiceException) e).getMessage(), e.getMessage());
        } else {
            errors.put(((ResponseStatusException) e).getReason(), e.getCause().getMessage());
        }
        return errors;
    }


}
