package by.ladyka.dealsbot;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.Instant;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {

    @CreatedDate
    @Column(name = "create_time")
    private Instant createTime;

    @LastModifiedDate
    @Column(name = "last_modify_time")
    private Instant lastModifyTime;
}
