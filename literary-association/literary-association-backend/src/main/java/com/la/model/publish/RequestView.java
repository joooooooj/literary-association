package com.la.model.publish;

import com.la.dto.FormFieldsDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestView {
    private String processInstanceId;
    private String taskId;
    private PublishBookRequest publishBookRequest;
}
