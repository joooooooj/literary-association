package com.la.model.publish;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BetaReaderComment implements Serializable {

    private String text;

    private String reader;
}
