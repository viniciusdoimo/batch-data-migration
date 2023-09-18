package com.viniciusdoimo.batchdatamigration.step;


import com.viniciusdoimo.batchdatamigration.domain.Account;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class migrateAccountStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migrateAccountStep(
            ItemReader<Account> fileAccountReader,
            ItemWriter<Account> accountWriter){
        return stepBuilderFactory
                .get("migrateAccountStep")
                .<Account, Account>chunk(1)
                .reader(fileAccountReader)
                .writer(accountWriter)
                .build();
    }
}
