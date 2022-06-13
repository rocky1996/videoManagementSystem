package com.example.videomanagementsystem.kafkamq.mqBean;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TestLogMsg {
    private Long id;

    private String msg;

    private LocalDateTime sendTime;
}
