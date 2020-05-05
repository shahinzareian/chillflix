package com.example.demo.controlles;

import com.example.demo.models.Movie;
import com.example.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getMovies(){return movieRepository.findAll();}

    @GetMapping("/{id}")
    public Movie geMovie(@PathVariable Long id) {
        return movieRepository.findById(id).get();
    }

    @PostMapping
    public Long addMovie(@RequestBody Movie movie) {
        Movie createMovie=  movieRepository.save(movie);
        return createMovie.getId();
    }

    @DeleteMapping("/{id}")
    void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateMovie(@PathVariable("id") Long id, @RequestBody Movie movie) {
        movie.setId(id);
        movieRepository.save(movie);
    }
}
