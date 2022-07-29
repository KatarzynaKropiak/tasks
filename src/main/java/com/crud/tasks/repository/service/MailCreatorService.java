package com.crud.tasks.repository.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;


    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://katarzynakropiak.github.io/");
        context.setVariable("button", "Visit website");
        context.setVariable("show_button", true);
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("is_friend", false);
        context.setVariable("goodbye_message", "Have a great day :)");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("companyName", companyConfig.getCompanyName());
        context.setVariable("companyEmail", companyConfig.getCompanyEmail());
        context.setVariable("companyPhone", companyConfig.getCompanyPhone());
        context.setVariable("application_functionality", functionality);

        return templateEngine.process("mail/new-trello-card", context);
    }

    public String buildTrelloDailyNotificationEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://katarzynakropiak.github.io/");
        context.setVariable("button", "Visit website");
        context.setVariable("show_button", true);
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("is_friend", false);
        context.setVariable("goodbye_message", "Have a great day :)");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("companyName", companyConfig.getCompanyName());
        context.setVariable("companyEmail", companyConfig.getCompanyEmail());
        context.setVariable("companyPhone", companyConfig.getCompanyPhone());

        return templateEngine.process("mail/trello-daily-notification-mail", context);
    }

}
