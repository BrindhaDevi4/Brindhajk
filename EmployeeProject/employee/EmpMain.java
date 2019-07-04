package employee;

public class EmpMain{

	public static void main(String args[])
	{
		/* Rules
		 * 
		 * 1.Overtime value should not be -ve.
		 * 2.Overtime value Should not be more than 10.
		 * 
		 * 3.leave value should not be -ve.
		 * 4.leave value should not be more than 30.
		 */
		try {
			EmpController obj = new EmpSalary("AA","SoftwareDeveloper",100);
			obj.EmpDetailedStructure();
			System.out.println("\n---------------------------------------------------------\n");
			obj.calculateSalary(obj,/*OverTime*/ 10, /*leave*/ 3 );
			obj.EmpDetailedStructure();
			
			System.out.println("\n---------------------------------------------------------");
			System.out.println("---------------------------------------------------------");
			System.out.println("---------------------------------------------------------");
			
			EmpController obj1 = new EmpSalary("BB","softwaretesting",101);
			obj1.EmpDetailedStructure();
			System.out.println("\n---------------------------------------------------------\n");
			obj1.calculateSalary(obj1,/*OverTime*/ 0, /*leave*/ 20 );
			obj1.EmpDetailedStructure();
			
			EmpController obj2 = new EmpSalary("CC","softwaretesting",101);
			obj2.EmpDetailedStructure();
			System.out.println("\n---------------------------------------------------------\n");
			obj2.calculateSalary(obj2,/*OverTime*/ -2, /*leave*/ 20 );
			obj2.EmpDetailedStructure();
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
