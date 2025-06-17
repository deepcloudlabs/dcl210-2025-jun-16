package com.example.exercises;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.example.domain.Director;
import com.example.domain.Genre;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise3 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of genres of each director's movies
		Comparator<Entry<Director, Long>> comparingByGenreCountryAsc = Comparator.comparing(Map.Entry::getValue);
		var comparingByGenreCountryDesc = comparingByGenreCountryAsc.reversed();
		movieService.findAllMovies()
		            .stream()
		            .parallel()
		            .map(movie -> movie.getDirectors().stream().map(director -> DirectorGenresPair.valueOf(director, movie)).toList())
		            .flatMap(List::stream)  // Stream<DirectorGenresPair>
		            .map(directorGenresPair -> directorGenresPair.genres().stream().map(genre -> new DirectorGenrePair(directorGenresPair.director(),genre)).toList())
		            .flatMap(List::stream) // Stream<DirectorGenrePair>
		            .distinct()
		            .collect(Collectors.groupingBy(DirectorGenrePair::director,Collectors.counting()))
		            .entrySet()
		            .stream()
		            .parallel()
		            .sorted(comparingByGenreCountryDesc)
		            .sequential()
		            .forEachOrdered(entry->System.out.println("%36s: %3d".formatted(entry.getKey().getName(),entry.getValue())));
	}

}

record DirectorGenresPair(Director director,Collection<Genre> genres) {
	public static DirectorGenresPair valueOf(Director director,Movie movie) {
		return new DirectorGenresPair(director,movie.getGenres());
	} 
}
record DirectorGenrePair(Director director,Genre genre) {}