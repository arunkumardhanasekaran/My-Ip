# Infomation
You don't need to follow this document.

# Re generate the client
To generate the client jar : 
1st 
```sh
cd <path_to_this_folder>
```
then execute : 
```sh
java -jar ../openapi-generator-cli-6.6.0.jar generate -i ./httpbin.yaml --api-package lu.post.gen.v6.httpbin --model-package lu.post.gen.v6.httpbin.model --invoker-package lu.post.gen.v6.httpbin.invoker --group-id lu.post.gen.v6 --artifact-id httpbin-client --artifact-version 1.0-SNAPSHOT --generator-name java --library webclient --additional-properties=prependFormOrBodyParameters=true,hideGenerationTimestamp=true,java8=true,booleanGetterPrefix=is,dateLibrary=java8,useSpringBoot3=true,useJakartaEe=true -o httbin-client
```
then
```sh
cd httpbin-client 
```
and execute
```sh
mvn package
```
get the .jar from target folder.