package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.repository.service.MailCreatorService;
import com.crud.tasks.repository.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    @Autowired
    private MailCreatorService mailCreatorService;

    private final SimpleEmailService simpleEmailService;
    private final TaskRepository taskRepository;
    private final AdminConfig adminConfig;

    private static final String SUBJECT = "Tasks: Once a day email";

    @Scheduled(cron ="0 37 19 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        String singularOrPlural;
        if (size == 1L) {
            singularOrPlural = " task";
        } else {
            singularOrPlural = " tasks";
        }

        simpleEmailService.sendDaily(
                    Mail.builder()
                            .mailTo(adminConfig.getAdminMail())
                            .subject(SUBJECT)
                            .message("Currently in database you got: " + size + singularOrPlural)
                            .toCc(null)
                            .build()
            );
        }
    }
