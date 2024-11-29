//package io.springbatch.springbatchlecture.prevent;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.DefaultJobParametersValidator;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class JobPreventRestartConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//    /**
//     * SimpleJobLauncher의 아래 구문 참조
//     *
//     * if (!job.isRestartable()) {
//     *
//     */
//    @Bean
//    public Job batchJob() { // 자동으로 simple job 사용
//        return jobBuilderFactory.get("batchJob")
//                .start(step1())
//                .next(step2())
//                .preventRestart() // 아무런 값을 넣지 않으면 기본값 false, 두번째 실행 시 JobInstance already exists and is not restartable 에러 발생
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
//                .tasklet((contribution, chunkContext) -> {
//                    System.out.println(">> step2 executed");
//                    throw new RuntimeException("step2 was failed");
////                    return RepeatStatus.FINISHED; // 한번만 실행되고 종료함
//                })
//                .build();
//    }
//}
