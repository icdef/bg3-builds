package org.freetime.me.bg3builds.config;

import lombok.RequiredArgsConstructor;
import org.freetime.me.bg3builds.dto.LootItemProcessor;
import org.freetime.me.bg3builds.entity.LootItem;
import org.freetime.me.bg3builds.listener.JobCompletionNotificationListener;
import org.freetime.me.bg3builds.mapper.LootItemMapper;
import org.freetime.me.bg3builds.persistence.LootItemRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {

    @Value("${file.input}")
    private String fileInput;
    private final LootItemRepository lootItemRepository;
    private final LootItemMapper lootItemMapper;


    @Bean
    public Job importLootItemsJob(JobRepository jobRepository, Step importLootItemsStep, JobCompletionNotificationListener listener) {
        return new JobBuilder("importLootItemsJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(importLootItemsStep)
                .build();
    }

    @Bean
    public Step importLootItemsStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("importLootItemsStep", jobRepository)
                .<LootItem, LootItem>chunk(100, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public LootItemProcessor processor() {
        return new LootItemProcessor(lootItemRepository, lootItemMapper);
    }

    @Bean
    public FlatFileItemReader<LootItem> reader() {
        BeanWrapperFieldSetMapper<LootItem> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(LootItem.class);
        return new FlatFileItemReaderBuilder<LootItem>().name("itemLootItemReader")
                .resource(new ClassPathResource(fileInput))
                .delimited()
                .delimiter(",")
                .names("itemName", "itemEffect", "itemSource", "location", "act")
                .linesToSkip(1)
                .fieldSetMapper(beanWrapperFieldSetMapper)
                .build();
    }

    @Bean
    public ItemWriter<LootItem> writer() {
        return lootItemRepository::saveAll;
    }

}