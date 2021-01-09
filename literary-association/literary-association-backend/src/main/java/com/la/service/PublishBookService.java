package com.la.service;

import com.la.model.publish.PublishBookRequest;

import java.util.HashMap;

public interface PublishBookService {

    PublishBookRequest makePublishBookRequest(HashMap<String, Object> publishBookRequestMap, String writerUsername);

}
