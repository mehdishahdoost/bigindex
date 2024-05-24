package com.github.mehdishahdoost.mongodbapi;

import com.github.mehdishahdoost.mongodbapi.model.Address;
import com.github.mehdishahdoost.mongodbapi.model.Gender;
import com.github.mehdishahdoost.mongodbapi.model.Student;
import com.github.mehdishahdoost.mongodbapi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongodbApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address("Tehran", "Tehran", "Iran, Tehran");
            Student student = new Student("mehdi",
                    "shahdoost",
                    "mail@gmail.com",
                    Gender.MALE,
                    address,
                    List.of("Computer"),
                    BigDecimal.TEN,
                    LocalDateTime.now());
//            useQueryAndTemplate(studentRepository, mongoTemplate, student);
            studentRepository.findByEmail(student.getEmail()).ifPresentOrElse(s -> {
                System.out.println("This student exists by email " + s);
            }, () -> {
                studentRepository.insert(student);
            });
        };
    }

    private void useQueryAndTemplate(StudentRepository studentRepository, MongoTemplate mongoTemplate, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(student.getEmail()));
        List<Student> students = mongoTemplate.find(query, Student.class);
        if (students.size() > 1) {
            throw new IllegalStateException("Find more than one student for email:" + student.getEmail());
        }
        studentRepository.insert(student);
    }

}
