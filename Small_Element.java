/*You are given a list/array of integers, for each position ‘i’ find the next element on the  right of ‘i’ whose value is strictly less than the value present at position ‘i’. Print -99  if any such element does not exist. (Weightage: 30% ) 
Example1:  
Input: 5 3 4 1 7 2 1 100 
Output: 3 1 1 -99 2 1 -99 -99 
Explanation: 
For Index 0, the current element is 5 and next value smaller than 5 is 3, hence 3 is the output. For Index 1, the element is 3 and immediate next value smaller than 3 is element 1 at index 3. 
For Index 4, the element is 1 and there exists no such value on the right of 1 whose value is strictly less than 1, hence we print -99. 
Example 2: 
Input: 9 4 11 2 1 0 
Output: 4 2 2 1 0 -99*/


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

	
	
	
