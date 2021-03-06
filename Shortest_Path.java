/*
Post-COVID 19, an amusement park in New Delhi decided to open a maze for selected number of IIIT Delhi students. The maze was constructed in a grid shape with n rows and m columns, where the winner needs to enter from the top-left room and exit from bottom right room while going through the minimum number of rooms. 
In order to ensure that the task is not too trivial, the owner decided to divide the rooms in two categories and place volunteers in each room. A male volunteer will only let you pass if you hand him Item A and take Item B from him, while the female volunteer takes Item B and gives Item A. 
Before entering the maze the participants have a choice to choose either Item A or Item B. If every room has a door to every adjacent room, write an algorithm to find the minimum number of rooms the winner has to travel through in order to win. 
--------------------------------------------------------------------------------------------------------------------- 
INPUT: 
The first line of each test case contains the numbers n & m, denoting the size of the maze. The next n lines are strings of m characters describing if the room has a male (1) or a female volunteer(0). 
--------------------------------------------------------------------------------------------------------------------- 
OUTPUT: 
Simply output the number of rooms the winner has to travel through and ‘-1’ if no path exists. 
---------------------------------------------------------------------------------------------------------------------
EXAMPLE: INPUT: 
3 3 
011 
001 
000 
OUTPUT: 5
*/


import java.util.*;

class Shortest_Path {

static class Cordinates {
int x;
int y;

public Cordinates(int x, int y) {
this.x = x;
this.y = y;
}
};


static class Matrix_Cordinates {
Cordinates pt;
int distance; 

public Matrix_Cordinates(Cordinates pt, int distance) {
this.pt = pt;
this.distance = distance;
}
};


static boolean isCorrect(int row, int col,int ROW,int COL) {


return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
}


static int rowNum[] = { -1, 0, 0, 1 };
static int colNum[] = { 0, -1, 1, 0 };

// function to find the shortest path between

static int BFS(int mat[][], Cordinates src, Cordinates destination) {


boolean[][] visited = new boolean[mat.length][mat[0].length];


visited[src.x][src.y] = true;

// Create a queue for BFS
Queue<Matrix_Cordinates> q = new LinkedList<>();

// distanceance of source cell is 0
Matrix_Cordinates s = new Matrix_Cordinates(src, 0);
q.add(s); // Enqueue source cell

// ...................... BFS...............................
while (!q.isEmpty()) {
Matrix_Cordinates current = q.peek();
Cordinates pt = current.pt;


if (pt.x == destination.x && pt.y == destination.y)
return current.distance+1;


q.remove();

for (int i = 0; i < 4; i++) {
int row = pt.x + rowNum[i];
int col = pt.y + colNum[i];


if (isCorrect(row, col,mat.length,mat[0].length) && mat[pt.x][pt.y] != mat[row][col] && !visited[row][col]) {


visited[row][col] = true;
Matrix_Cordinates Adjcell = new Matrix_Cordinates(new Cordinates(row, col), current.distance + 1);
q.add(Adjcell);
}
}
}
return -1;

// Return -1 if destinationination cannot be reached

}

// Driver Code
public static void main(String[] args) {
int p,q;
Scanner s = new Scanner(System.in);
        System.out.print("Enter number of rows of maze");
        p = s.nextInt();
        System.out.print("Enter number of columns of maze");
        q = s.nextInt();
       
        int mat[][] = new int[p][q];
       
        System.out.println("Enter the elements of the maze");
        for(int i=0;i<p;i++)
        {
        for(int j=0;j<q;j++)
        {
        mat[i][j]=s.nextInt();
        }
        }

Cordinates source = new Cordinates(0, 0);
Cordinates destination = new Cordinates(p-1, q-1);

int distance = BFS(mat, source, destination);

if (distance != Integer.MAX_VALUE)
System.out.println("Shortest Path is ....and the winner got this path" + distance);
else
System.out.println("Shortest Path doesn't exist.............looser");
}
}
