#Spring cloud data flow server for openshift.

Uses https://github.com/donovanmuller/spring-cloud-dataflow-server-openshift



##Building

```mvn clean install```

##To build the docker image for the Data Flow Server

```mvn package docker:build -pl :spring-cloud-dataflow-server-openshift```



## Further Reading

Please see the following posts for more information:

* [Spring cloud Data Flow Doc](https://docs.spring.io/spring-cloud-dataflow/docs/current-SNAPSHOT/reference/htmlsingle/)
* [Spring Cloud Deployer OpenShift](http://blog.switchbit.io/spring-cloud-deployer-openshift)
