package com.webService.utlis;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class csvLoader {

    private static final Logger logger = LogManager.getLogger(csvLoader.class);


    public <T> List<T> loadCSVtoPojo(Class<T> type, String fileName){
        try{
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues =
                    mapper.readerFor(type).with(schema).readValues(file);
            return readValues.readAll();
        }catch(Exception e){
            logger.error("Read the CSV has failed from " + fileName ,e);
            return Collections.emptyList();
        }
    }
}
