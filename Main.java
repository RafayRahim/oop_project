import java.io.*;
import java.util.*;
interface loginpage{
    
    public void login();
    public void Attendence();
    public void Tasks();
    public void Contact();
    
}
class Employee extends Admin implements loginpage{
    
    String name;
    int Id;
    String EmployeeId;
    
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    public void login(){
        
        System.out.println("Enter your name :");
        name = sc1.nextLine();
        System.out.println("enter Employee Id :");
        Id = sc.nextInt();
        System.out.println("Enter Employee Password :");
        String EmpPass = sc1.nextLine();
        EmployeeId = String.valueOf(Id);
        try {
            
            BufferedReader br = new BufferedReader(new FileReader("Employee.txt"));
            String Info;
            while ((Info = br.readLine()) != null) {
                
                if (Info.contains(EmployeeId)) {
                    
                    System.out.println("your ID matched");
                    
                    if(EmpPass.equalsIgnoreCase("employee")){
                        
                        System.out.println("Your Password Matched");
                       
                        opts();
                    }
                    
                    else {
                        
                        System.out.println("your password doesnot Matched");
                        
                        try {
                            
                           Thread.sleep(3000);
                        }
                        
                        catch (InterruptedException e) {
                            
                           // handle the exception
                           e.printStackTrace();
                        }
                        
                        break;
                    }
                }
                
                else {
                    
                    System.out.println("your employee id doesnot match our records ");
                    
                    try {
                        
                        Thread.sleep(3000);
                    }
                    
                    catch (InterruptedException e) {
                        
                        // handle the exception
                        e.printStackTrace();
                    }
                    
                    break;
                }
            }
        }
        catch(Exception e) {
            
            e.printStackTrace();
        }
        // returnback();
    }
    
    void opts(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("\n\n1. Attendence & Leave");
        System.out.println("2. Employee Portal");
        System.out.println("3. Tasks\n");
        System.out.print("Enter : ");
        int opt = sc.nextInt();
        switch(opt){
            
            case 1:Attendence();
            break;
            
            case 2:EmployeePortal();
            break;
            
            case 3:Tasks();
            break;
            
            default:System.out.print("invalid response");
            
            try {
                
                Thread.sleep(3000);
            }
            
            catch (InterruptedException e) {
                
                // handle the exception
                e.printStackTrace();
            }
        }
    }
    
    public void Attendence(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("1. Mark Attendence");
        System.out.println("2. Apply For Leave :");
        System.out.print("Enter Option :");
        
        int optA = sc.nextInt();
        
        switch(optA){
            
            case 1 :{
                Attendence1();
                break;
            }
            
            case 2:{ 
                Leave();
                break;
            }   
        }
    }
    
    void Attendence1(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
       
        try {
            
            File inputFile = new File("Attendence.txt");
            File tempFile = new File("temp.txt");
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            String Data;
            while ((Data = br.readLine()) != null) {
                
                bw.write(Data);
                bw.newLine();
                if (Data.contains(EmployeeId)) {
                    
                    bw.write("\tp\n");
                }
            }
            br.close();
            bw.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            System.out.println("Attendence of "+name+"is marked Successfully");
        } catch (Exception e) {
            
            e.printStackTrace();
        }
                  
        try {
            
            Thread.sleep(3000);
        }
        
        catch (InterruptedException e) {
            
            // handle the exception
            e.printStackTrace();
        }
    }
    
    void Leave(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.print("Enter the reason for taking Leave :");
        String reason = sc1.nextLine();
        try {
            
            File inputFile = new File("Attendence.txt");
            File tempFile = new File("temp.txt");
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            String Data;
            while ((Data = br.readLine()) != null) {
                
                bw.write(Data);
                bw.newLine();
                if (Data.contains(EmployeeId)) {
                    
                    bw.write("\tL\n");
                }
            }
            br.close();
            bw.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            System.out.println("Leave Application of "+name+"has been sent");
        }
        
        catch (Exception e) {
            
            e.printStackTrace();
        }
        try {
            
            BufferedWriter bw = new BufferedWriter(new FileWriter("Leave.txt",true));
            bw.write("EmployeeId :"+EmployeeId+"\n"+"Reason For Leave :"+reason);
            bw.close();
        }
        
        catch(Exception e) {
        }
        
        try {
            
            Thread.sleep(3000);
        }
        
        catch (InterruptedException e) {
            
            // handle the exception
            e.printStackTrace();
        }
    }
    
