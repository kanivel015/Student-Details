package DBUtil;
import java.util.Scanner;
import java.sql.*;

public class App {
    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_check", "root", "Tiger");
            Statement st = connect.createStatement();
            System.out.println("Database Configure:");
            System.out.println("Enter your choice:\n1.Update\n2.Delete\n3.Insert\n4.Show\nAny other choice to exit");
            int choice = sc.nextInt();
            while (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
                switch (choice) {
                    case 1:
                        System.out.println(
                                "Choose the column you wish to update:\n1.SNO\n2.NAME\n3.ROLL\nAny other choice to complete your update");
                        int choice2 = sc.nextInt();
                        while (choice2 == 1 || choice2 == 2 || choice == 3) {
                            switch (choice2) {
                                case 1:
                                    System.out.println("Enter the value;");
                                    int a = sc.nextInt();
                                    System.out.println("Where you want to update(sno)");
                                    int b = sc.nextInt();
                                    st.executeUpdate("update student set SNO = " + a + " where SNO = " + b);
                                    break;
                                case 2:
                                    System.out.println("Enter the value");
                                    sc.nextLine();
                                    String c = sc.nextLine();
                                    System.out.println("Where you want to update(sno)");
                                    int d = sc.nextInt();
                                    st.executeUpdate("update student set NAME = '" + c + "' where SNO = " + d);
                                    break;
                                case 3:
                                    System.out.println("Enter the value;");
                                    sc.nextLine();
                                    String e = sc.nextLine();
                                    System.out.println("Where you want to update(sno)");
                                    int f = sc.nextInt();
                                    st.executeUpdate("update avengers set DEPARTMENT = '" + e + "' where SNO = " + f);
                                    break;
                            }
                            System.out.println("Updated Successfully");
                            System.out.println(
                                    "Choose the column you wish to update:\n1.SNO\n2.NAME\n3.ROLL\nAny other choice to complete your update");
                            choice2 = sc.nextInt();
                        }
                        break;
                    case 2:
                        System.out.println("Enter the number of student you want to remove");
                        int x = sc.nextInt();
                        st.executeUpdate("delete from student where SNO = " + x);
                        System.out.println("Row Deleted Successfully");
                        break;
                    case 3:
                        System.out.println("Enter the name of student");
                        sc.nextLine();
                        String name1 = sc.nextLine();
                        System.out.println("Enter the department of student");
                        String roll1 = sc.nextLine();
                        String query = "insert into student ( NAME, DEPARTMENT) values ('" + name1
                                + "','"
                                + roll1 + "')";
                        st.executeUpdate(query);
                        System.out.println("Successfully Inserted");
                        break;
                    case 4:
                        ResultSet rs = st.executeQuery("select * from student");
                        System.out.println("SNO     NAME        DEPARTMENT");
                        while (rs.next()) {
                            int sno = rs.getInt("SNO");
                            String name = rs.getString("NAME");
                            String roll = rs.getString("DEPARTMENT");
                            System.out.println(sno + "      " + name + "        " + roll);
                        }
                        break;
                }
                System.out
                        .println("Enter your choice:\n1.Update\n2.Delete\n3.Insert\n4.Show\nAny other choice to exit");
                choice = sc.nextInt();
            }
            connect.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}