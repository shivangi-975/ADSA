/*a. Design an adder using stack to add 2 big numbers and store the result as string.
You have to build the stack from scratch. (i.e. Do not use and pre-existing Java
Collection framework e.g. Stack class).
b. Write a program that would compute the factorial of a large number. (Do not use
any pre- existing library or function i.e. Do not use BigInteger or similar Classes
and functionalities.) (You have to use the adder in part 2a to compute the
factorial )
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stackaddoper {
int maxsize = 0;
int top = -1;
int array[] = new int[0];

public Stackaddoper(int size) {
maxsize = size;
array = new int[maxsize];
}

public void push(int x) {
top = top + 1;
array[top] = x;
}

public int pop() {
int elt = array[top];
top--;
return elt;

}

public boolean stackisfull() {
return (top == maxsize - 1);
}

public boolean stackisempty() {
return (top == -1);
}

public int peak() {
int peak = array[top];
return peak;
}

private static StringBuilder add(String number1, String number2) {

String temp = "";

if (number1.length() >= number2.length()) {
temp = number1;
number1 = number2;
number2 = temp;
}

Stackaddoper S1 = new Stackaddoper(number1.length());

for (int i = 0; i < number1.length(); i++) {
String str = Character.toString(number1.charAt(i));
S1.push(Integer.parseInt(str));
}

Stackaddoper S2 = new Stackaddoper(number2.length());

for (int i = 0; i < number2.length(); i++) {
String str = Character.toString(number2.charAt(i));
S2.push(Integer.parseInt(str));
}

Stackaddoper S3 = new Stackaddoper(number2.length() + 1);
int t = 0;
while (!S1.stackisempty() && !S2.stackisempty()) {
t = t + S1.pop() + S2.pop();
S3.push(t % 10);
t = t / 10;
}

if (!S1.stackisempty())

{
while (!S1.stackisempty()) {
S3.push(t + S1.pop());
t = 0;
}
}

if (!S2.stackisempty())

{
while (!S2.stackisempty()) {
S3.push(t + S2.pop());
t = 0;
}
}

if (t != 0) {
S3.push(t);
}
StringBuilder sb = new StringBuilder();

while (!S3.stackisempty()) {

sb.append(S3.pop());

}
return sb;
}

private static Integer getOption(String optionString) {
Integer option = 0;
try {
option = Integer.parseInt(optionString);
} catch (Exception e) {
}
return option;
}

public static void main(String args[]) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Adder using Stack..............");
System.out.println("1. Factorial");
System.out.println("2. Addition");
System.out.println("Please select a option");
String optionString = br.readLine();
Integer option = getOption(optionString);
if (option == 1) {
System.out.println("Enter the number");
String number1 = br.readLine();
System.out.println();

int j = 0;
int i = 0;

long num1 = Integer.parseInt(number1);
long num2 = num1 - 1;
long sum = 0;

while (num2 != 0) {
sum = 0;

while (j < num2) {
sum += Long.parseLong(add(Integer.toString(0), Long.toString(num1)).toString());
j++;
}

j = 0;

--num2;
num1 = sum;
}
System.out.println("Factorial is :" + sum);
}
if (option == 2) {
System.out.println("Enter the 1st number");
String number1 = br.readLine();
System.out.println("Enter the 2nd number");
String number2 = br.readLine();
System.out.println("Addition is :" + add(number1, number2));
}
}

}
