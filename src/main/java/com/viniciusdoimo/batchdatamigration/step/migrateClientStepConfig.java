package com.viniciusdoimo.batchdatamigration.step;

import com.viniciusdoimo.batchdatamigration.domain.Client;
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
public class migrateClientStepConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migrateClientStep(
            ItemReader<Client> fileClientReader,
            ItemWriter<Client> clientWriter) {
                return stepBuilderFactory
                        .get("migrateClientStep")
                        .<Client, Client>chunk(1)
                        .reader(fileClientReader)
                        .writer(clientWriter)
                        .build();
    }
}
