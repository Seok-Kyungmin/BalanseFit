package com.balansefit.service;

import com.balansefit.dto.MailDTO;

public interface IMailService {

    //메일 발송
    int doSendMail(MailDTO pDTO);
}
