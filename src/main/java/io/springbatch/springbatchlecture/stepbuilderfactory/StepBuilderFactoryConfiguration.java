//package io.springbatch.springbatchlecture.stepbuilderfactory;
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
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.item.*;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class StepBuilderFactoryConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job batchJob() { // 자동으로 simple job 사용
//        return jobBuilderFactory.get("batchJob")
//                .incrementer(new RunIdIncrementer()) // 기본 제공
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
//                .<String, String>chunk(3)
//                .reader(() -> null)
//                .processor((ItemProcessor<String, String>) s -> null)
//                .writer(list -> {
//
//                })
//                .build();
//    }
//
//    @Bean
//    public Step step3() {
//        return stepBuilderFactory.get("step3")
//                .partitioner(step1())
//                .gridSize(2)
//                .build();
//    }
//
//    @Bean
//    public Step step4() {
//        return stepBuilderFactory.get("step4")
//                .job(job())// 스텝이 job을 호출함
//                .build();
//    }
//
//    @Bean
//    public Step step5() {
//        return stepBuilderFactory.get("step5")
//                .flow(flow())
//                .build();
//    }
//
//    @Bean
//    public Job job() {
//        return jobBuilderFactory.get("job")
//                .start(step1())
//                .next(step2())
//                .next(step3())
//                .build();
//    }
//
//    @Bean
//    public Flow flow() {
//        FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("flow");
//        flowBuilder.start(step2()).end();
//        return flowBuilder.build();
//    }
//}
