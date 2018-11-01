package Brd1;
import java.util.Scanner;
public class EmiMain {
	public static void main(String[] args) {
		double p;
		double r;// rate of interest
		int n;// no of installments for the tenure
		int t;// no of installments per year
		int m;// no of years|period
		double x ;// installment amount
		int rec = 1, hi;
		Scanner sc = new Scanner(System.in);
		OUT: do {

			System.out.println("Please enter the following details:\nLoan amount:");
			p = sc.nextDouble();
			System.out.println("Rate of interest in percent:");
			r = sc.nextDouble();
			System.out.println("Period or tenure of loan in months:");
			m = sc.nextInt();
			for (; m < 0;) {
				System.out.println("Months can't be negative right! Please enter positive number of months  ");
				m = sc.nextInt();

			}
			r = r / 100;
			System.out.println("Enter the number of payments for year:");
			t = sc.nextInt();
			// t=12;
			n = (m * t) / 12;
			if (n == 0) {
				System.out.printf("The installment for the given values is:%f\n", (p + p * r));
				// System.exit(0);
				continue OUT;
			}

			System.out.println(
					"Enter one among the following options:\n1.Calculate Installment for given conditions\n2.Want to know the principal component and interest component\n3.Installment for a given break up period:");
			hi = sc.nextInt();
			switch (hi) {
			case 1: {//
				x = installment(p, r, n, t); // calculation emi
				System.out.println(x);
				break;
			}
			case 2: {
				int bc = 0;
				double x1 = installment(p, r, n, t);
				IPComponent ip = new IPComponent(p, r, t, m, x1);
				ip.component(bc);
				break;
			}
			case 3: {
				double x1 = installment(p, r, n, t);
				System.out.println("Enter the month for which break up is required");
				int bc = sc.nextInt();
				IPComponent ip = new IPComponent(p, r, t, m, x1);
				ip.component(bc);
				break;
			}
			}
			System.out.println("\nDo you want to calculate for some other loan parameter values:\n1.yes\n2.no");
			rec = sc.nextInt();
//		for(int ni=0;ni<30;ni++)System.out.println();
			System.out.flush();
		} while (rec == 1);

	}

	static double installment(double p, double r, int n, int t) {
		double x1;
		x1 = (p * (r / t)) / (1 - 1 / Math.pow((1 + r / t), n));
		return x1;

	}

}
