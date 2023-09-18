package com.viniciusdoimo.batchdatamigration.reader;

import com.viniciusdoimo.batchdatamigration.domain.Client;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import java.util.Date;

@Configuration
public class FileClientReaderConfig {
    @Bean
    public FlatFileItemReader<Client> fileClientReader() {
        return new FlatFileItemReaderBuilder<Client>()
                .name("fileClientReader")
                .resource(new FileSystemResource("files/client.csv"))
                .delimited()
                .names("name", "email", "dateBirth", "age", "id")
                .addComment("--")
                .fieldSetMapper(fieldMapper())
                .targetType(Client.class)
                .build();
    }

    private FieldSetMapper<Client> fieldMapper() {
        return fieldSet -> {
            Client client = new Client();
            client.setName(fieldSet.readString("name"));
            client.setEmail(fieldSet.readString("email"));
           //client.setDateBirth(new Date(fieldSet.readDate("dateBirth", "yyyy-MM-dd HH:mm:ss").getTime()));
            client.setEmail(fieldSet.readString("dateBirth"));
            client.setAge(fieldSet.readInt("age"));
            client.setId(fieldSet.readInt("id"));
            return client;
        };
    }

}
