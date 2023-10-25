package com.example.frequency.services;

import com.example.frequency.exceptions.EmptyStringException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class FrequencyService {
    /**
     * Метод для подсчета частоты встречи символов в переданной строке и возвращения Map.
     *
     * @param inputString строка, для которой нужно рассчитать частоту символов.
     * @return map, где ключи - символы, значения - частота вхождений символа в строку.
     * @throws EmptyStringException, если параметр пустой.
     */
    public Map<Character, Integer> calculateFrequency(String inputString) {
        if (inputString.isEmpty()) {
            throw new EmptyStringException();
        }
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}