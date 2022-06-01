package edu.wgu.ai.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Valid
public class Job {
    public static final int MAX_CODE_LENGTH = 40;

    private int id;

    @Size(min = 3, max=200)
    @NotBlank
    private String name;

    @Size(min = 3, max=MAX_CODE_LENGTH)
    @NotBlank
    @Pattern(regexp = "^[\\w_-]+$") // sqs compatible characters
    private String vendorCode;
    @NotNull
    private JobActivityStatus status;

//    @CronPattern
    private String cron;
    private String cronHumanReadable;

    @Valid
    @Email
    private List<String> contactEmails;

    private Instant createdDate;
    private Instant updatedDate;
}
