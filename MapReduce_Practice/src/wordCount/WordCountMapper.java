package wordCount;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String currentLine = value.toString();
		String[] words = currentLine.split(" ");
		//System.out.println("mapping");
		for (String word : words) {
			Text outputKey = new Text(word);
			context.write(outputKey, new IntWritable(1));
		}
	}
}