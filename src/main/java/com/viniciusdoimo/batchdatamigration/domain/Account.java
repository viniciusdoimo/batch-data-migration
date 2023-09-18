package com.viniciusdoimo.batchdatamigration.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Account {
    private int id;
    private int clientId;
    private int agency;
    private int account;
    private int bank;
}
