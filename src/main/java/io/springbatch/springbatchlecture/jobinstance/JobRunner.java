//package io.springbatch.springbatchlecture.jobinstance;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
///**
// * 수동으로 job을 실행, yml에서 아래 설정 필요
// *
// *   batch:
// *     job:
// *       enabled: false
// */
//@Component
//@RequiredArgsConstructor
//public class JobRunner implements ApplicationRunner {
//    private final JobLauncher jobLauncher;
//    private final Job job;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        JobParameters jobParameters = new JobParametersBuilder().addString("name", "user2")
//                .toJobParameters();
//
//        jobLauncher.run(job, jobParameters);
//    }
//}
