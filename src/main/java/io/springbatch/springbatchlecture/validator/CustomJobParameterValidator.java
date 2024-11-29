//package io.springbatch.springbatchlecture.validator;
//
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersInvalidException;
//import org.springframework.batch.core.JobParametersValidator;
//
//public class CustomJobParameterValidator implements JobParametersValidator {
//
//    // JobRepository에 기능이 시작하기 전 단계에서 검증
//    // Job이 실행되기전에 검증
//    // 총 2번 검증이 수행됨
//    @Override
//    public void validate(JobParameters jobParameters) throws JobParametersInvalidException {
//        if (jobParameters.getString("name") == null) {
//            throw new JobParametersInvalidException("name parameters is not found");
//        }
//    }
//}
