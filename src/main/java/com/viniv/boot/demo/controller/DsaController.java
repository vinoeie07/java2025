package com.viniv.boot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/dsa")
@Slf4j
public class DsaController {

    @GetMapping(value = "/array")
    public void arrayTest() {
        int[] numbers = new int[10000000];
        for (int i = 0; i < 500; i++) {
            numbers[i] = i + 1;
        }


        log.info(Arrays.toString(numbers));
        long start = System.currentTimeMillis();
        int pos = 250;
        int valueToInsert = 501;
        int[] newArray = insertAtX(pos, numbers, valueToInsert, numbers.length);
        long end = System.currentTimeMillis();
        log.info(Arrays.toString(newArray));
        log.info("Total : {}", end - start);

    }

    private int[] insertAtX(int pos, int[] numbers, int valueToInsert, int length) {
        int[] newArray = new int[length + 1];

        for (int i = 0; i < newArray.length; i++) {
            if (i < pos - 1) {
                newArray[i] = numbers[i];
            } else if (i == 0 || i == pos - 1) {
                newArray[i] = valueToInsert;
            } else {
                newArray[i] = numbers[i - 1];
            }

        }
        return newArray;

    }

}
