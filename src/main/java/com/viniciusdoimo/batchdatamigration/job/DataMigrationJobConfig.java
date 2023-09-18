package com.viniciusdoimo.batchdatamigration.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class DataMigrationJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job dataMigrationJob(
            @Qualifier("migrateClientStep")
            Step migrateClientStep,
            @Qualifier("migrateAccountStep")
            Step migrateAccountStep
    ) {
        return jobBuilderFactory
                .get("DataMigrationJob")
                .start(migrateClientStep)
                .next(migrateAccountStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}