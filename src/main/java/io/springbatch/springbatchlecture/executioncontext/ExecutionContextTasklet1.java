//package io.springbatch.springbatchlecture.executioncontext;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.item.ExecutionContext;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class ExecutionContextTasklet1 implements Tasklet {
//    @Override
//    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//        System.out.println("step1 was executed");
//
//        ExecutionContext jobExecutionContext = stepContribution.getStepExecution().getJobExecution().getExecutionContext();
//        ExecutionContext stepExecutionContext = stepContribution.getStepExecution().getExecutionContext();
//
//        String jobName = chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobName();
//        String stepName = chunkContext.getStepContext().getStepExecution().getStepName();
//
//        if (jobExecutionContext.get("jobName") == null) {
//            jobExecutionContext.putString("jobName", jobName);
//        }
//
//        if (stepExecutionContext.get("stepName") == null) {
//            stepExecutionContext.putString("stepName", stepName);
//        }
//
//        log.info("step1 jobName ::: {}", jobExecutionContext.get("jobName"));
//        log.info("step1 stepName ::: {}", stepExecutionContext.get("stepName"));
//
//        return RepeatStatus.FINISHED;
//    }
//}
