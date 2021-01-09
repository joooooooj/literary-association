package com.la.model.publish;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EditorRequestView {
    private String processInstanceId;
    private String taskId;
    private PublishBookRequest publishBookRequest;
}
