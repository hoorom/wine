package com.wine.bottle.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.wine.bottle.domain.Bottle;
import com.wine.bottle.service.BottleService;
import com.wine.bottle.util.BottleSize;
import com.wine.bottle.util.WineColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class BottleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BottleService bottleService;

    @Test
    @DisplayName("Test addBottle: Valid input data")
    public void testAddBottle_WithValidData() throws Exception {
        // Perform POST request to add a bottle
        mockMvc.perform(MockMvcRequestBuilders.post("/bottleList/addBottle").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("name", "Chardonnay")
                .param("size", BottleSize.STANDARD.toString()).param("color", WineColor.RED.toString())).andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/bottleList"));

        // Verify service createBottle method was called
        Mockito.verify(bottleService, times(1)).createBottle(any(Bottle.class));
    }

    @Test
    @DisplayName("Test addBottle: Missing required fields")
    public void testAddBottle_MissingRequiredFields() throws Exception {
        // Perform POST request with missing fields
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/bottleList/addBottle").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("name", "").param("size", BottleSize.STANDARD.toString()))
                .andExpect(status().isOk()); // Assuming the form is reloaded upon validation failure

        // Verify service createBottle method was not called
        Mockito.verify(bottleService, times(0)).createBottle(any(Bottle.class));
    }

    @Test
    @DisplayName("Test addBottle: Invalid bottle size")
    public void testAddBottle_InvalidBottleSize() throws Exception {
        // Perform POST request with invalid size field
        mockMvc.perform(
                MockMvcRequestBuilders.post("/bottleList/addBottle").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("name", "Cabernet Sauvignon").param("size", "INVALID_SIZE")
                        .param("color", WineColor.WHITE.toString())).andExpect(status().isOk()); // Form should reload due to validation failure

        // Verify service createBottle method was not called
        Mockito.verify(bottleService, times(0)).createBottle(any(Bottle.class));
    }
}
