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