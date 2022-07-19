package com.crud.tasks.trello.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloConfigTest {

    @Test
    void getTrelloApiEndpoint() {
        //Given
        TrelloConfig config = new TrelloConfig();
        //When
        String trelloApiEndpoint = config.getTrelloApiEndpoint();
        //Then
        assertNull(trelloApiEndpoint);
    }

    @Test
    void getTrelloAppKey() {
        //Given
        TrelloConfig config = new TrelloConfig();
        //When
        String trelloAppKey = config.getTrelloAppKey();
        //Then
        assertNull(trelloAppKey);

    }

    @Test
    void getTrelloToken() {
        //Given
        TrelloConfig config = new TrelloConfig();
        //When
        String trelloToken = config.getTrelloToken();
        //Then
        assertNull(trelloToken);
    }

    @Test
    void getTrelloUserName() {
        //Given
        TrelloConfig config = new TrelloConfig();
        //When
        String trelloUserName = config.getTrelloUserName();
        //Then
        assertNull(trelloUserName);

    }
}