package com.javainfinity.spring.data.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Builder
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name="name",
                column = @Column(name = "guardian_name")
        ),

        @AttributeOverride(
                name="email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name="mobile",
                column = @Column(name = "guardian_mobile")
        ),
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
