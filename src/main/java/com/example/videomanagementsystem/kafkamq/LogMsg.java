package com.example.videomanagementsystem.kafkamq;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class LogMsg {
    private Long id;

    private String msg;

    private LocalDateTime sendTime;
}
