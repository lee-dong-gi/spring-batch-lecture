//package io.springbatch.springbatchlecture.jobbuilder;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.builder.FlowBuilder;
//import org.springframework.batch.core.job.flow.Flow;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class JobBuilderConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;

//    @Bean
//    public Job job1() { // 자동으로 simple job 사용
//        return jobBuilderFactory.get("batchJob1")
//                .start(step1())
//                .next(step2())
//                .build();
//    }

//    @Bean
//    public Job flowJob1() {
//        return jobBuilderFactory.get("batchJob2")
//                .start(flow())
//                .next(step5())
//                .end()
//                .build();
//    }

//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println(">> step1 executed");
//                        return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
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
//                    return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
//                })
//                .build();
//    }

//    @Bean
//    public Flow flow() {
//        FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("flow");
//        flowBuilder
//                .start(step3())
//                .next(step4())
//                .end();
//
//        return flowBuilder.build();
//    }
//
//    @Bean
//    public Step step3() {
//        return stepBuilderFactory.get("step3")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println(">> step3 executed");
//                        return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
//                    }
//                })
//                .build();
//    }
//
//    @Bean
//    public Step step4() {
//        return stepBuilderFactory.get("step4")
//                .tasklet((contribution, chunkContext) -> {
//                    System.out.println(">> step4 executed");
//                    return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
//                })
//                .build();
//    }
//
//    @Bean
//    public Step step5() {
//        return stepBuilderFactory.get("step5")
//                .tasklet((contribution, chunkContext) -> {
//                    System.out.println(">> step5 executed");
//                    return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
//                })
//                .build();
//    }
//}
