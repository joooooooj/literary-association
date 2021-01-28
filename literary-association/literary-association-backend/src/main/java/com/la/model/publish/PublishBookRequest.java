package com.la.model.publish;

import com.la.model.Genre;
import com.la.model.users.Editor;
import com.la.model.users.Writer;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PublishBookRequest implements Serializable {

    private String title;

    private String synopsis;

    private String editor;

    private String writer;

    private String genre;

    private String status;

    private String deadline;

    private String path;
}
