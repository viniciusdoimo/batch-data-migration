package com.viniciusdoimo.batchdatamigration.reader;

import com.viniciusdoimo.batchdatamigration.domain.Account;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class FileAccountReaderConfig {
    @Bean
    public FlatFileItemReader<Account> fileAccountReader() {
        return new FlatFileItemReaderBuilder<Account>()
                .name("fileAccountReader")
                .resource(new FileSystemResource("files/account.csv"))
                .delimited()
                .names("clientId", "agency", "account", "bank", "id")
                .addComment("--")
                .targetType(Account.class)
                .build();
    }
}