    void EmployeePortal(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("Welcome To Our Employee Portal");
        System.out.println("1. Payroll & Benefits");
        // System.out.println("2. Time & Working Hours");
        System.out.println("2. Company Policies");
        System.out.println("3. Contact Us\n");
        System.out.print("Enter : ");
        
        Scanner sc = new Scanner(System.in);
        
        int optB = sc.nextInt();
        
        switch(optB){
            
            case 1:Payroll();
            break;
            
            case 2:Policies();
            break;
            
            case 3:Contact();
            break;
            
            default:System.out.print("invalid response");
        }
    }
    
    void Payroll(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("What Is Your Post in the company :");
        System.out.println("1 UML Designer");
        System.out.println("2 Software Engineer");
        System.out.println("3 Programmer");
        System.out.println("4 Deployement & Debugger");
        int choice = sc.nextInt();
        if(choice == 1){
        
            System.out.println("Your Salary Package is of 400$");
        }
        
        if(choice == 2){
        
            System.out.println("Your Salary Package is of 800$");
        }
        
        if(choice == 3){
        
            System.out.println("Your Salary Package is of 1000$");
        }
        
        if(choice == 4){
        
            System.out.println("Your Salary Package is of 200$");
        }
        // System.out.print("\033[H\033[2J");
        // System.out.flush();
        try {
                
            Thread.sleep(3000);
        } 
        catch (InterruptedException e) {
            
            // handle the exception
            e.printStackTrace();
        }
    }

