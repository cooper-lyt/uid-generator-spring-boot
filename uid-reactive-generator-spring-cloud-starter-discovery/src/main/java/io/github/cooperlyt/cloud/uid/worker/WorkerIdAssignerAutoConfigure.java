package io.github.cooperlyt.cloud.uid.worker;

import io.github.cooperlyt.cloud.uid.worker.client.DiscoveryClientAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.ConditionalOnDiscoveryEnabled;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ConditionalOnDiscoveryEnabled
public class WorkerIdAssignerAutoConfigure {

  @Bean
  @Lazy
  @ConditionalOnMissingBean
  public WorkerIdAssigner workerIdAssigner(DiscoveryClientAdapter discoveryClientAdapter){
    return new DiscoveryWorkerIdAssigner(discoveryClientAdapter);
  }
}
