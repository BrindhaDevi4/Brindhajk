package employee;

public interface PayStructure {
	public void calculateSalary(EmpController obj, int i, int j) throws NegativeException, ExceptionMsg;
}
