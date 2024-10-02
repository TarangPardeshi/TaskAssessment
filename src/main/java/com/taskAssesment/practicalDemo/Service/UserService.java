package com.taskAssesment.practicalDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.taskAssesment.practicalDemo.Entity.User;
import com.taskAssesment.practicalDemo.Repo.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private EmailService emailService;

    public User createUser(User user) {

        User savedUser = userRepository.save(user);

        emailService.sendSimpleEmail(
            savedUser.getEmail(),               
            "Welcome to Our Platform",          
            "Hello " + savedUser.getName() + ", welcome to our platform!"  
        );
        return savedUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private void sendEmail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Welcome!");
        message.setText("Dear " + user.getName() + ", welcome to our platform.");
        mailSender.send(message);
    }
}
