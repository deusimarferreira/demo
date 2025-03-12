package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MessageControllerTests {

    private MessageController messageController;

    @BeforeEach
    void setUp() {
        messageController = new MessageController();
    }

    @Test
    @DisplayName("Get message from /message endpoint")
    void getMessage_returnsCorrectMessage() {
      // GIVEN: A new instance of the MessageController is created.
      // WHEN: The getMessage() method is called.
      // THEN: The method returns the expected message "Hello, this is your message!".
      String result = messageController.getMessage();
      assert result.equals("Hello, this is your message!") : "Expected 'Hello, this is your message!', but got '" + result + "'";
  }
}