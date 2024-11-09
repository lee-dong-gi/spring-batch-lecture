//package io.springbatch.springbatchlecture.jobparameter;
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
//import java.util.Date;
//
///**
// * [수동으로 job을 실행, yml에서 아래 설정 필요]
// *
// *   batch:
// *     job:
// *       enabled: false
// *
// * [jar 실행 시]
// * java -jar spring-batch-lecture-0.0.1-SNAPSHOT.jar name=user1 seq(long)=2L date(date)=2021/01/01 age(double)=16.5
// *
// * [intellij 실행 시 ]
// * Program Argument에 name=user1 seq(long)=2L date(date)=2021/01/01 age(double)=16.5 넣고  아래 소스 주석,  yml에 자동 배치 실행 한 다음 실행
// */
//@Component
//@RequiredArgsConstructor
//public class JobParameterTest implements ApplicationRunner {
//    private final JobLauncher jobLauncher;
//    private final Job job;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addString("name", "user1")
//                .addLong("seq", 2L)
//                .addDate("date", new Date())
//                .addDouble("age", 16.3)
//                .toJobParameters();
//
//        jobLauncher.run(job, jobParameters);
//    }
//}
