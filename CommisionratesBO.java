package com.cts.cbc.Bo;

public class CommisionratesBO {

		public float getCommissionRateforSelling(float totalPrice){
					if(totalPrice>=500 && totalPrice<=1000)
						return (float) 0.018;
					else if(totalPrice>=1001 && totalPrice<=2000)
						return (float) 0.025;
					else if(totalPrice>=2001 && totalPrice<=5000)
						return (float) 0.034;
					else if(totalPrice>=5001 && totalPrice <= 10000)
						return (float) 0.04;
					else if(totalPrice>=10001 && totalPrice <= 20000)
						return (float) 0.073;
					else if(totalPrice >= 20001 && totalPrice <= 40000)
						return (float) 1.1;
					else if(totalPrice >= 40001 && totalPrice <= 80000)
						return (float) 1.5;
					else
						return (float) 2.0;
		}
		public float getconversionRateByUsrId(int userId){
			return 0;
		}
}
