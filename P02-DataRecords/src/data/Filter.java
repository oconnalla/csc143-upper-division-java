package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modules.DModule;
import people.ArrivalTime;
import people.Employee;
import people.Person;
import people.Visiter;

public class Filter {
	private List<Person> data;
	private List<Employee> employeeData;
	private List<Visiter> visiterData;

	public Filter() {
		data = new ArrayList<Person>();
		employeeData = new ArrayList<Employee>();
		visiterData = new ArrayList<Visiter>();

	}

	public void filterEmployeeSalary(String directory) throws FileNotFoundException {

		String loc1 = directory + "employeesOver60.txt";
		String loc2 = directory + "employeesOver60CS.txt";
		String loc3 = directory + "employeesUnder60.txt";
		String loc4 = directory + "employeesUnder60CS.txt";

		File file1 = new File(loc1);
		File file2 = new File(loc2);
		File file3 = new File(loc3);
		File file4 = new File(loc4);

		PrintStream out1 = new PrintStream(file1);
		PrintStream out2 = new PrintStream(file2);
		PrintStream out3 = new PrintStream(file3);
		PrintStream out4 = new PrintStream(file4);

		DModule.quickSort(employeeData);

		if (file1.exists() && file2.exists() && file3.exists() && file4.exists()) {
			for (Employee employee : employeeData) {
				if (employee.getSalary() < 60000) {
					out1.println(employee);
					out2.println(employee.toFile());

				} else {
					out3.println(employee);
					out4.println(employee.toFile());
				}
			}
		}

		out1.close();
		out2.close();
		out3.close();
		out4.close();

	}

	public void filterEmployeeService(String directory) throws FileNotFoundException {
		String loc1 = directory + File.separator + "employeesOver10yr.txt";
		String loc2 = directory + File.separator + "employeesOver10yrCS.txt";
		String loc3 = directory + File.separator + "employeesOver25yrs.txt";
		String loc4 = directory + File.separator + "employeesOver25CS.txt";

		File file1 = new File(loc1);
		File file2 = new File(loc2);
		File file3 = new File(loc3);
		File file4 = new File(loc4);

		PrintStream out1 = new PrintStream(file1);
		PrintStream out2 = new PrintStream(file2);
		PrintStream out3 = new PrintStream(file3);
		PrintStream out4 = new PrintStream(file4);

		DModule.bubbleSort(employeeData);

		if (file1.exists() && file2.exists() && file3.exists() && file4.exists()) {
			for (Employee employee : employeeData) {
				if (employee.getYears() >= 10 && employee.getYears() < 25) {
					out1.println(employee);
					out2.println(employee.toFile());

				} else if (employee.getYears() >= 25) {
					out3.println(employee);
					out4.println(employee.toFile());
				}
			}
		}

		out1.close();
		out2.close();
		out3.close();
		out4.close();

	}

	public void filterVisitorAge(String directory) throws FileNotFoundException {
		String loc1 = directory + File.separator + "visiterUnder21.txt";
		String loc2 = directory + File.separator + "VisiterUnder21CS.txt";
		String loc3 = directory + File.separator + "VisiterOver21.txt";
		String loc4 = directory + File.separator + "VisiterOver21CS.txt";

		File file1 = new File(loc1);
		File file2 = new File(loc2);
		File file3 = new File(loc3);
		File file4 = new File(loc4);

		PrintStream out1 = new PrintStream(file1);
		PrintStream out2 = new PrintStream(file2);
		PrintStream out3 = new PrintStream(file3);
		PrintStream out4 = new PrintStream(file4);

		DModule.bubbleSort(visiterData);

		if (file1.exists() && file2.exists() && file3.exists() && file4.exists()) {
			for (Visiter visiter : visiterData) {
				if (visiter.getAge() < 21) {
					out1.println(visiter);
					out2.println(visiter.toFile());

				} else {
					out3.println(visiter);
					out4.println(visiter.toFile());
				}
			}
		}

		out1.close();
		out2.close();
		out3.close();
		out4.close();

	}

	public void generateGalaLists(String directory) throws FileNotFoundException {
		String loc1 = directory + File.separator + "EmployeesCS.txt";
		String loc2 = directory + File.separator + "VisitersCS.txt";
		String loc3 = directory + File.separator + "FullCS.txt";

		File file1 = new File(loc1);
		File file2 = new File(loc2);
		File file3 = new File(loc3);

		PrintStream out1 = new PrintStream(file1);
		PrintStream out2 = new PrintStream(file2);
		PrintStream out3 = new PrintStream(file3);

		DModule.bubbleSort(visiterData);
		DModule.bubbleSort(employeeData);
		DModule.selectionSort(data, Person::compareName);

		if (file1.exists() && file2.exists() && file3.exists()) {
			for (Visiter visiter : visiterData) {
				if (visiter.isWillAttend() == true) {
					out1.println(visiter.toFile());
				}
			}
			for (Employee employee : employeeData) {
				if (employee.isWillAttend() == true) {
					out2.println(employee.toFile());
				}
			}

			for (Person person : data) {
				if (person.isWillAttend() == true) {
					out3.println(person.toFile());
				}
			}
		}

		out1.close();
		out2.close();
		out3.close();
	}

	public ArrivalTime makeArrivalTime(String str) {
		String[] info = str.split(":");
		String[] sub = info[1].split(" ");
		int hour = Integer.parseInt(info[0]);
		int minutes = Integer.parseInt(sub[0]);
		String meridian = sub[1];
		return new ArrivalTime(hour, minutes, meridian);
	}

	public Person parse(String line) {
		String[] info = line.split(", ");
		String name = info[0];
		int age = Integer.parseInt(info[1]);
		String id = info[2];
		boolean willAttend = info[3].equalsIgnoreCase("YES");

		if (id.charAt(0) == 'E') {
			String office = info[4];
			double salary = Double.parseDouble(info[5]);
			int year = Integer.parseInt(info[6]);
			return new Employee.Builder().setName(name).setAge(age).setId(id).setWillAttend(willAttend)
					.setOffice(office).setSalary(salary).setYears(year).build();

		} else {
			ArrivalTime time = makeArrivalTime(info[4]);
			return new Visiter(name, age, id, willAttend, time);
		}
	}

	public void read(String location) throws FileNotFoundException {
		File file = new File(location);
		Scanner input = new Scanner(file);
		Person person;
		Employee employee;
		Visiter visiter;

		while (input.hasNextLine()) {
			person = parse(input.nextLine());

			if (person instanceof Employee) {
				employee = (Employee) person;
				// check for duplicates
				if (!employeeData.contains(employee)) {
					employeeData.add(employee);
				}
			}

			if (person instanceof Visiter) {
				visiter = (Visiter) person;
				// check for duplicates
				if (!visiterData.contains(visiter)) {
					visiterData.add(visiter);
				}
			}

			// check for duplicates
			if (!data.contains(person) && person.isWillAttend()) {
				data.add(person);
			}
		}
		input.close();
	}
}
