package employee;

public class EmpSalary extends EmpController implements PayStructure 
{
	public double dLevDetuction;
	
	public EmpSalary(String strEmpName, String strEmpDesgination, int nEmpId) throws ExceptionMsg {
		super(strEmpName, strEmpDesgination, nEmpId);
	}


	@Override
	public void calculateSalary(EmpController obj, int nOverTime, int nLeave) throws NegativeException, ExceptionMsg 
	{
		int nBonus = 0;
		double tempSal = obj.getDSalary();
		
		//1 day = 24hrs, Normal working hr is 8hr. So, 24hrs -8hrs = 16hrs.
		//with this 16hr maximum 10hr is overtime period. so enter working hr with in 10hrs.
		if(nOverTime < 11) {
			if (nOverTime >= 0) {
				// Bonus amount for perHr = 100rs
				nBonus = nOverTime * 100;
			} else {
				throw new NegativeException("Over Time Working hr Should not be -Ve");
			}
		}
		else {
			throw new ExceptionMsg("Over Time Working hr Should not be more than 10");
		}
		
		//Calculate leave 
		calculateLeave(nLeave, tempSal);
		
		obj.finalPay(nOverTime, nBonus, nLeave, dLevDetuction);
	}

	private void calculateLeave(int nLeave, double tempSal) throws ExceptionMsg, NegativeException 
	{
		if(nLeave > 0) {
			
			if (nLeave >= 25) { //If leave has more than 24days, deducts full basic pay salary
				dLevDetuction = tempSal;
			} else if (nLeave >= 15) { //If leave has 16 to 24 days, deducts half salary
				dLevDetuction = tempSal / 2;
			} else if (nLeave >= 0) { //If leave has 0 to 14 days, deducts 500rs per day
				dLevDetuction = (nLeave * 500);
			} else { // leave days should not be more than 30
				throw new ExceptionMsg("leave should not be more than 30days");
			}
		}else {
			throw new NegativeException("Leave days Should not be -Ve");
		}
	}	

}
