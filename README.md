# demo.mdc

Logging global traceId in Spring Boot with Mapped Diagnostic Context (MDC)

Added trace ID to the Slf4J MDC, so you can extract all the logs from a given trace in a log aggregator, as shown in the following example logs:

```
2016-02-02 15:30:57.902  INFO [6bfd228dc00d216b] 23030 --- [nio-8081-exec-3] ...
2016-02-02 15:30:58.372 ERROR [6bfd228dc00d216b] 23030 --- [nio-8081-exec-3] ...
2016-02-02 15:31:01.936  INFO [46ab0d418373cbc9] 23030 --- [nio-8081-exec-4] ...
```
Propagation mechanism includes default logic to join a trace across HTTP over request headers.
TraceId is extracted from HTTP headers, to start or join an existing trace. 

Injecting trace information into the outbound requests is not implemented. But you can do it simple in to the any place:

```String traceId = MDC.get("Header-name");```

The default way of coding tracing context is done via the `X-Token` HTTP header: 

`X-Token: 6bfd228dc00d216b`

If the `X-Token` is not present in the request header, propagation mechanism generates value for it at the beginning of the request.

You can change request header key: in the `application.properties` file set value `slf4jfilter.request-header=`.
