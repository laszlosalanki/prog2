import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class LexerData {
	String[] a = {"4", "4", "@", "/-\\"};
	String[] b = {"b", "8", "|3", "|}"};
	String[] c = {"c", "(", "<", "{"};
	String[] d = {"d", "|)", "|]", "|}"};
	String[] e = {"3", "3", "3", "3"};
	String[] f = {"f", "|=", "pf", "|#"};
	String[] g = {"g", "6", "[", "[+"};
	String[] h = {"h", "4", "|-|", "[-]"};
	String[] i = {"1", "1", "|", "!"};
	String[] j = {"j", "7", "_|", "_/"};
	String[] k = {"k", "|<", "1<", "|{"};
	String[] l = {"l", "1", "|", "|_"};
	String[] m = {"m", "44", "(V)", "|\\/|"};
	String[] n = {"n", "|\\|", "/\\/", "/V"};
	String[] o = {"0", "0", "()", "[]"};
	String[] p = {"p", "/o", "|D", "|o"};
	String[] q = {"q", "9", "O_", "(,)"};
	String[] r = {"r", "12", "12", "|2"};
	String[] s = {"s", "5", "$", "$"};
	String[] t = {"t", "7", "7", "'|'"};
	String[] u = {"u", "|_|", "(_)", "[_]"};
	String[] v = {"v", "\\/", "\\/", "\\/"};
	String[] w = {"w", "VV", "\\/\\/", "(/\\)"};
	String[] x = {"x", "%", ")(", ")("};
	String[] y = {"y", "y", "y", "y"};
	String[] z = {"z", "2", "7_", ">_"};
	String[] a0 = {"D", "0", "D", "0"};
	String[] a1 = {"I", "I", "L", "L"};
	String[] a2 = {"Z", "Z", "Z", "e"};
	String[] a3 = {"E", "E", "E", "E"};
	String[] a4 = {"h", "h", "A", "A"};
	String[] a5 = {"S", "S", "S", "S"};
	String[] a6 = {"b", "b", "G", "G"};
	String[] a7 = {"T", "T", "j", "j"};
	String[] a8 = {"X", "X", "X", "X"};
	String[] a9 = {"g", "g", "j", "j"};
}

public class LexerJava {
	
	LexerData ld = new LexerData();
	Random rand = new Random();
	
	public LexerJava() {
		
		while (true) {
			String sor = readLine();
			if(sor.isEmpty())
				break;
			sor = sor.toLowerCase();
			String kesz = "";
			for(int i = 0; i < sor.length(); ++i) {
				char c = sor.charAt(i);
				if(c == 'a') {
					kesz += ld.a[getRandInRange(0, 4)];
				} else if (c == 'b') {
					kesz += ld.b[getRandInRange(0, 4)];
				} else if (c == 'c') {
					kesz += ld.c[getRandInRange(0, 4)];
				} else if (c == 'd') {
					kesz += ld.d[getRandInRange(0, 4)];
				} else if (c == 'e') {
					kesz += ld.e[getRandInRange(0, 4)];
				} else if (c == 'f') {
					kesz += ld.f[getRandInRange(0, 4)];
				} else if (c == 'g') {
					kesz += ld.g[getRandInRange(0, 4)];
				} else if (c == 'h') {
					kesz += ld.h[getRandInRange(0, 4)];
				} else if (c == 'i') {
					kesz += ld.i[getRandInRange(0, 4)];
				} else if (c == 'j') {
					kesz += ld.j[getRandInRange(0, 4)];
				} else if (c == 'k') {
					kesz += ld.k[getRandInRange(0, 4)];
				} else if (c == 'l') {
					kesz += ld.l[getRandInRange(0, 4)];
				} else if (c == 'm') {
					kesz += ld.m[getRandInRange(0, 4)];
				} else if (c == 'n') {
					kesz += ld.n[getRandInRange(0, 4)];
				} else if (c == 'o') {
					kesz += ld.o[getRandInRange(0, 4)];
				} else if (c == 'p') {
					kesz += ld.p[getRandInRange(0, 4)];
				} else if (c == 'q') {
					kesz += ld.q[getRandInRange(0, 4)];
				} else if (c == 'r') {
					kesz += ld.r[getRandInRange(0, 4)];
				} else if (c == 's') {
					kesz += ld.s[getRandInRange(0, 4)];
				} else if (c == 't') {
					kesz += ld.t[getRandInRange(0, 4)];
				} else if (c == 'u') {
					kesz += ld.u[getRandInRange(0, 4)];
				} else if (c == 'v') {
					kesz += ld.v[getRandInRange(0, 4)];
				} else if (c == 'w') {
					kesz += ld.w[getRandInRange(0, 4)];
				} else if (c == 'x') {
					kesz += ld.x[getRandInRange(0, 4)];
				} else if (c == 'y') {
					kesz += ld.y[getRandInRange(0, 4)];
				} else if (c == 'z') {
					kesz += ld.z[getRandInRange(0, 4)];
				} else if (c == '0') {
					kesz += ld.a0[getRandInRange(0, 4)];
				} else if (c == '1') {
					kesz += ld.a1[getRandInRange(0, 4)];
				} else if (c == '2') {
					kesz += ld.a2[getRandInRange(0, 4)];
				} else if (c == '3') {
					kesz += ld.a3[getRandInRange(0, 4)];
				} else if (c == '4') {
					kesz += ld.a4[getRandInRange(0, 4)];
				} else if (c == '5') {
					kesz += ld.a5[getRandInRange(0, 4)];
				} else if (c == '6') {
					kesz += ld.a6[getRandInRange(0, 4)];
				} else if (c == '7') {
					kesz += ld.a7[getRandInRange(0, 4)];
				} else if (c == '8') {
					kesz += ld.a8[getRandInRange(0, 4)];
				} else if (c == '9') {
					kesz += ld.a9[getRandInRange(0, 4)];
				} else {
					kesz += c;
				}
			}
			
			System.out.println(kesz);
		}
		
	}
	
	public int getRandInRange(int min, int max) {
		return rand.ints(min, max).findAny().getAsInt();
	}
	
	public String readLine() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
	
	public static void main(String[] args) {
		
		new LexerJava();
	}
}
