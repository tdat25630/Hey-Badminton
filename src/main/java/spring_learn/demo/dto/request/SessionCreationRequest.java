package spring_learn.demo.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionCreationRequest {
    private String description;


}
