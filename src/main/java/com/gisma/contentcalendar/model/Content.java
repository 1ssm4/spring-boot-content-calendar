package com.gisma.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;



@Builder
public record Content
        (
                @Id
                Integer id,

                @NotBlank
                String title,

                String desc,
                Status status,
                Type contentType,
                LocalDateTime dateCreated,
                LocalDateTime dateUpdated,
                String url
        )
{


}

