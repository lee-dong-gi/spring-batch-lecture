package io.springbatch.springbatchlecture.tasklet;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class TaskletConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job batchJob() { // 자동으로 simple job 사용
        return jobBuilderFactory.get("batchJob")
                .incrementer(new RunIdIncrementer()) // 기본 제공
//                .start(taskStep())
                .start(chunkStep())
                .build();
    }

    @Bean
    public Step taskStep() {
        return stepBuilderFactory.get("taskStep")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println(">> step1 executed");
                    return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
                })
                .build();
    }

    /**
     * 출력 내용
         A
         B
         C
         D
         E
     */
    @Bean
    public Step chunkStep() {
        return stepBuilderFactory.get("chunkStep")
                .<String, String> chunk(1)
                .reader(new ListItemReader<>(Arrays.asList("a","b","c","d","e")))
                .processor(((ItemProcessor<String, String>) String::toUpperCase))
                .writer(items -> items.forEach(System.out::println))
                .build();
    }
}
