import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

public class HW2Mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
    @Override
    public void map(LongWritable longWritable, Text text, OutputCollector<Text, Text> outputCollector, Reporter reporter) throws IOException {
        String line = text.toString();
        String[] data = line.split(",");

        if (data.length >= 11) {
            String model = data[7];
            String range = data[10];
            outputCollector.collect(new Text(model), new Text(range));
        } else {
            System.err.println("Invalid data line: " + line);
        }
    }
}
