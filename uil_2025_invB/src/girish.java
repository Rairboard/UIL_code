import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class girish {
    public static void main(String[] args) throws Exception {
        new girish().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("girish").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		List<long[]> al = new ArrayList<>();
		List<Double> sortedMedian = new ArrayList<>();
		double totalSum = 0, totalCnt = 0;
		Map<Long,Long> frequency = new HashMap<>() ;
        while(f.hasNext()){
			String ln = f.nextLine();
			if(ln.equals("-".repeat(10))){
				break;
			}
			long[] ar = Arrays.stream(ln.split("\\s+")).mapToLong(Long::parseLong).toArray();
			double sum = 0;
			int cnt = 0;
			for (int i = 0; i < ar.length; i++) {
				sum+=ar[i];
				cnt++;
				frequency.put(ar[i], frequency.getOrDefault(ar[i],0L)+1);
			}
			Arrays.sort(ar);
			totalSum+=sum;
			totalCnt++;
			sum/=cnt;
			sortedMedian.add(sum);
			al.add(ar);
		}
		totalSum/=totalCnt;
		Collections.sort(sortedMedian);
		if(sortedMedian.size()%2==0){
			out.printf("Median Mean: %.2f\n", (sortedMedian.get(sortedMedian.size()/2-1) + sortedMedian.get(sortedMedian.size()/2))/2.0);
		}
		else{
			out.printf("Median Mean: %.2f\n", sortedMedian.get(sortedMedian.size()/2));
		}
		out.printf("Mean Sum: %.2f\n", totalSum);
		List<long[]> mostOccur =new ArrayList<>();
		for(Long number : frequency.keySet()){
			mostOccur.add(new long[]{number,frequency.get(number)});
		}
		Collections.sort(mostOccur, (a,b) -> Long.compare(b[1],a[1]));
		out : for (int i = 0; i < mostOccur.size(); i++) {
			long number = mostOccur.get(i)[0];
			for (int j = 0; j < al.size(); j++) {
				boolean found = false;
				for (int k = 0; k < al.get(j).length; k++) {
					if(al.get(j)[k]==number){
						found = true;
						break;
					}
				}
				if(!found){
					out.printf("Mode Kinda: %d\n", number);
					break out;
				}
			}
		}
        f.close();
    }
}
