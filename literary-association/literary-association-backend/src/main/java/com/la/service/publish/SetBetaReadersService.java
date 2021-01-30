package com.la.service.publish;

import com.la.model.users.Reader;
import com.la.model.users.SysUser;
import com.la.repository.ReaderRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetBetaReadersService implements JavaDelegate {

    @Autowired
    ReaderRepository readerRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<Reader> readerList = readerRepository.findByBetaIsTrue();
        delegateExecution.setVariable("betaBefore", readerList);
    }
}
