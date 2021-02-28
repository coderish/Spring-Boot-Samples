# Spring-boot-gcp-datastore

 - `Open Google Cloud Shell`
 - `git clone https://github.com/coderish/Spring-Boot-Samples.git`
### Deploy in Cloud Run : 
 - docker build . -t gcr.io/redhand-303707/owl
 - docker images
 - docker push gcr.io/redhand-303707/owl

### Deploy in App Engine :
 - cd Spring-Boot-Samples/Spring-Boot-GCP-Datastore
 - mvn clean install -DskipTests=true
 - gcloud app deploy target/spring-boot-gcp-datastore.jar
 - gcloud app logs tail -s default
 - gcloud app browse
