package com.la.model.publish;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BetaReaderComment {

    private Date deadline;

    private String text;

    private String reader;
}
