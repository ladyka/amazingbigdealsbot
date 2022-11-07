package by.ladyka.dealsbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@EnableJpaRepositories
@SpringBootApplication
public class DealsBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DealsBotApplication.class, args);
    }

    @Autowired
    DealsBotConfiguration dealsBotConfiguration;


    @EventListener(ApplicationReadyEvent.class)
    public void telegram() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(dealsBotConfiguration);
    }

}
