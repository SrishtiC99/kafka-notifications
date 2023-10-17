package com.srishti.adminservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BobNotification {
    private String name;
    private String msg;
    private Long number;
    private double balance;
    private Address address;
}
