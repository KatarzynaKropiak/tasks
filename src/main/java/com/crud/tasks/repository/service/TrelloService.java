package com.crud.tasks.repository.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;


@Service
@Component
@RequiredArgsConstructor
public class TrelloService {

    @Autowired
    private MailCreatorService mailCreatorService;

    private static final String SUBJECT = "Tasks: New Trello card";
    private final TrelloClient trelloClient;
    private final AdminConfig adminConfig;
    private final SimpleEmailService simpleEmailService;

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createTrelloCard(final TrelloCardDto trelloCardDto) {
        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);

        ofNullable(newCard).ifPresent(card->
                simpleEmailService.send(Mail.builder()
                        .mailTo(adminConfig.getAdminMail())
                        .subject(SUBJECT)
                        .message("New card: " + trelloCardDto.getName() + " has been created on your Trello account")
                        .toCc(null)
                        .build()
        ));

        return newCard;
    }
}