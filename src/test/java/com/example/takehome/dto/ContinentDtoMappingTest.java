package com.example.takehome.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
public class ContinentDtoMappingTest {

    private final static List<String> countries_test_value = List.of("CA", "US");
    private final static List<String> otherCountries_test_value = List.of("AG", "AI", "AW", "BB");
    private final static String name_test_value = "North America";

    @InjectMocks
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testCountrySerializingWithJsonValue() throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(new ContinentDto(countries_test_value,
                name_test_value,
                otherCountries_test_value));
        assertThat(jsonString, containsString(objectMapper.writeValueAsString(countries_test_value)));
        assertThat(jsonString, containsString(objectMapper.writeValueAsString(otherCountries_test_value)));
        assertThat(jsonString, containsString(name_test_value));
    }
}
