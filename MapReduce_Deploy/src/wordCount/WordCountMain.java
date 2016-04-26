package wordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;
import wordCount.WordCountJob;

public class WordCountMain {
	
	public static void main(String[] args) {
		int result;
		try {
			Configuration config = new Configuration();
			result = ToolRunner.run(config, new WordCountJob(), args);
			System.exit(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
