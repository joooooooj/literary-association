package com.la.model.publish;

import com.la.model.users.Reader;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BetaReadersEditor {
    private String processInstanceId;
    private String taskId;
    private List<Reader> readerList;
}
