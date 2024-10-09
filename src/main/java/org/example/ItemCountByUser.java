package org.example;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ItemCountByUser {
    private Long userId;
    private Long count;
}