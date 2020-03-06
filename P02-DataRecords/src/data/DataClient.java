package data;

import java.io.FileNotFoundException;

public class DataClient {
	public static void main(String[] args) throws FileNotFoundException {
		Filter filter = new Filter();
		filter.read("./people.txt");
		String location = "./";
		filter.filterEmployeeService(location);
		filter.filterEmployeeSalary(location);
		filter.filterVisitorAge(location);
		filter.generateGalaLists(location);

		// System.out.println(filter.employeeData);
		// System.out.println(filter.visiterData);
		// System.out.println(filter.data);
	}
}
