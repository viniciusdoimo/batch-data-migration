package com.viniciusdoimo.batchdatamigration.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class Client {
    private int id;
    private String name;
    private String email;
    private String dateBirth;
    private int age;
}
