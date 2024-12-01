//package io.springbatch.springbatchlecture.incrementer;
//
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.JobParametersIncrementer;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class CustomJobParametersIncrementer implements JobParametersIncrementer {
//    static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-hhmmss");
//
//    @Override
//    public JobParameters getNext(JobParameters jobParameters) {
//        String id = sdf.format(new Date());
//        // job이 실행될때마다 sdf에서 만든 새로운 아이디가 적용되어서 시작됨
//        return new JobParametersBuilder().addString("run.id",id).toJobParameters();
//    }
//}
