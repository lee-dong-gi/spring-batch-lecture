//package io.springbatch.springbatchlecture.jobparameter;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Map;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class JobParameterConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job job() { // 자동으로 simple job 사용
//        return jobBuilderFactory.get("job")
//                .start(step1())
//                .next(step2())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//
//                        System.out.println("=========================");
//                        System.out.println(">> step1 executed");
//                        System.out.println("=========================");
//
//                        // 권장
//                        JobParameters jobParameters = stepContribution.getStepExecution().getJobExecution().getJobParameters();
//                        log.info("name ::: {}",jobParameters.getString("name"));
//                        log.info("seq ::: {}",jobParameters.getLong("seq"));
//                        log.info("date ::: {}",jobParameters.getDate("date"));
//                        log.info("age ::: {}",jobParameters.getDouble("age"));
//
//                        // 비추, 값 변경가능
//                        Map<String, Object> jobChunkParameters = chunkContext.getStepContext().getJobParameters();
//                        log.info("chunk name ::: {}",jobChunkParameters.get("name"));
//                        log.info("chunk seq ::: {}",jobChunkParameters.get("seq"));
//                        log.info("chunk date ::: {}",jobChunkParameters.get("date"));
//                        log.info("chunk age ::: {}",jobChunkParameters.get("age"));
//
//                        return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
//                    }
//                })
//                .build();
//    }
//
//    @Bean
//    public Step step2() {
//        return stepBuilderFactory.get("step2")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//
//                        System.out.println("=========================");
//                        System.out.println(">> step2 executed");
//                        System.out.println("=========================");
//
//                        return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
//                    }
//                })
//                .build();
//    }
//}
