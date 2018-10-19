package com.shuo.supermacket.member.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Jackson {

    /**
     * Object to json
     * @param object
     * @return String
     */
    public static String toJson(Object object) throws JsonProcessingException {

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = objectWriter.writeValueAsString(object);

        return json;
    }
}
