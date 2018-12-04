package com.webService.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Service
public class ReadFiles {

    public ReadFiles(FedSchoolRepository fedSchoolRepository){
     this.fedSchoolRepository = fedSchoolRepository;   
    }
    
    private void pullData(){
    
        StringReader reader = new StringReader(input);
        CsvToBean<FedSchool> csv = new CsvToBeanBuilder<FedSchool>(reader)
            .withType(FedSchool.class)
            .withSkipLines(1)
            .build();
        FedSchoolRepository,saveAll(csv.parse());
    }
    public<T> void parseFile(String input, T cls){
        if(cls.getClass().isInstance(FedSchool.class)) {
           pullData(input);
        }
}
