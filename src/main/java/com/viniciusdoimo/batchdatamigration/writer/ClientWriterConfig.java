package com.viniciusdoimo.batchdatamigration.writer;

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
public class ClientWriterConfig {
    @Bean
    public JdbcBatchItemWriter<Client> clientWriter(
            @Qualifier("appDataSource")
            DataSource dataSource
    ) throws SQLException {
        return new JdbcBatchItemWriterBuilder<Client>()
                .dataSource(dataSource)
                .sql("INSERT INTO client(id, name, email, dateBirth, age) VALUES (?, ?, ?, ?, ?)")
                .itemPreparedStatementSetter(itemPreparedStatementSetter())
                .build();
    }

    private ItemPreparedStatementSetter itemPreparedStatementSetter() throws SQLException {
        return new ItemPreparedStatementSetter<Client>() {
            @Override
            public void setValues(Client client, PreparedStatement ps) throws SQLException {
                ps.setInt(1, client.getId());
                ps.setString(2, client.getName());
                ps.setString(3, client.getEmail());
                //ps.setDate(4, new Date(client.getDateBirth().getTime()));
                ps.setString(4, client.getDateBirth().toString());
                ps.setInt(5, client.getAge());
            }
        };
    }

}
