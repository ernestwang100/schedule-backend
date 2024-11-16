package com.ernest.schedule.utils;

import com.ernest.schedule.common.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class WebUtil {
    private static final ObjectMapper objectMapper;

    // Initialize objectMapper
    static {
        objectMapper = new ObjectMapper();
        // Set the date-time format for JSON and Object conversion
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    // Retrieve a JSON string from the request and convert it to an Object
    public static <T> T readJson(HttpServletRequest request, Class<T> clazz) {
        T t = null;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            t = objectMapper.readValue(buffer.toString(), clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    // Convert a Result object to a JSON string and place it in the response object
    public static void writeJson(HttpServletResponse response, Result result) {
        response.setContentType("application/json;charset=UTF-8");
        try {
            String json = objectMapper.writeValueAsString(result);
            response.getWriter().write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
