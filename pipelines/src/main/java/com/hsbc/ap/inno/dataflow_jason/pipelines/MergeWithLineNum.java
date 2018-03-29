package com.hsbc.ap.inno.dataflow_jason.pipelines;

import org.apache.beam.runners.dataflow.DataflowRunner;
import org.apache.beam.runners.direct.DirectRunner;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergeWithLineNum {

    private static Pipeline p;


    public static void main(String args[]) {
//
//        p.apply(TextIO.Read.named("ReadFromText")
//                .from("gs://my_bucket/path/to/input-*.csv");

        // Start by defining the options for the pipeline.
        PipelineOptions options = PipelineOptionsFactory.create();

// Then create the pipeline.
//        Pipeline p = Pipeline.create(options);
        Pipeline p = Pipeline.create(
                PipelineOptionsFactory.fromArgs(args).withValidation().create());

        PCollection<String> lines_from_file_a = p.apply(
                "ReadLines", TextIO.read().from("gs://jasonlai_bucket1/JasonLai/input/a.csv"));

        PCollection<String> lines_from_file_b = p.apply(
                "ReadLines", TextIO.read().from("gs://jasonlai_bucket1/JasonLai/input/b.csv"))
                .apply("addlinenum",ParDo.of(new DoFn<String, String>() {
                    @ProcessElement
                    public void addLineNum(ProcessContext pc){
                        for(Integer i=0;pc.element()!=null;i++)
                        pc.element().concat(i.toString());
                    }
                }))
                ;


//        lines_from_file_a.
        lines_from_file_a.apply(TextIO.write().to("gs://jasonlai_bucket1/JasonLai/output/outputData.csv"));

        lines_from_file_b.apply(TextIO.write().to("gs://jasonlai_bucket1/JasonLai/output/outputData.csv"));
    }


//    PCollection<String> dbRowCollection = ...;
//
//    PCollection<String> aCollection = dbRowCollection.apply("aTrans", ParDo.of(new DoFn<String, String>(){
//        @DoFn.ProcessElement
//        public void processElement(ProcessContext c) {
//            if(c.element().startsWith("A")){
//                c.output(c.element());
//            }
//        }
//    }));
//
//    PCollection<String> bCollection = dbRowCollection.apply("bTrans", ParDo.of(new DoFn<String, String>(){
//        @ProcessElement
//        public void processElement(ProcessContext c) {
//            if(c.element().startsWith("B")){
//                c.output(c.element());
//            }
//        }
//    }));

}
