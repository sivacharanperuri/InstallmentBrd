package Brd1;

public class IPComponent {
	double p, r;
	int t, m;
	double x2;
	int count1 = 0,count2=0;

	public IPComponent(double p, double r, int t, int m, double x2) {
		this.p = p;	this.r = r;	this.t = t;	this.m = m;	this.x2 = x2;
  }

	void component(int bc) {
			float[] in = new float[m + 1];
			float[] pn = new float[m + 1];
			float[] op = new float[m + 1];
			op[0] = (float) p;
			for (int l = 0; l < m; l++) {
				in[l] = (op[l]) * ((float) r) /12.0f;                 //((float)t*12.0f);        
				pn[l] = ((float) x2 - in[l]);
				if (l < m) {
					op[l + 1] = op[l] - pn[l];
					if (count1++ == 0&&bc==0)
						System.out.println("s.no          O/s   \t     I               P         Installment");
					if (bc == 0)
						System.out.printf("%d\t%10.2f\t%10.2f\t%10.2f\t%10.2f\n", (l + 1), op[l], in[l], pn[l], x2);
				} else {
					op[m] = op[l] - pn[l];
				}

			}
			if (bc != 0) {
				int b1 = bc - 1;
				try {
					if (m >= bc)

					{
						if (count2++ ==0)

							System.out.println("\ns.no          O/s   \t     I               P         Installment");
					}
					System.out.printf("%d\t%10.2f\t%10.2f\t%10.2f\t%10.2f\n", (b1), op[b1], in[b1], pn[b1], x2);
				} catch (IndexOutOfBoundsException ex1) {
					System.out.printf(
							"You entered the tenure for \"%d months\" and trying to retrieve the break component for the month of \"%dth month\"!\n",
							m, bc);
				}
			}

	}

}
