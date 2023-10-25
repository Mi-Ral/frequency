package com.example.frequency;

import com.example.frequency.exceptions.EmptyStringException;
import com.example.frequency.services.FrequencyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class FrequencyTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FrequencyService frequencyService;

    private String URL = "/api/frequency?inputString=";

    @Test
    public void testCalculateFrequency() throws Exception {
        String inputString = "aaaaabcccc";
        Map<Character, Integer> expectedResponse = new HashMap<>();
        expectedResponse.put('a', 5);
        expectedResponse.put('c', 4);
        expectedResponse.put('b', 1);

        when(frequencyService.calculateFrequency(inputString)).thenReturn(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.get(URL + inputString))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(expectedResponse)));
    }

    @Test
    public void testCalculateFrequencyEmptyString() throws Exception {
        String inputString = "";

        when(frequencyService.calculateFrequency(inputString)).thenThrow(EmptyStringException.class);
        mockMvc.perform(MockMvcRequestBuilders.get(URL + inputString))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
