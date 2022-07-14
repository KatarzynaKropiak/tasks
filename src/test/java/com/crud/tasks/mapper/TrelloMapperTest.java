package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloMapperTest {

    @Mock
    private  TrelloMapper trelloMapper;



    @Test
    void mapToBoards() {
        //Given
        List<TrelloBoard> testBoards = new ArrayList<>(Arrays.asList(new TrelloBoard("1", "test", new ArrayList<>())));
        List<TrelloBoardDto> testBoardsDto = new ArrayList<>(Arrays.asList(new TrelloBoardDto("1", "test", new ArrayList<>())));
        //When
        when(trelloMapper.mapToBoards(testBoardsDto)).thenReturn(testBoards);
        List<TrelloBoard> resultBoard = trelloMapper.mapToBoards(testBoardsDto);
        //Then
        assertEquals(testBoards, resultBoard);
    }


    @Test
    void mapToBoardsDto() {
        //Given
        List<TrelloBoardDto> testBoardsDto = new ArrayList<>(Arrays.asList(new TrelloBoardDto("1", "test", new ArrayList<>())));
        List<TrelloBoard> testBoards = new ArrayList<>(Arrays.asList(new TrelloBoard("1", "test", new ArrayList<>())));
        //When
        when(trelloMapper.mapToBoardsDto(testBoards)).thenReturn(testBoardsDto);
        List<TrelloBoardDto> mappedTrelloBoardDto = trelloMapper.mapToBoardsDto(testBoards);

        //Then
        assertEquals(testBoardsDto, mappedTrelloBoardDto);
    }

    @Test
    void mapToList() {
        //Given
        List<TrelloList> testList = new ArrayList<>(Arrays.asList(new TrelloList("1", "test", true)));
        List<TrelloListDto> testListDto = new ArrayList<>(Arrays.asList(new TrelloListDto("1", "test", true)));
        //When
        when(trelloMapper.mapToList(testListDto)).thenReturn(testList);
        List<TrelloList> resultList = trelloMapper.mapToList(testListDto);
        //Then
        assertEquals(testList, resultList);
    }


    @Test
    void mapToListDto() {
        //Given
        List<TrelloListDto> testListDto = new ArrayList<>(Arrays.asList(new TrelloListDto("1", "test", true)));
        List<TrelloList> testList = new ArrayList<>(Arrays.asList(new TrelloList("1", "test", true)));
        //When
        when(trelloMapper.mapToListDto(testList)).thenReturn(testListDto);
        List<TrelloListDto> mappedTrelloListDto = trelloMapper.mapToListDto(testList);

        //Then
        assertEquals(testListDto, mappedTrelloListDto);
    }


    @Test
    void mapToCardDto() {
        //Given
        TrelloCardDto testCardDto = new TrelloCardDto("name", "description", "top", "1");
        TrelloCard testCard = new TrelloCard("name", "description", "top", "1");

        //When
        when(trelloMapper.mapToCardDto(testCard)).thenReturn(testCardDto);
        TrelloCardDto mappedTrelloCardDto = trelloMapper.mapToCardDto(testCard);

        //Then
        assertEquals(testCardDto, mappedTrelloCardDto);

    }


    @Test
    void mapToCard() {
        //Given
        TrelloCard testCard = new TrelloCard("name", "description", "top", "1");
        TrelloCardDto testCardDto = new TrelloCardDto("name", "description", "top", "1");

        //When
        when(trelloMapper.mapToCard(testCardDto)).thenReturn(testCard);
        TrelloCard mappedTrelloCard = trelloMapper.mapToCard(testCardDto);

        //Then
        assertEquals(testCard, mappedTrelloCard);

    }

}