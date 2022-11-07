package by.ladyka.dealsbot;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "log_activity")
public class LogEntity extends BaseEntityWithId {
    private String messageText;
}