    void Policies(){
    
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.print("The policies of a software development company can vary depending on the company's size, location, industry, and specific requirements. However, here are some common policies that software development companies often have\nCode of Conduct: A code of conduct sets the standards of behavior expected from all employees within the company. It outlines ethical principles, professional conduct, and guidelines for interacting with colleagues, clients, and stakeholders.\nIntellectual Property Protection: Software development companies typically have policies to protect intellectual property rights. These policies may include confidentiality agreements, non-disclosure agreements (NDAs), and restrictions on the use or dissemination of proprietary information.\nRemote Work and Flexible Hours: Given the nature of the work, many software development companies offer policies that allow employees to work remotely or have flexible working hours. These policies outline expectations, guidelines, and requirements for remote work arrangements.\nSoftware Development Methodologies: Companies often adopt specific software development methodologies such as Agile, Scrum, or Kanban. The policies define the process, roles, and responsibilities, as well as the tools and techniques used to manage projects and ensure efficient development.\nQuality Assurance and Testing: Policies related to quality assurance and testing establish guidelines for ensuring the quality and reliability of software products. This may include procedures for unit testing, integration testing, regression testing, and user acceptance testing.\n\nIt's important to note that these policies can vary from company to company. Therefore, it's always advisable to consult the specific policies and guidelines of the software development company you are interested in or currently employed by.\n\n");
        System.out.println("Have You Read All The policies ?");
        System.out.println("1 Yes");
        
        int read = sc.nextInt();
    }
    public void Contact(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("1 Ask For Query");
        System.out.print("2 Check For Respnse");
        int choice = sc.nextInt();
        
        switch(choice){
            
            case 1:{
                System.out.print("What do you want to ask:");
                String Ask = sc1.nextLine();
                
                try{ 
            
                    File Contact = new File("Contact.txt");
                    BufferedWriter bw = new BufferedWriter(new FileWriter(Contact));
                    bw.write("EmployeeId :"+EmployeeId+"\n"+"Query :"+Ask);
                    bw.close();
                }
                catch(Exception e) {
                
                    e.printStackTrace();
                }
            
                break;
            }
            case 2:{
                
                try {
                    BufferedReader br = new BufferedReader(new FileReader("Contact.txt"));
                    String content;
                    
                    while((content=br.readLine())!=null){
                        
                        System.out.print(content);
                    }
                }
                
                catch(Exception e) {
                    
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    
    public void Tasks(){
    
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        int no=0;
        
        try {
            
            // File TaskRead = new File("Task.txt");
            // File TaskCompletion = new File("Task.txt");
            BufferedReader br = new BufferedReader(new FileReader("Task.txt"));
            String task,task1;
            while ((task= br.readLine())!=null&&(task1=br.readLine())!=null) {
                
                if(!task1.contains(EmployeeId)){
                    
                    System.out.println(task1);
                }
                    
                if(task.contains(EmployeeId)){
                        
                    no=1;
                    System.out.println("1. Complete Assignment");
                    System.out.print("2 Return");
                    int optE = sc.nextInt();
                    switch(optE){
            
                        case 1 :{ 
                 
                            BufferedWriter bw = new BufferedWriter(new FileWriter("Task.txt",true));
                            System.out.println("enter your response:");
                            String response = sc1.nextLine();
                            bw.newLine();
                            bw.write("response :"+response);
                            bw.close();
                            break;
                        }
                        
                        default :System.out.print("choose from 1 & 2");
                    }
                }
    
                br.close();
            }
        }
      
        catch(Exception e) {
          
            e.printStackTrace();
        }
        
        if(no==1){
           
            System.out.print("Response Saved");
        }
        
        else{
           
            System.out.print("you have no tasks :)");
        }
              
        try {
                
            Thread.sleep(3000);
        }
        
        catch (InterruptedException e) {
            
            // handle the exception
            e.printStackTrace();
        }
    }
}

class Admin implements loginpage{
    
    public void login(){
        
        System.out.println("Welcome to Admin Portal!!!\n");
        System.out.println("Enter Admin Password :");
        String AdminPass = sc1.nextLine();
        
        if(AdminPass.equalsIgnoreCase("admin")){
            
            opts();
        }
        
        else{
            
            System.out.println("wrong Password");
        }
    }
    void returnback(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("\t\t\t\t\t1.Go Back");
        System.out.println("\t\t\t\t\t2.Exit");
        int optC = sc.nextInt();
        
        switch(optC){
            
            case 1:
            break;
            
            case 2:System.exit(0);
            break;
        }
    }
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    
    void opts(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("1 Employee Status");
        System.out.println("2 Task Assignment");
        System.out.println("3 Leave Requests");
        System.out.println("4 Check Attendence");
        System.out.println("5 Salary");
        System.out.print("Enter");
        int opts = sc.nextInt();
        
        switch(opts){
            case 1:{
                EmployeeStatus();
                break;
            }
            
            case 2:{
                Tasks();
                break;
            }
            
            case 3:{
                LeaveRequest();
                break;
            }
            
            case 4:{
                Attendence();
                break;
            }
            
            case 5:{
                Contact();
                break;
            }
        }
        returnback();
    }
    void EmployeeStatus(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("1 Add Employee");
        System.out.println("2 Show Employee");
        System.out.println("3 Search Data");
        System.out.println("4 Delete Data");
        System.out.print("Enter");
        int optA = sc.nextInt();
        switch(optA){
            case 1:{
                Add();
                break;
            }
            
            case 2:{
                Show();
                break;
            }
            
            case 3:{
                Search();
                break;
            }
            
            case 4:{
                Delete();
                break;
            }
        }
    }
    void Add(){
      
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.print("How Many Employees Do you want to add :");
        int no = sc.nextInt();
        try{
                
            String file1Path = "Employee.txt";
            String file2Path = "Attendence.txt";
            FileWriter file1Writer = null;
            FileWriter file2Writer = null;
            file1Writer = new FileWriter(file1Path,true);
            file2Writer = new FileWriter(file2Path,true);
            // File file1 = new File("Employee.txt");
            // File file2 = new File("Attendence.txt");
            
            for (int i = 0; i < no; i++) {
                
                System.out.print("Enter Name :");
                String name = sc1.nextLine(); 
                System.out.print("Enter EmployeeNo :");
                
                int employeeNo = sc.nextInt();
                
                String EmployeeNo = String.valueOf(employeeNo);
                
                file1Writer.write("name :"+name+"\t\t");
                file1Writer.write("EmployeeNo :"+EmployeeNo+"\n");
                file2Writer.write("name :"+name+"\t\t");
                file2Writer.write("EmployeeNo :"+EmployeeNo+"\n\n");
            }
           
            file1Writer.close();
            file2Writer.close();
        }
        
        catch(Exception e) {
                
            e.printStackTrace();
        }
    }
    
    void Show(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        try {
              
            BufferedReader br = new BufferedReader(new FileReader("Employee.txt"));
            String info;
            while((info=br.readLine())!=null){
               
                System.out.println(info);
            }
        }
       
        catch(Exception e){
            
            e.printStackTrace();
        }
                 
        try {
                
            Thread.sleep(5000);
        }
        
        catch (InterruptedException e) {
            
            // handle the exception
            e.printStackTrace();
        }
    }
    
    void Search(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("enter the employee you want to search");
        int optB=sc.nextInt();
        
        String EmployeeNo = String.valueOf(optB);
        try{
            
            BufferedReader br = new BufferedReader(new FileReader("Employee.txt"));
            String Info;
            while ((Info = br.readLine()) != null) {
                
                if (Info.contains(EmployeeNo)) {
                    
                    System.out.println(Info);
                }
            }
        }
        
        catch (Exception e) {
            
            e.printStackTrace();
        }
                  
        try {
                
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
        
            // handle the exception
            e.printStackTrace();
        }
    }
    
    void Delete(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.print("Enter the Employee Id you want to Delete from the records :");
        int EmployeeNo = sc.nextInt();
        String EmployeeId = String.valueOf(EmployeeNo);
        
        try {
            
            File inputFile = new File("Employee.txt");
            File tempFile = new File("temp.txt");
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            String Data;
            // int lineNumber = 0;
            while ((Data = br.readLine()) != null) {
                
                // lineNumber++;
                
                if (!Data.contains(EmployeeId)) {
                    
                    bw.write(Data);
                    bw.newLine();
                }
            }
            br.close();
            bw.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            System.out.println(EmployeeId+"was delete Successfully");
        }
        
        catch (Exception e) {
            
            e.printStackTrace();
        }
                  
        try {
                
            Thread.sleep(3000);
        }
        
        catch (InterruptedException e) {
         
            // handle the exception
            e.printStackTrace();
        }
    }
    public void Attendence(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        
        try{
        
            BufferedReader br = new BufferedReader(new FileReader("Leave.txt"));
            String content;
            while((content = br.readLine())!=null){
            
                System.out.print(content);
            }
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
                  
        try {
                
            Thread.sleep(5000);
        }
        
        catch (InterruptedException e) {
        
            // handle the exception
            e.printStackTrace();
        }
    }
    
    public void Tasks(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("1 Assign Task :");
        System.out.println("2 Check For Submissions :");
        int assign = sc.nextInt();
        
        switch(assign){
            
            case 1 :{
                System.out.println("enter the employee Id for user you want assign task");
                String idassign = sc1.nextLine();
                System.out.print("what task you want to assign :");
                String task = sc1.nextLine();
                
                try{ 
            
                    File Assign = new File("Task.txt");
                    BufferedWriter bw = new BufferedWriter(new FileWriter(Assign));
                    bw.write(idassign+"\n"+task);
                    bw.close();
                }
                catch(Exception e) {
                
                    e.printStackTrace();
                }
                break;
            }
            
            case 2:{
              
                try{
        
                    File Check = new File("Task.txt");
                    BufferedReader br = new BufferedReader(new FileReader(Check));
                    String Checkdata;
                   
                    while ((Checkdata = br.readLine()) != null) {
                    
                        System.out.print(Checkdata);
                   }
                   break;
                }
       
                catch(Exception e) {
           
                    e.printStackTrace();
                }
                
                try {
                
                    Thread.sleep(5000);
                }
                
                catch (InterruptedException e) {
              
                    // handle the exception
                    e.printStackTrace();
                }
            }
        }
    }
    
    void LeaveRequest(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        
        try {
                
            BufferedReader br = new BufferedReader(new FileReader("Leave.txt"));
            String requests;
            
            while((requests = br.readLine())!=null){
                
                System.out.print(requests);
            }
        }
        
        catch(Exception e){
            
            e.printStackTrace();
        }
                  
        try {
                
            Thread.sleep(3000);
        }
        
        catch (InterruptedException e) {
        
            // handle the exception
            e.printStackTrace();
        }
    }
    
    public void Contact(){
    
        try{
            
            BufferedReader br = new BufferedReader(new FileReader("Contact.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Contact.txt",true));
            String Queries;
            while((Queries = br.readLine())!=null){
            
                System.out.println(Queries);
            }
            System.out.print("Your Response :");
            String response = sc1.nextLine();
            bw.newLine();
            bw.write("Your Response :"+response);
            bw.close();
        }
        catch(Exception e) {
        
            e.printStackTrace();
        }
    }
}
public class Main {
   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
    
        while(true){
             
            System.out.print("\033[H\033[2J");
            System.out.flush(); 
            System.out.print("\n\n\t\t*\t\tWelcome To DRRG Web Development Association !!!\t\t*\n\n");
            System.out.println("1 Employee");
            System.out.println("2 Admin");
            System.out.println("3 Exit System");
            int opt = sc.nextInt();
        
            switch (opt) {
            
                case 1:{
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 
                    Employee e = new Employee();
                    e.login();
                    break;
                }

                case 2:{
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 
                    Admin a = new Admin();
                    a.login();
                    break;
                }
            
                case 3:{
                    System.exit(0);
                }
            }
        }
    }
}