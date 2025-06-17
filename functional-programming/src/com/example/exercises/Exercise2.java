package com.example.exercises;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.maxBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated city of each continent
		// var highestPopCityOfEachContinent= 
		countryDao.findAllCountries()
		          .stream()    // Stream<Country>
		          .map( country -> Map.entry(country.getContinent(), country.getCities())) // Stream<Entry<Continet,Collection<City>>
		          .map( entry -> entry.getValue().stream().map(city -> Map.entry(entry.getKey(), city)).toList())
		          .filter(entry -> entry.size() > 0)
		          .flatMap( List::stream) // Stream<Entry<String,City>>
		          .collect(Collectors.groupingBy(Map.Entry::getKey,maxBy(comparingInt(entry-> entry.getValue().getPopulation()))))         
		          .forEach((continent,city) -> System.out.println("%24s: %36s".formatted(continent,city.get().getValue().getName())));
	}

}