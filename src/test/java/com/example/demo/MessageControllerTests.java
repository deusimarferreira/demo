package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MessageController.class)
public class MessageControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetMessage() throws Exception {
        // GIVEN - No specific setup needed
        // WHEN - Send a GET request to /message
        mockMvc.perform(MockMvcRequestBuilders.get("/message")
                .accept(MediaType.TEXT_PLAIN))
                // THEN - Verify the response status and content
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, this is your message!"));
    }
}