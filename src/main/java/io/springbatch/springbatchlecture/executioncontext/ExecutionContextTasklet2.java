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
//public class ExecutionContextTasklet2 implements Tasklet {
//    @Override
//    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//        System.out.println("step2 was executed");
//
//        ExecutionContext jobExecutionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
//        ExecutionContext stepExecutionContext = chunkContext.getStepContext().getStepExecution().getExecutionContext();
//
//        log.info("step2 jobName ::: {}", jobExecutionContext.get("jobName")); // step간 공유되기 때문에 보임
//        log.info("step2 stepName ::: {}", stepExecutionContext.get("stepName")); // stepExecutionContext는 step간 공유되지 않기때문에 보이지 않음
//
//        String stepName = chunkContext.getStepContext().getStepName();
//        if (stepExecutionContext.get("stepName") == null) {
//            stepExecutionContext.putString("stepName", stepName);
//        }
//
//        return RepeatStatus.FINISHED;
//    }
//}
