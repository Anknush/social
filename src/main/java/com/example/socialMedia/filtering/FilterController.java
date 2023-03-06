package com.example.socialMedia.filtering;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean some = new SomeBean("value1", "value2", "value3");
		MappingJacksonValue mapping = new MappingJacksonValue(some);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filtr = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		mapping.setFilters(filtr);
		return mapping;
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue filterList() {
		List<SomeBean> some = new ArrayList<>();
		some = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("Value4", "value5", "value6"));
		MappingJacksonValue mapping = new MappingJacksonValue(some);

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping.setFilters(filters);
		return mapping;
	}
}
