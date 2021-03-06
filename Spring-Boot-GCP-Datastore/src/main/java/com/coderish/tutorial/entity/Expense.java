package com.coderish.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "expenses")
public class Expense {

    @Id
    Long id;

    String partnumber;

    String partdescription;

    int quantity;

    double priceperitem;

    double amount;
}