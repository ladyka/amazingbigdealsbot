package by.ladyka.dealsbot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class DealsBotService {
    private final LogRepository logRepository;

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            log.info(String.valueOf(update.getMessage()));
            LogEntity logEntity = new LogEntity();
            logEntity.setMessageText(update.getMessage().getText());
            LogEntity entity = logRepository.save(logEntity);
            log.debug(Objects.requireNonNull(entity).getId());


            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId().toString());
            sendMessage.setText("Well, all information looks like noise until you break the code.");
        }
    }
}
