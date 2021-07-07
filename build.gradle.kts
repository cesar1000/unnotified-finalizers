val finalizer = tasks.register("finalizer")

val task = tasks.register("task") {
    finalizedBy(finalizer)
    doLast {
        for (finalizer in finalizedBy.getDependencies(null)) {
            println("Task has finalizer: $finalizer.")
        }
    }
}
