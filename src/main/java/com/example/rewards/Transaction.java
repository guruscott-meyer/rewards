package com.example.rewards;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @JsonProperty("customerId")
    private int customerId;

    @JsonProperty("month")
    private Month month;

    @JsonProperty("total")
    private float total;

}
