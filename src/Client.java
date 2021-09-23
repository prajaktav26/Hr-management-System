import java.util.Iterator;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dao.EmployeedaoImplements;
import com.model.Employee;
import com.service.EmployeeService;
import com.service.EmployeeServiceImplementation;
import java.util.Scanner;
public class Client {
	
public static boolean isValidMobileNo(String employeeMobile)
{
	Pattern ptrn=Pattern.compile("(0/91)?[7-9][0-9]{9}");
	Matcher match=ptrn.matcher(employeeMobile);
	return(match.find()&&match.group().equals(employeeMobile));
}
public static boolean isValidEmpName(String employeeName)
{
	Pattern ptrn=Pattern.compile(("[a-zA-Z0-9]*"));
	Matcher match=ptrn.matcher(employeeName);
	return(match.find()&&match.group().equals(employeeName));
	
}
public static boolean isValidEmpEmail(String employeeEmail)
{
	Pattern ptrn=Pattern.compile("^(.+)@(.+)$");
	Matcher match=ptrn.matcher(employeeEmail);
	return(match.find()&&match.group().equals(employeeEmail));
}

    public static void main(String[] args) {
    	EmployeeService empService=new EmployeeServiceImplementation();
    	String str = null;
    Scanner scanner=new Scanner(System.in);
    System.out.println(" ");
    System.out.println("*********************** WELCOME *************************************");
    System.out.println("Enter Your user Name");
    String userName=scanner.next();
    System.out.println("Enter Your Password");;
    String Password=scanner.next();
    boolean statusA = empService.getEmployeeByUserNameAndPassword(userName, Password);
    if(statusA)
    {
    	System.out.println("Login Successfully");
    	
    }
    else
    {
    	System.out.println("Login Fail");
    }
	
	while(statusA)	
	{
		
		do
		{
		Scanner sc=new Scanner(System.in);
		System.out.println(" ");
		System.out.println("****************************************************************************************");
		System.out.println("1.Employee Details\t"+"2.Add Employee"+"\n"+"3.Update Employee."+"\n"+"4.Delete Employee"+"\n"+"5.Search Employee"+"\n"+"6.Get DepartmentWise Employee Count"+"\n"+"7.List of Employees for Given Department");
		System.out.println("\nEnter Choice:");
		int choice=sc.nextInt();
		List<Employee> empList=empService.getAllEmployee();
		Iterator<Employee> itr=empList.iterator();
		switch(choice)
		{
		case 1:
		System.out.println("**********All Student Datails*************");
		
		while (itr.hasNext()) {
			Employee employee=(Employee) itr.next();
			System.out.println("Employee Id:"+employee.getEmpId());
			System.out.println("Employee Name:"+employee.getEmpName());
			System.out.println("Employee Age:"+employee.getEmpAge());
			System.out.println("Employee Salary:"+employee.getEmpSalary());
			System.out.println("Employee Address:"+employee.getEmpAdress());
			System.out.println("Employee Mobile Number:"+employee.getEmpMobile());
			System.out.println("Employee Email:-"+employee.getEmpEmail());
			System.out.println("Employee Role Id:-"+employee.getroleid());
			System.out.println("employee Department Id:-"+employee.getdeptdid());
            System.out.println("**************************************");
		}			
		
		break;
		case 2:
			System.out.println(" ");
			System.out.println("******* Enter Employee information ************");
			System.out.println("Enter Employee Id:- ");
			int empId=scanner.nextInt();
			System.out.println("Enter Employee Name:- ");
			String empName=scanner.next();
			if(isValidEmpName(empName))
			{
				System.out.println("Valid Employee Namee");
			}
			else
			{
				System.out.println("Employee Name is Not valid");
			}
			System.out.println("Enter Employee Salary:- ");
			int empSalary=scanner.nextInt();
			System.out.println("Enter Employee age:- ");
			int empAge=scanner.nextInt();
			System.out.println("Enter Employee Address");
			String empAddress=scanner.next();
			System.out.println("Enter Employee Mobile Number");
			String empMobile=scanner.next();
			if(isValidMobileNo(empMobile))
			{
                  System.out.println("Mobile No is Valid");
			}
			else
			{
				System.out.println("Mobile Number is Not Valid");
			}
			System.out.println("Enter Employee Email");
			String empEmail=scanner.next();
			if(isValidEmpEmail(empEmail))
			{
				System.out.println("Valid Email");
			}
			else
			{
				System.out.println("Email is Not valid");
			}
		
			
			System.out.println("Enter roleid:");
			int roleid=scanner.nextInt();
			System.out.println("Enter Department Id:");
			int deptid=scanner.nextInt();
		
			Employee employee=new Employee(empId,empName,empSalary,empAge,empAddress,empMobile,empEmail,roleid,deptid);
			boolean status = empService.insertEmployee(employee);
			if (status) {
				System.out.println("Employee added Successfully.....");
			} else {
				System.out.println("Unable to Add employee.........");
			}
		
		break;
		
		
		
		
		  case 3:
			  System.out.println(" ");
				System.out.println("******* Enter Employee information to update************");
				System.out.println("Enter Employee Id:- ");
				int empId1=scanner.nextInt();
				System.out.println("Enter Employee Name:- ");
				String empName1=scanner.next();
				if(isValidEmpName(empName1))
				{
					System.out.println("The Name is Valid");
				}
				else
				{
					System.out.println("The Name is Not Valid");
				}
				System.out.println("Enter Employee Salary:- ");
				int empSalary1=scanner.nextInt();
				System.out.println("Enter Employee age:- ");
				int empAge1=scanner.nextInt();
				System.out.println("Enter Employee Address");
				String empAddress1=scanner.next();
				System.out.println("Enter Employee Mobile Number");
				String empMobile1=scanner.next();
				if(isValidMobileNo(empMobile1))
				{
					System.out.println("Valid Mobile Number");
				}
				else
				{
					System.out.println("The Mobile Number is Not valid");
				}
				System.out.println("Enter Employee Email");
				String empEmail1=scanner.next();
				if(isValidEmpEmail(empEmail1))
				{
					System.out.println("Email is Valid");
				}
				else
				{
					System.out.println("The Email is Not Valid");
				}
				System.out.println("Enter roleid:");
				int roleid1=scanner.nextInt();
				System.out.println("Enter Department id:");
				int deptid1=scanner.nextInt();
				Employee employee1=new Employee(empId1,empName1,empSalary1,empAge1,empAddress1,empMobile1,empEmail1,roleid1,deptid1);
				boolean status1 = empService.updateEmployee(employee1);
				if (status1) {
					System.out.println("Employee Updated Successfully.....");
				} else {
					System.out.println("Unable to Update employee.........");
				}
			break;
		  case 4:
			  System.out.println(" ");
				System.out.println("******* Enter Employee information to Delete************");
				System.out.println("Enter Employee Id:- ");
				int empId2=scanner.nextInt();
				boolean status2 = empService.deleteEmployee(empId2);
				if (status2) {
					System.out.println("Employee Deleted Successfully.....");
				} else {
					System.out.println("Unable to Delete employee.........");
				}
			  
		 break;
		  case 5:
			  System.out.println(" ");
			  System.out.println("*********************Enter Employee Detail to search********************");
			  System.out.println("Enter Employee Id to Search....");
			  int empIdS=scanner.nextInt();
			  Employee employee2=empService.getemployee(empIdS);
			  if(employee2!=null)
			  {
				  System.out.println("Employee Id:-"+employee2.getEmpId());
				  System.out.println("Employee Name:-"+employee2.getEmpName());
				  System.out.println("Employee Salary:-"+employee2.getEmpSalary());
				  System.out.println("Employee Age:-"+employee2.getEmpAge());
				  System.out.println("Employee Addres:-"+employee2.getEmpAdress());
				  System.out.println("employee Mobile:-"+employee2.getEmpMobile());
				  System.out.println("Employee Email:-"+employee2.getEmpEmail());
				  System.out.println("Employee Role Id:-"+employee2.getroleid());
				  System.out.println("Employee Department Id:-"+employee2.getdeptdid());
				  
			  }
			  else
			  {
				  System.out.println("Employee Record is not available");
			  }
		break;
		case 6:
			System.out.println(" ");
			  System.out.println("*********************Department wise Employee Count********************");
			  empService.departmentwiseEmployeeCount();
			break;
		case 7:
			System.out.println("Enter department Id to see the List ");
			int departmentId=scanner.nextInt();
			List<Employee> employeelist=empService.ListEmpByDepartment(departmentId);
			for(Employee employee3 :  employeelist)
			{
			  if(employee3!=null)
			  {
				  System.out.println("Employee Id:-"+employee3.getEmpId());
				  System.out.println("Employee Name:-"+employee3.getEmpName());
				  System.out.println("Employee Salary:-"+employee3.getEmpSalary());
				  System.out.println("Employee Age:-"+employee3.getEmpAge());
				  System.out.println("Employee Addres:-"+employee3.getEmpAdress());
				  System.out.println("employee Mobile:-"+employee3.getEmpMobile());
				  System.out.println("Employee Email:-"+employee3.getEmpEmail());
				  System.out.println("Employee Role Id:-"+employee3.getroleid());
				  System.out.println("Employee Department Id:-"+employee3.getdeptdid());
				  System.out.println("___________________________________________");
				  
			  }
			  else
			  {
				  System.out.println("Employee Record is not available");
			  }
			}
			
			
			  
//			  empService.listofEmployeesforGivenDepartmnet(departmentId);
			  
			
	break;  
			
		}
		System.out.println();
			System.out.println("Do you wish to continue(y/n) ? ");
			str=sc.next();
		}while(str.equals("y")||str.equals("Y"));
		
	}
		
    }
}
    

			
			
		