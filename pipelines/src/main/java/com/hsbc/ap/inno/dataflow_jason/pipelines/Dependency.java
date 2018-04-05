package com.hsbc.ap.inno.dataflow_jason.pipelines;

import org.apache.beam.examples.MinimalWordCount;
import org.apache.beam.examples.WordCount;
import com.google.cloud.dataflow.sdk.SdkDependencies;

/**
 * Mark the examples dependencies as used at compile time. This is also needed
 * to produce some content in the final JAR file.
 */
class PipelineDependencies {
    SdkDependencies sdkDependencies;
    MergeWithLineNum m1;
}
