/*
Sonu works for a firm. Due to corona pandemic, he has to work from his home during lockdown. Each  day he is assigned a set of jobs by his supervisor, each associated with some number (job id). He then  performs some operations on the jobs based on orders he receives from his supervisor. He has modeled  the jobs as a Linked list in his system. 
1. If the supervisor asks him to reschedule the first x jobs to the end, he performs the below  operation:  
L x - removes x items from the start and attaches them to the end of the linked list. For e.g. if the operation is L 3 and the current state of linked list is 6 7 4 3 , then 3 elements are removed  one by one from the left and attached to the end i.e. the state of the linked list changes as 7 4 3 6 , then  4 3 6 7 then 3 6 7 4. 
2. If the supervisor asks him to reschedule the last x jobs to the beginning, he performs the below  operation: 
R x - removes x items from the end and attaches them to the start of the linked list. For e.g. if the operation is R 3 and the current state of linked list is 6 7 4 3 , then 3 elements are removed  one by one from the right and attached to the start i.e. the state of the linked list changes as 3 6 7 4, then  4 3 6 7 then 7 4 3 6. 
3. If the supervisor asks him to remove a job completely, he performs the below operation: 
D i - deletes the element at the ith position of the linked list assuming the start of the linked list has  i=0. No deletion operation is performed if the ith element is not present. 
Your task is to output the final list of his jobs at the end of the day. 
Input 
The first line of the input contains of a single integer N denoting the number of jobs assigned to Sonu  on a particular day. 
The second line contains N space separated numbers corresponding to the id of the jobs. 
The next line contains a number O, that represents the number of orders/operations that Sonu receives  from his supervisor on a given day. Each of the next O lines consists of operations in the format given  above. 
Output 
Your output should be space separated numbers that represents the elements of the final linked list of  jobs in an appropriate order. 
Constraints:  
1<= x, N, JobId, O <=1000 
Sample test case: 
Input 
4  
6 4 3 8 
5  
L 5 
R 1 
R 2  
L 2 
D 2 
Output: 
6 4 8 
Explanation: 
6 , 4 , 3 and 8 are the job id’s of the four jobs 
After L 5 operation, the linked list looks like: 4 3 8 6 
After R 1 operation, the linked list looks like: 6 4 3 8 
After R 2 operation, the linked list looks like: 3 8 6 4 
After L 2 operation, the linked list looks like: 6 4 3 8 
After D 2 operation, the linked list looks like: 6 4 8 
6 4 8 is the final value. 
Input:  
1 
10 
1  
D 0  
Output: 
-1
*/
package linked_oper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node_Op {
int val;
Node_Op next;

Node_Op() {
}

Node_Op(int val) {
this.val = val;
}

Node_Op(int val, Node_Op next) {
this.val = val;
this.next = next;
}

@Override
public String toString() {
return "Node_Op [val=" + val + ", next=" + next + "]";
}

}

public class Linked_List_Operations{
static Node_Op head;

static Node_Op push(Node_Op head_ref, int new_data) {
head = new Node_Op();
head.val = new_data;
head.next = (head_ref);
(head_ref) = head;
return head_ref;
}

public static Node_Op delete_from_end_front(Node_Op head, int k) {

if (head == null)
return null;
if (head.next == null)
return head;

Node_Op tail_begin = head;
int n;
for (n = 1; tail_begin.next != null; n++)
tail_begin = tail_begin.next;
tail_begin.next = head;

Node_Op tail_after = head;
for (int i = 0; i < n - k % n - 1; i++)
tail_after = tail_after.next;
Node_Op new_head = tail_after.next;
tail_after.next = null;

return new_head;
}

public static Node_Op Delete_from_front_end(Node_Op head, int k) {

if (head == null)
return null;
if (head.next == null)
return head;

Node_Op tail_begin = head;

for (int n = 1; tail_begin.next != null; n++)
tail_begin = tail_begin.next;
tail_begin.next = head;

Node_Op tail_after = head;
for (int i = 0; i < k - 1; i++)
tail_after = tail_after.next;
Node_Op new_head = tail_after.next;

tail_after.next = null;

return new_head;
}

static Node_Op deleteNodeAtPosition(Node_Op head, int position) {
if(head != null) {
if (position == 0)
return head.next;
else {
Node_Op tmp = head;
int i = 1;
while (i < position && tmp.next!=null) {
tmp = tmp.next;
i++;
}
if (tmp.next.next != null)
tmp.next = tmp.next.next;
else
tmp.next = null;
}
}
return head;
}

static void printList(Node_Op node) {
while (node != null) {
System.out.print(node.val + " ");
node = node.next;
}
//System.out.print("null");
System.out.println("");
}

public static void main(String[] args) throws NumberFormatException, IOException {
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
int noofJobs = Integer.parseInt(input.readLine());
if (noofJobs >= 1 && noofJobs < 1000) {
int[] jobIDS = new int[noofJobs];
StringTokenizer sttoken = new StringTokenizer(input.readLine());
int i = 0;
List<Integer> list = new ArrayList<Integer>();
while (sttoken.hasMoreTokens()) {
jobIDS[i] = Integer.parseInt(sttoken.nextToken());
list.add(jobIDS[i]);
i++;
}
System.out.println("List is ::" + list);

Node_Op head = null;

for (int k = list.size() - 1; k >= 0; k--) {
head = push(head, list.get(k));
}

String NoOfOperations = input.readLine();
System.out.println("input" + NoOfOperations);
int opeartionNum = Integer.parseInt(NoOfOperations);

if (opeartionNum >= 1 && opeartionNum <= 1000) {
for (int j = 0; j < Integer.parseInt(NoOfOperations); j++) {
StringTokenizer typeOfOperationstoken = new StringTokenizer(input.readLine());
while (typeOfOperationstoken.hasMoreTokens()) {
String typeOfDeletion = typeOfOperationstoken.nextToken();
String noOfTimesDelete = typeOfOperationstoken.nextToken();
int noOfTimesShift = Integer.parseInt(noOfTimesDelete);
System.out.println("typeOfDeletion" + typeOfDeletion);
System.out.println("noOfTimesDelete" + noOfTimesDelete);
if (noOfTimesShift >= 1 && noOfTimesShift <= 1000) {
switch (typeOfDeletion) {
case "R":
if (noOfTimesShift >= 1 && noOfTimesShift <= 1000) {
head = delete_from_end_front(head, noOfTimesShift);
printList(head);
}
break;
case "L":
head = Delete_from_front_end(head, noOfTimesShift);
printList(head);
break;
case "D":
head = deleteNodeAtPosition(head, noOfTimesShift);
printList(head);
break;
}
} else {
System.out.println("Shifting cannot exceed the size of the list!!..");
}

}
}
} else {
System.out.println("No.of operations cannot exceed 1000");
}
} else {
System.out.println("No. of Jobs cannot exceed 1000");
}

}
}
