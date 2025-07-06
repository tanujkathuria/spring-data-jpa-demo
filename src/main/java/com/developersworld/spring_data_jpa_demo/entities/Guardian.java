package com.developersworld.spring_data_jpa_demo.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name= "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name= "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name= "mobile",
                column = @Column(name = "guardian_mobile")
        )

})
@Builder
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}
