package com.javainfinity.spring.data.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "tbl_student",uniqueConstraints =
                  @UniqueConstraint(
                          name = "emailid_unique"
                          ,columnNames = "email_address"))
public class Student {

    @Id //primary key
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address",nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;




}
