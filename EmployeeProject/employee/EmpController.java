package employee;

public abstract class EmpController implements PayStructure{
	// data declaration
		private String strEmpName;
		private String strEmpDesgination;
		private int nEmpId;
		private double dSalary;
		private double dBonus;
		private int nLeave;
		private int nOverTime;
		private double dLevDetuction;
		private double totSalary = -1;
		
		//properties for private data
		public String getStrEmpName() {
			return strEmpName;
		}
		public void setStrEmpName(String strEmpName) {
			this.strEmpName = strEmpName;
		}
		public String getStrEmpDesgination() {
			return strEmpDesgination;
		}
		public void setStrEmpDesgination(String strEmpDesgination) {
			this.strEmpDesgination = strEmpDesgination;
		}
		public int getNEmpId() {
			return nEmpId;
		}
		public void setNEmpId(int nEmpId) {
			this.nEmpId = nEmpId;
		}
		public double getDSalary() {
			return dSalary;
		}
		public void setDSalary(int dSalary) {
			this.dSalary = dSalary;
		}
		
		public EmpController(String strEmpName, String strEmpDesgination, int nEmpId) throws ExceptionMsg 
		{
			this.strEmpName = strEmpName.trim();
			this.strEmpDesgination = strEmpDesgination.trim();
			this.nEmpId = nEmpId;
			if(strEmpDesgination.toLowerCase().equalsIgnoreCase("softwaredeveloper")) {
				this.dSalary = 45000;
			}
			else if(strEmpDesgination.toLowerCase().equalsIgnoreCase("softwaretesting")){
				this.dSalary = 40000;
			}
			else if(strEmpDesgination.toLowerCase().equalsIgnoreCase("trainee")){
				this.dSalary = 25000;
			}
			else {
				throw new ExceptionMsg("Designation should be any of the below following list:\nsoftwaredeveloper\nsoftwaretesting\ntrainee");
			}
		}
		
		public void finalPay(int nOverTime, double dBonus, int nLeave, double dLevDeduction) {
			this.nOverTime = nOverTime;
			this.dBonus = dBonus;
			this.nLeave = nLeave;
			this.dLevDetuction = dLevDeduction;
			
			totSalary = (this.dSalary + dBonus) - dLevDeduction;
		}
		
		public void EmpDetailedStructure() {
			System.out.println("_________________________________");
			System.out.println("Employee Details");
			System.out.println("_________________________________");
			System.out.println("Employee Name       : " + this.getStrEmpName());
			System.out.println("Employee Id         : " + this.getNEmpId());
			System.out.println("Employee Designation: " + this.getStrEmpDesgination());
			System.out.println("Salary");
			System.out.println("\tBasic Pay         : " + this.dSalary);
			
			if(totSalary != -1) {
				System.out.println("\tLeaves taken       : " + this.nLeave);
				System.out.println("\tDeduction amount   : " + this.dLevDetuction);
				System.out.println("\t_________________________________");
				System.out.println("\tOver Time          : " + this.nOverTime);
				System.out.println("\tBonus pay          : " + this.dBonus);
				System.out.println("\t_________________________________");
				System.out.println("\tTotal Salary      : " +this.totSalary);
				
			}
			System.out.println("__________________________________________");
		}
}
