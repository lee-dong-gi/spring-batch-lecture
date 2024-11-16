package io.springbatch.springbatchlecture.batchinitialize;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * - BatchAutoConfiguration 에서 job application runner 를 빈으로 등록
 * - JobApplicationRunner에서 setJobs라는 메서드에서 전달한 job을 세팅
 * - JobApplicationRunner에서 run 메서드를 실행 여기서 args를 받아서 넣음(프로그램 변수)
 * - JobApplicationRunner에서 launchJobFromProperties에서 프로그램변수를 JobParameter로 변환해서 job에 세팅
 * - JobApplicationRunner에서 excuteLocalJobs에서드로 job 들을 실행
 * -
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class BatchInitializeConfigurationSecond {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job2() { // 자동으로 simple job 사용
        return jobBuilderFactory.get("batchJob2")
                .start(step3())
                .next(step4())
                .build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(">> step3 executed");
                        return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
                    }
                })
                .build();
    }

    @Bean
    public Step step4() {
        return stepBuilderFactory.get("step4")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println(">> step4 executed");
                    return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
                })
                .build();
    }
}
