package edu.wgu.ai;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
//@CronAllowEmpty
public class Job { // implements JobSchedule, CronAllowEmptyChecker {
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
    private List<@Email String> contactEmails;

    @Email
    private String contactEmail;

//    private Instant createdDate;
//    private Instant updatedDate;

//    @Override public boolean allowCronEmpty() {
//        return getStatus() != JobActivityStatus.ACTIVE;
//
}
