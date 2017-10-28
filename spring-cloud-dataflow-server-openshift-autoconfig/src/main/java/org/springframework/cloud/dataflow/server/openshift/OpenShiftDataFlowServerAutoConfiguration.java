package org.springframework.cloud.dataflow.server.openshift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.deployer.resource.docker.DockerResourceLoader;
import org.springframework.cloud.deployer.resource.maven.MavenProperties;
import org.springframework.cloud.deployer.resource.maven.MavenResourceLoader;
import org.springframework.cloud.deployer.resource.support.DelegatingResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class OpenShiftDataFlowServerAutoConfiguration {

  @Autowired
  private MavenProperties mavenProperties;

  @Bean
  public DelegatingResourceLoader delegatingResourceLoader() {
    DockerResourceLoader dockerLoader = new DockerResourceLoader();
    Map<String, ResourceLoader> loaders = new HashMap<>();
    loaders.put("docker", dockerLoader);
    loaders.put("maven", new MavenResourceLoader(mavenProperties));
    return new DelegatingResourceLoader(loaders);
  }
}
