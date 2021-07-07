# An attempt to use finalizedBy during task execution is not notified

This repros a bug where using finalizers during task execution is not notified as buggy when running with the configuration cache. If the task is loaded from the cache, the set of finalizers is empty:

```
$ ./gradlew :task --configuration-cache
Configuration cache is an incubating feature.
Calculating task graph as no configuration cache is available for tasks: :task

> Task :task
Task has finalizer: task ':finalizer'.

BUILD SUCCESSFUL in 594ms
1 actionable task: 1 executed
Configuration cache entry stored.

$ ./gradlew :task --configuration-cache
Configuration cache is an incubating feature.
Reusing configuration cache.

BUILD SUCCESSFUL in 585ms
1 actionable task: 1 executed
Configuration cache entry reused.
```
