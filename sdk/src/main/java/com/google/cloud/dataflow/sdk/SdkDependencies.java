package com.google.cloud.dataflow.sdk;

import org.apache.beam.runners.dataflow.DataflowRunner;
import org.apache.beam.runners.direct.DirectRunner;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;

public class SdkDependencies {
    private Pipeline p;
    private BigQueryIO bigQueryIO;
    private DirectRunner directRunner;
    private DataflowRunner dataflowRunner;
}
