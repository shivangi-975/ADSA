import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Small_Element {

private static void printNSE(int[] arr, int n) {

int large, i, j;
for (i = 0; i < n; i++) {
large= -99;
for (j = i + 1; j < n; j++) {
if (arr[i] > arr[j]) {
large = arr[j];
break;
}
}
System.out.print(large+ " ");
}

}

public static void main(String[] args) throws NumberFormatException, IOException {

BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer sttoken = new StringTokenizer(input.readLine());
int i = 0;
List<Integer> list = new ArrayList<Integer>();
while (sttoken.hasMoreTokens()) {
list.add(Integer.parseInt(sttoken.nextToken()));
i++;
}
int[] arr = new int[list.size()];
for (int j = 0; j < arr.length; j++) {
arr[j] = list.get(j);

}
printNSE(arr, arr.length);

}

}

	
	
	
