package com.bam.bamcoreport.service;

import com.bam.bamcoreport.entity.UserContactInfo;
import com.bam.bamcoreport.repository.UserContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserContactInfoService {
    private final UserContactInfoRepository userContactInfoRepository;


    @Autowired
    public UserContactInfoService(UserContactInfoRepository userContactInfoRepository) {
        this.userContactInfoRepository = userContactInfoRepository ;
    }

    public List<UserContactInfo> getAllUserContactInfo() {
        return userContactInfoRepository.findAll();   }

    public void newUserContactInfo(UserContactInfo userContactInfo) {
        userContactInfoRepository.save(userContactInfo);
    }




}
