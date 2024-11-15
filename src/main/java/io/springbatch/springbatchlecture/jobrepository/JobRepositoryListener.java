//package io.springbatch.springbatchlecture.jobrepository;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class JobRepositoryListener implements JobExecutionListener {
//    private final JobRepository jobRepository;
//
//    @Override
//    public void beforeJob(JobExecution jobExecution) {
//
//    }
//
//    @Override
//    public void afterJob(JobExecution jobExecution) {
//        String jobName = jobExecution.getJobInstance().getJobName();
//
//        JobParameters param = new JobParametersBuilder()
//                .addString("requestDate", "20210104")
//                        .toJobParameters();
//
//        JobExecution lastJobExecution = jobRepository.getLastJobExecution(jobName, param); // JobParameters가 일치하는 것중 가장 최근 job을 가져옴
//        if (lastJobExecution != null) {
//            for (StepExecution execution : lastJobExecution.getStepExecutions()) {
//               BatchStatus status = execution.getStatus();
//               log.info("status ::: {}", status);
//
//               ExitStatus exitStatus = execution.getExitStatus();
//               log.info("exitStatus ::: {}", exitStatus);
//
//               String stepName = execution.getStepName();
//               log.info("stepName ::: {}", stepName);
//            }
//        }
//    }
//}
