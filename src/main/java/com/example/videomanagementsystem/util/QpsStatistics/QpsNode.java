package com.example.videomanagementsystem.util.QpsStatistics;

import com.example.videomanagementsystem.cache.CacheNode;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Data
@Accessors(chain = true)
public class QpsNode implements Comparable {

    private String key;
    private AtomicLong callQuantity;
    private Long expireTime;

    public QpsNode() {}

    public QpsNode(String key, AtomicLong callQuantity, Long expireTime) {
        this.key = key;
        this.callQuantity = callQuantity;
        this.expireTime = expireTime;
    }

    @Override
    public int compareTo(Object o) {
        QpsNode qpsNode = (QpsNode) o;
        long diff = this.expireTime - qpsNode.expireTime;
        if (diff > 0) {
            return 1;
        }else if (diff < 0){
            return -1;
        }else {
            return 0;
        }
    }
}
