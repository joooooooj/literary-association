package com.la.service.impl;

import com.la.enumeration.PublishStatus;
import com.la.model.Genre;
import com.la.model.publish.PublishBookRequest;
import com.la.model.users.SysUser;
import com.la.model.users.Writer;
import com.la.repository.GenreRepository;
import com.la.repository.UserRepository;
import com.la.service.PublishBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PublishBookServiceImpl implements PublishBookService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GenreRepository genreRepository;

    public PublishBookRequest makePublishBookRequest(HashMap<String, Object> publishBookRequestMap, String writerUsername) {
        String title = (String) publishBookRequestMap.get("title");
        String synopsis = (String) publishBookRequestMap.get("synopsis");
        Long genreId = Long.parseLong((String) publishBookRequestMap.get("genre"));

        SysUser sysUser = userRepository.findByUsername(writerUsername);
        Genre genre = genreRepository.findById(genreId).get();

        PublishBookRequest publishBookRequest = new PublishBookRequest();
        publishBookRequest.setTitle(title);
        publishBookRequest.setSynopsis(synopsis);
        publishBookRequest.setGenre(genre.getValue());
        publishBookRequest.setWriter(sysUser.getUsername());

        return publishBookRequest;
    }
}
