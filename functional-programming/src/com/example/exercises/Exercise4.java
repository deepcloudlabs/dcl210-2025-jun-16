package com.example.exercises;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.dao.CityDao;
import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise4 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
	private static final CityDao cityDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		countryDao.findAllCountries()
		          .stream()
		          .parallel()
		          .mapToInt(Country::getCapital)
		          .mapToObj(cityDao::findCityById)
		          .filter(Objects::nonNull)
		          .collect(Collectors.maxBy(Comparator.comparing(City::getPopulation)))
		          .ifPresent(System.out::println);
	}

}
