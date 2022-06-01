package edu.wgu.ai.job.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {
    public static final int MAX_CODE_LENGTH = 40;

    private int id;

//    @Size(min = 3, max=200)
//    @NotBlank
    private String name;

//    @Size(min = 3, max=MAX_CODE_LENGTH)
//    @NotBlank
//    @Pattern(regexp = "^[\\w_-]+$") // sqs compatible characters
    private String vendorCode;
//    @NotNull
    private JobActivityStatus status;

//    @CronPattern
    private String cron;
    private String cronHumanReadable;

//    @Valid
//    @Email
    private List<String> contactEmails;

    private Instant createdDate;
    private Instant updatedDate;
}
