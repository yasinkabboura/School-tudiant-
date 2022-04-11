package com.yasin.school_spring;

import com.yasin.school_spring.Repositories.EtudientRepository;
import com.yasin.school_spring.entities.Etudiant;
import com.yasin.school_spring.entities.Genre;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SchoolSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolSpringApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(EtudientRepository etudientRepository){
        return args ->{
            etudientRepository.save(new Etudiant(null,"Kabboura","Yasin","yasin@gmail.com",new Date(),Genre.MASCULIN,true));
            etudientRepository.save(new Etudiant(null,"Moustakim","Saad","Saad@gmail.com",new Date(),Genre.MASCULIN,true));
            etudientRepository.save(new Etudiant(null,"Rachidi","Ahmed","Ahmed@gmail.com",new Date(),Genre.MASCULIN,false));
            etudientRepository.save(new Etudiant(null,"Ahmadi","Salwa","Salwa@gmail.com",new Date(),Genre.FEMININ,true));

        };


    }

}
