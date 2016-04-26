package wordCount;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;

public class WordCountJob extends Configured implements Tool{

	@Override
	public int run(String[] args) throws Exception {
		Job job = Job.getInstance(getConf(), "WordCountJob");
		//Configuration conf = job.getConfiguration();
		job.setJarByClass(getClass());
		Path in = new Path(args[0]);
		Path out = new Path(args[1]);
		FileInputFormat.addInputPath(job, in);
		FileOutputFormat.setOutputPath(job,  out);
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		return job.waitForCompletion(true) ? 0:1;
	}
}