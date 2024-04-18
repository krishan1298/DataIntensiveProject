import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

public class HW2Reducer extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
    @Override
    public void reduce(Text text, Iterator<Text> iterator, OutputCollector<Text, Text> outputCollector, Reporter reporter) throws IOException {
        int count = 0;
        int maxRange = Integer.MIN_VALUE;

        while (iterator.hasNext()) {
            Text value = iterator.next();
            int range = Integer.parseInt(value.toString());

            count++;

            if (range > maxRange) {
                maxRange = range;
            }
        }
        String maxRangeStr = Integer.toString(maxRange);

        outputCollector.collect(text, new Text(count + " | " + maxRangeStr));
    }
}
