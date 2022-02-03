package com.kt.caike.job;

import com.kt.caike.member.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MemberRepository memberRepository;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .start(step1()) //STEP 1 실행
                .on("FAILED")// STEP 1 결과가 FAILED 일 경우
                .end()// 종료
                .from(step1()) // STEP1 의 결과로부터
                .on("*") // FAILED 를 제외한 모든 경우
                .to(step2()) // STEP 2로 이동 후 실행
                .on("FAILED")// STEP 2의 결과가 FAILED 일 경우
                .end()// 종료
                .from(step2()) // STEP2 의 결과로부터
                .on("*") // FAILED 를 제외한 모든 경우
                .to(step3()) // STEP 3로 이동 후 실행
                .next(step4()) // STEP 3의 결과에 상관없이 STEP 4 실행
                .on("*") // STEP4 의 모든 결과에 상관없이
                .end() // FLOW 종료
                .end() // JOB 종료
                .build();
    }

    @Bean
    public Step step1(){
        return null;
    }
    @Bean
    public Step step2(){
        return null;
    }
    @Bean
    public Step step3(){
        return null;
    }
    @Bean
    public Step step4(){
        return null;
    }
}
