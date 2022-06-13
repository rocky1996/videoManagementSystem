package com.example.videomanagementsystem.kafkamq.mqBean;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Builder
public class LogMsg {
    private Long id;

    private String msg;

    private LocalDateTime sendTime;
}
