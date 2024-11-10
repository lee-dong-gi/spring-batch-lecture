//package io.springbatch.springbatchlecture.stepcontribution;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
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
///**
// * TaskletStep.java -> doInTransaction -> createStepContribution
// * StepExecution.java의 finally구문에서 apply메서드를 이용해서 DB에 커밋 직전에 적용
// */
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class StepContributionConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job job() { // 자동으로 simple job 사용
//        return jobBuilderFactory.get("job")
//                .start(step1())
//                .next(step2())
//                .next(step3())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("step1 was executed");
//                        return RepeatStatus.FINISHED;
//                    }
//                })
//                .build();
//    }
//
//    @Bean
//    public Step step2() {
//        return stepBuilderFactory.get("step2")
//                .tasklet((contribution, chunkContext) -> {
//                    System.out.println(">> step2 executed");
////                    throw new RuntimeException("step2 failed"); // 이 경우 step3의 step execution은 생성되지 않음, 다시 주석하고 재실행 시 step2와 step3가 실행됨
//                    return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
//                })
//                .build();
//    }
//
//    @Bean
//    public Step step3() {
//        return stepBuilderFactory.get("step3")
//                .tasklet((contribution, chunkContext) -> {
//                    System.out.println(">> step3 executed");
//                    return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
//                })
//                .build();
//    }
//}
