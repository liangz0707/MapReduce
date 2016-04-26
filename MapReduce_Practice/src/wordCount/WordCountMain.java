package wordCount;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

public class WordCountMain {
	
	public static void main(String[] args) {
		int result;
		try {
			args = new String[] {"wcin", "wcout"};
			Configuration config = new Configuration();
			File output = new File(args[1]);
			
			if(output.exists() && output.isDirectory()){
				FileUtils.deleteDirectory(output);
			}
			
			result = ToolRunner.run(config, new WordCountJob(), args);
			System.exit(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
