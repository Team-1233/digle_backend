package com.example.one2three3.domain.accident.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private String content;

    private String temporaryAccount;

    private AccidentState state;

    private AccidentType type;

    private LocalDateTime time;

    public static Accident generate(String location, String content, String typeName) {
        AccidentType type = AccidentType.valueOf(typeName);

        return Accident.builder()
                .temporaryAccount("")
                .location(location)
                .content(content)
                .state(AccidentState.GENERATION)
                .type(type)
                .time(LocalDateTime.now())
                .build();
    }

    public void end() {
        this.state = AccidentState.END;
    }
}
