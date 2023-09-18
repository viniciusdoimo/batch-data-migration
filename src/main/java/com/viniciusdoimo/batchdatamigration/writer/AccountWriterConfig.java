package com.viniciusdoimo.batchdatamigration.writer;

import com.viniciusdoimo.batchdatamigration.domain.Account;
import com.viniciusdoimo.batchdatamigration.domain.Client;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class AccountWriterConfig {
    @Bean
    public JdbcBatchItemWriter<Account> AccountWriter(
            @Qualifier("appDataSource")
            DataSource dataSource
    ) {
        return new JdbcBatchItemWriterBuilder<Account>()
                .dataSource(dataSource)
                .sql("INSERT INTO account(id, clientId, agency, account, bank) VALUES (:id, :clientId, :agency, :account, :bank)")
                .beanMapped()
                .build();
    }

}
