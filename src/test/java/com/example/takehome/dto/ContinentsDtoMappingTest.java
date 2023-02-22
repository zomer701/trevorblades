package com.example.takehome.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class ContinentsDtoMappingTest {

    private final static List<String> na_countries_test_value = List.of("CA", "US");
    private final static String na_name_test_value = "North America";
    private final static List<String> na_otherCountries_test_value = List.of("AG", "AI", "AW", "BB");

    private final static List<String> eu_countries_test_value = List.of("AD", "FR");
    private final static String eu_name_test_value = "Europe";
    private final static List<String> eu_otherCountries_test_value = List.of("GE", "DE");

    @InjectMocks
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testCountriesSerializingWithJsonValue() throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(new ContinentsDto(List.of(
                new ContinentDto(na_countries_test_value, na_name_test_value, na_otherCountries_test_value),
                new ContinentDto(eu_countries_test_value, eu_name_test_value, eu_otherCountries_test_value))));

        assertThat(jsonString, containsString(objectMapper.writeValueAsString(na_countries_test_value)));
        assertThat(jsonString, containsString(objectMapper.writeValueAsString(na_otherCountries_test_value)));
        assertThat(jsonString, containsString(na_name_test_value));

        assertThat(jsonString, containsString(objectMapper.writeValueAsString(eu_countries_test_value)));
        assertThat(jsonString, containsString(objectMapper.writeValueAsString(eu_otherCountries_test_value)));
        assertThat(jsonString, containsString(eu_name_test_value));
    }
}
