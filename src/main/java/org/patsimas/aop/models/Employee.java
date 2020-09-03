package org.patsimas.aop.models;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String empId;
    private String firstName;
    private String secondName;
}
