package ClassMath;

public class Ecuaciones {
	private double pres=0.0001;
	private double pi=truncate(Math.PI,pres);
	private double e=truncate((Math.E),pres);


	public double truncate(double x, double precision) {
		double v=1/precision;
		int tmp=(int) (x*v);
		double res= ((double)tmp)/v;
		//System.out.println("res: "+res);
		return res;
	}


	public double ecu4(double[] xs) {
		double result = 0.0;
		double xi;
		for(int i = 1; i <= xs.length; i++) {	
			xi=xs[i-1];

			double a=((i+1)*Math.pow(xi, 2))/pi;
			double b=Math.pow(Math.sin(a), 20);

			result +=  Math.sin(xi)* b; 
		}

		return -result;
	}


	public double ecu3(double[] xs) {
		double x1=0,x2=0,a=0.0,b=0.0;
		if(xs==null) {
			return 0;
		}
		
		if(xs[1]<0 && xs[2]<0) {
			
			
			x1=xs[0]*-1;
			
			int top=(int)xs[2];

			return a*b;
		}
		
		System.out.println(xs[0]+" ; "+xs[1]+"; length: "+xs.length);
		
		if(xs.length==3&& xs[0]>0 && xs[1]>0) {
			
			x1=xs[0];
			x2=xs[1];
			int top=(int)xs[2];

			 
			for(int i =1; i <= top; i++) {
				a+=i*Math.cos((i+1)*x1+i);
			}

			
			for(int i = 1; i <= top; i++) {
				b+=i*Math.cos((i+1)*x2+i);
			}

		}
		return a*b;

	}

	public double ecu2(double[] xs) {
		if(xs != null && xs.length==2 && xs[0]>0 && xs[1]>0)
		{
			double x2=xs[1];
			double x1=xs[0];
			return 21.5+x1*Math.sin(4*pi*x1)+x2*Math.sin(20*pi*x2);
		}
		return 0;



	}


	public double ecu1(double[] entrada) {
		double x1=entrada[0];
		double x2=entrada[1];
		double a=Math.sqrt(Math.abs(x2+(x1/2.0)+47));
		double b=Math.sqrt(Math.abs(x1-(x2+47)));
		return -(x2+47)*Math.sin(a)-x1*Math.sin(b);
	}

	public double ecu0(double[] entrada) {
		if(entrada==null) {
			return 0;
		}else {
			
			double x=entrada[0];
			x=truncate(x, pres);
			//System.out.println("entrada: "+x);
			double a = 20.0 *  Math.pow(e,(-0.2*Math.abs(x)));
			a=truncate(a, pres);
			//System.out.println("a: "+a);
			double b = Math.pow(e, Math.cos(2*pi*x));
			b=truncate(b, pres);
			//System.out.println("b: "+b);
			return -(20 + e - a - b);
		}
		
		
	}


	public double ecu5(double[] entrada) {
		// TODO Auto-generated method stub
		if(entrada == null) {
			return 0;
		}
		double x=1;
		for(int i=0; i<entrada.length; i++) {
			double num=0;
			if(entrada[i]>100 && entrada[i] <200) {
				if(entrada[i]%2==0) {
					num=entrada[i]*2;
				}else {
					num=entrada[i];
				}
			}
			x*=num;
		}
		return x;
	}

	public double ecu6(double[] entrada) {
		// TODO Auto-generated method stub
		if(entrada == null) {
			return 0;
		}
		double x=0;
		for(int i=0; i<entrada.length; i++) {
			double num=0;
			if(entrada[i]<0) {
				if(entrada[i]%2==0) {
					num=entrada[i];
				}else {
					num=entrada[i] * -1;
				}
			}
			x+=entrada[i];
		}
		return x;
	}


}
