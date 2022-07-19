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

class TrelloMapperTest {

    private TrelloMapper trelloMapper = new TrelloMapper();



    @Test
    void mapToBoards() {
        //Given
        List<TrelloBoard> testBoards = new ArrayList<>(Arrays.asList(new TrelloBoard("1", "test", new ArrayList<>())));
        List<TrelloBoardDto> testBoardsDto = new ArrayList<>(Arrays.asList(new TrelloBoardDto("1", "test", new ArrayList<>())));
        //When
        //when(trelloMapper.mapToBoards(testBoardsDto)).thenReturn(testBoards);
        List<TrelloBoard> resultBoard = trelloMapper.mapToBoards(testBoardsDto);
        //Then
        //assertEquals(testBoards, resultBoard);
        assertEquals(testBoards.get(0).getId(), resultBoard.get(0).getId());
        assertEquals(testBoards.get(0).getName(), resultBoard.get(0).getName());
        assertEquals(testBoards.get(0).getLists(), resultBoard.get(0).getLists());
    }


    @Test
    void mapToBoardsDto() {
        //Given
        List<TrelloBoardDto> testBoardsDto = new ArrayList<>(Arrays.asList(new TrelloBoardDto("1", "test", new ArrayList<>())));
        List<TrelloBoard> testBoards = new ArrayList<>(Arrays.asList(new TrelloBoard("1", "test", new ArrayList<>())));
        //When
   //     when(trelloMapper.mapToBoardsDto(testBoards)).thenReturn(testBoardsDto);
        List<TrelloBoardDto> mappedTrelloBoardDto = trelloMapper.mapToBoardsDto(testBoards);

        //Then
    //    assertEquals(testBoardsDto, mappedTrelloBoardDto);
        assertEquals(testBoardsDto.get(0).getId(), mappedTrelloBoardDto.get(0).getId());
        assertEquals(testBoardsDto.get(0).getName(), mappedTrelloBoardDto.get(0).getName());
        assertEquals(testBoardsDto.get(0).getLists(), mappedTrelloBoardDto.get(0).getLists());
    }

    @Test
    void mapToList() {
        //Given
        List<TrelloList> testList = new ArrayList<>(Arrays.asList(new TrelloList("1", "test", true)));
        List<TrelloListDto> testListDto = new ArrayList<>(Arrays.asList(new TrelloListDto("1", "test", true)));
        //When
    //    when(trelloMapper.mapToList(testListDto)).thenReturn(testList);
        List<TrelloList> resultList = trelloMapper.mapToList(testListDto);
        //Then
    //    assertEquals(testList, resultList);
        assertEquals(testList.get(0).getId(), resultList.get(0).getId());
        assertEquals(testList.get(0).getName(), resultList.get(0).getName());
        assertEquals(testList.get(0).isClosed(), resultList.get(0).isClosed());
    }


    @Test
    void mapToListDto() {
        //Given
        List<TrelloListDto> testListDto = new ArrayList<>(Arrays.asList(new TrelloListDto("1", "test", true)));
        List<TrelloList> testList = new ArrayList<>(Arrays.asList(new TrelloList("1", "test", true)));
        //When
    //    when(trelloMapper.mapToListDto(testList)).thenReturn(testListDto);
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
    //    when(trelloMapper.mapToCardDto(testCard)).thenReturn(testCardDto);
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
    //    when(trelloMapper.mapToCard(testCardDto)).thenReturn(testCard);
        TrelloCard mappedTrelloCard = trelloMapper.mapToCard(testCardDto);

        //Then
        //assertEquals(testCard, mappedTrelloCard);
        assertEquals(testCard.getName(), mappedTrelloCard.getName());
        assertEquals(testCard.getDescription(), mappedTrelloCard.getDescription());
        assertEquals(testCard.getPos(), mappedTrelloCard.getPos());
        assertEquals(testCard.getListId(), mappedTrelloCard.getListId());
    }

}