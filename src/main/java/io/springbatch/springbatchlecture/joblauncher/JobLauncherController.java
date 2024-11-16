//package io.springbatch.springbatchlecture.joblauncher;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.JobParametersInvalidException;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.launch.support.SimpleJobLauncher;
//import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
//import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
//import org.springframework.batch.core.repository.JobRestartException;
//import org.springframework.boot.autoconfigure.batch.BasicBatchConfigurer;
//import org.springframework.core.task.SimpleAsyncTaskExecutor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//
//@RestController
//@RequiredArgsConstructor
//public class JobLauncherController {
//
//    private final Job job;
//    private final JobLauncher jobLauncher;
//    private final BasicBatchConfigurer basicBatchConfigurer;
//
//    // 동기적 방식 -> 3초 후에 응답함
//    @PostMapping("/batch")
//    public String launch(@RequestBody Member member) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
//
//        JobParameters parameters = new JobParametersBuilder()
//                .addString("id", member.getId())
//                .addDate("date", new Date())
//                .toJobParameters();
//
//        SimpleJobLauncher jobLauncher = (SimpleJobLauncher) basicBatchConfigurer.getJobLauncher();
//        jobLauncher.run(job, parameters);
//
//        return "batch completed";
//    }
//
//    // 비동기적 방식 -> 곧바로 응답함
//    @PostMapping("/batch-async")
//    public String launchAsync(@RequestBody Member member) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
//
//        JobParameters parameters = new JobParametersBuilder()
//                .addString("id", member.getId())
//                .addDate("date", new Date())
//                .toJobParameters();
//
//        SimpleJobLauncher jobLauncher = (SimpleJobLauncher) basicBatchConfigurer.getJobLauncher();
//        //SimpleJobLauncher jobLauncher = (SimpleJobLauncher) this.jobLauncher; // SimpleJobLauncher 프록시는 객체이기때문에 JobLauncher를 SimpleJobLauncher로 타입캐스팅이 안됨
//        jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
//        this.jobLauncher.run(job, parameters);
//
//        return "batch-async completed";
//    }
//}
