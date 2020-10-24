//Shivangi Parashar AI20MTECH14012
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Exponentiation{
//calculating power recursively........T(C)=log(n)
private static BigInteger power(BigInteger x, BigInteger y) {
BigInteger myvar;
if (y.compareTo(BigInteger.valueOf(0))==0) {
return BigInteger.valueOf(1);
}
myvar = power(x, y.divide(BigInteger.valueOf(2)));
if (y.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) ==0)
return myvar.multiply(myvar);
else
return x.multiply(myvar).multiply(myvar);

}
//Logic for calculating kth root of number n using binary search T(C)=logn
private static BigInteger Rootcalc(BigInteger start, BigInteger end, BigInteger N, BigInteger K) {

if (start.compareTo(end)<=0){
//calculate mid	
BigInteger mid = (start.add(end)).divide(BigInteger.valueOf(2)) ;
BigInteger power=power(mid, K);
BigInteger powerAdd=power(mid.add(BigInteger.valueOf(1)), K);

if ((power.compareTo(N) <=0) && (powerAdd.compareTo(N) > 0)) {
return mid;
} else if (power.compareTo(N)<1){
//If the Kth power of mid happens to be  less than equal to N, than update search to [mid + 1, end]
return Rootcalc(mid.add(BigInteger.valueOf(1)), end, N, K);
} else {
//If the Kth power of mid happens to be greater than N, then update search to [low, mid + 1]
return Rootcalc(start, mid.subtract(BigInteger.valueOf(1)), N, K);
}

}
return start;
}

public static void main(String[] args) throws NumberFormatException, IOException {
//Take input from user
InputStreamReader in = new InputStreamReader(System.in);
BufferedReader reader = new BufferedReader(in);
int noOfInputs = Integer.parseInt(reader.readLine());
System.out.println("No of inputs" + noOfInputs);
for(int i=0; i < noOfInputs; i++) {
StringTokenizer str = new StringTokenizer(reader.readLine());
//big integer class is used to avoid overflow problems
BigInteger N = new BigInteger(str.nextToken());
BigInteger K = new BigInteger(str.nextToken());
//constraints check
if(N.intValue()<= Math.pow(10, 16) && 1<=K.intValue()&& K.intValue()<=N.intValue())
System.out.println("Rootcalc :: " + Rootcalc(BigInteger.valueOf(0), N, N, K));
else {
	System.out.println("Constarints Viaolation n>10^6 or k>n ...............Invalid inputs");
}
}

}
}

