package com.example.user.service;

import com.example.user.VO.Department;
import com.example.user.VO.ResponseTemplateVO;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        //you can use this url too: http://localhost:9001/departments/
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
