package com.example.exercises;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.domain.Director;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of movies of each director
        final Collection<Movie> movies = movieService.findAllMovies();
        Map<Director,Long> numberOfMoviesForEachDirector = new HashMap<>();
        // imperative -> external for-loop
        System.out.println("\nimperative -> external for-loop:\n");
        for (var movie: movies) {
        	for (var director: movie.getDirectors()) {
        		numberOfMoviesForEachDirector.put(director, numberOfMoviesForEachDirector.getOrDefault(director, 0L)+1);
        	}
        }
        for (var entry : numberOfMoviesForEachDirector.entrySet()) {
        	System.out.println("%42s: %2d".formatted(entry.getKey().getName(),entry.getValue()));
        }
        // declarative -> function chain -> pipeline
        System.out.println("\ndeclarative -> function chain -> pipeline:\n");
//        numberOfMoviesForEachDirector =
        movies.stream()                    // Stream<Movie> : MapReduce Framework: Turing Complete
              .parallel()
              .map( Movie::getDirectors )  // Stream<Collection<Director>>
              .flatMap(Collection::stream) // flatten: Stream<Director>
              .sequential()
              .collect(groupingBy(identity(),counting()))
              .forEach((director,count)-> System.out.println("%42s: %2d".formatted(director.getName(),count)));
        
	}

}
