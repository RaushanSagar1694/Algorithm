public class test {
    
}

// 1. Write a program of connecting java application with mysql database and
// display records using Statement interface.

// public static void main(String args[]) {
// try {
// Class.forName("com.mysql.cj.jdbc.Driver");
// Connection conn = DriverManager.getConnection(
// "jdbc:mysql://localhost:3306/school", "root", "root");
// Statement stmt = conn.createStatement();
// String query = "select * from student";
// ResultSet rst = stmt.executeQuery(query);
// while (rst.next()) {
// System.out.println(rst.getInt("roll") + "\t" + rst.getString("name") + "\t" +
// rst.getFloat(3));
// }
// stmt.close();
// conn.close();
// } catch (ClassNotFoundException e) {
// System.out.println(e.getMessage());
// } catch (SQLException e) {
// System.out.println(e.getMessage());
// }
// }
// }

////1. Write a program of connecting java application with mysql database and display records using Statement interface.

// import java.sql.*;
// import java.util.Scanner;

// class Jdbc {
//     public static void main(String args[]) {
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             Connection conn = DriverManager.getConnection(
//                     "jdbc:mysql://localhost:3306/school", "root", "");
//             PreparedStatement pstmt = conn.prepareStatement(
//                     "insert into student values(?,?,?)");

//             Scanner sc = new Scanner(System.in);
//             System.out.print("Enter roll:");
//             int r = sc.nextInt();
//             System.out.print("Enter name:");
//             String n = sc.next();
//             System.out.print("Enter Percent:");
//             float p = sc.nextFloat();
//             pstmt.setInt(1, r);
//             pstmt.setString(2, n);
//             pstmt.setFloat(3, p);
//             int cnt = pstmt.executeUpdate();
//             System.out.println("Count is " + cnt);
//             pstmt.close();
//             conn.close();
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }

// 3. Write a client-server application of chatting using TCP/IP.

// import java.io.*;
// import java.net.*;

// class TCPServer {
// public static void main(String[] args) throws IOException, SocketException {
// Console con = System.console();
// ServerSocket ss = new ServerSocket(2000, 5, InetAddress.getLocalHost());
// System.out.println("Waiting for Client");
// Socket cs = ss.accept();
// System.out.println("Connected to " + cs);
// BufferedReader in = new BufferedReader(new
// InputStreamReader(cs.getInputStream()));
// PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
// while (true) {
// System.out.print("Enter some text for Client");
// String s1 = con.readLine();
// out.println(s1);
// String s2 = in.readLine();
// System.out.println("Message from client " + s2);
// }
// }
// }

// import java.io.*;
// import java.net.*;
// public class TCPClient{
// public static void main(String[] args) throws
// IOException,UnknownHostException {
// Console con=System.console();
// Socket s=new Socket(InetAddress.getLocalHost(),2000);
// BufferedReader in=new BufferedReader(new
// InputStreamReader(s.getInputStream()));
// PrintWriter out=new PrintWriter(s.getOutputStream(),true);
// while(true){11
// String s1=in.readLine();
// System.out.println("Message from server is " +s1);
// System.out.println("Enter some text for server");
// String s2=con.readLine();
// out.println(s2);
// }
// }
// }

// 4. Write a java program to implement client-server application using
// DatagramSocket and DatagramPacket.

// import java.net.*;
// import java.io.Console;
// class User1{
// public static void main(String args[])throws Exception{
// DatagramSocket d1=new DatagramSocket(2000);
// while(true){
// //sending
// Console con=System.console();
// System.out.print("Enter message for user2:");
// String msg=con.readLine();
// //For Single PC
// InetAddress inet=InetAddress.getLocalHost();
// //or for Multiple PC
// //byte b[]={(byte)192,(byte)168,0,2};
// //InetAddress inet=InetAddress.getByAddress(b);
// DatagramPacket p1=new
// DatagramPacket(msg.getBytes(),msg.length(),inet,3000);
// d1.send(p1);
// //Receiving
// byte b[]=new byte[1024];
// DatagramPacket p2=new DatagramPacket(b,b.length);
// d1.receive(p2);
// System.out.println("Message from user2:"
// +new String(p2.getData(),0,p2.getLength()));
// System.out.println(p2.getPort());
// }
// }
// }

// 5. Implement the RMI Application program.

// HelloInterface.java
// import java.rmi.*;
// public interface HelloInterface extends Remote{
// public String sayHello() throws RemoteException;
// public void add(int a, int b)throws RemoteException;
// public int square(int a) throws RemoteException;
// }

// HelloServer.java
// import java.rmi.*;
// import java.rmi.server.UnicastRemoteObject;
// import java.rmi.activation.Activable;
// public class HelloServer extends UnicastRemoteObject implements
// HelloInterface{
// HelloServer() throws RemoteException {
// super();
// }
// public String sayHello() throws RemoteException {
// return "This is fromm RMI";
// }
// public void add(int a, int b) throws RemoteException {
// System.out.println(a+b);
// }
// public int square(int a) throws RemoteException {
// return a*a;
// }
// }

// MyRMI.java
// import java.net.MalformedURLException;
// import java.rmi.*;
// public class MyRMI{
// public static void main(String[] args){
// try{
// HelloServer hs=new HelloServer();
// LocateRegistry.createRegistry(1900);
// Naming.bind("rmi://127.0.0.1:1900/remote1", hs);
// }
// catch (MalformedURLException e){
// e.printStackTrace();
// }
// catch(RemoteException e){
// e.printStackTrace();
// }
// catch (AlreadyBoundException e){
// e.printStackTrace();
// }
// }
// }

// HelloClient.java
// import java.net.MalformedURLException;
// import java.rmi.*;
// public class HelloClient {
// public static void main(String[] args) {
// String msg="";
// try {
// HelloInterface hs=(HelloInterface)Naming.lookup("remote1");
// msg=hs.sayHello();
// hs.add(10,20);
// Thread.sleep(5000);
// int square =hs.square(5);
// System.out.println("Message is:"+msg);
// System.out.println("Square of 5 is:"+square);
// }
// catch(MalformedURLException e){
// e.printStackTrace();
// }
// catch(RemoteException e){
// e.printStackTrace();
// }
// catch(NotBoundException e){
// e.printStackTrace();
// }
// catch(InterruptedException e){
// e.printStackTrace();
// }
// }
// }

// 6. Write a Servlet program to demonstrate the redirection by using two
// methods include and forward.

// index.html
// <html>
// <head>
// <title></title>
// </head>
// <body bgcolor=cyan text=red>
// <a href="one">Call Servlet One</a>
// </body>
// </html>

// MyServlet1.java
// import javax.servlet.*;
// import java.io.*;
// public class MyServlet1 extends GenericServlet{
// public void service(ServletRequest req,ServletResponse res)
// throws ServletException,IOException{
// res.setContentType("text/html");
// PrintWriter out=res.getWriter();
// out.print("First message from Servlet 1 <br>");
// RequestDispatcher rd=req.getRequestDispatcher("/two");
// rd.forward(req,res);
// out.print("Second message from Servlet 1 <br>");
// out.close();
// }
// }

// MyServlet2.java
// import javax.servlet.*;
// import java.io.*;
// public class MyServlet2 extends GenericServlet{
// public void service(ServletRequest req,ServletResponse res)
// throws ServletException,IOException{
// res.setContentType("text/html");
// PrintWriter out=res.getWriter();
// out.print("First message from Servlet 2 <br>");
// RequestDispatcher rd=req.getRequestDispatcher("/three");
// rd.include(req,res);
// out.print("Second message from Servlet 2 <br>");
// }
// }

// MyServlet3.java
// import javax.servlet.*;
// import java.io.*;
// public class MyServlet3 extends GenericServlet{
// public void service(ServletRequest req,ServletResponse res)
// throws ServletException,IOException{
// res.setContentType("text/html");
// PrintWriter out=res.getWriter();
// out.print("First message from Servlet 3 <br>");
// out.print("Second message from Servlet 3 <br>");
// }
// }

// web.xml
// <web-app>
// <servlet>
// <servlet-name>first</servlet-name>
// <servlet-class>MyServlet1</servlet-class>
// </servlet>
// <servlet-mapping>
// <servlet-name>first</servlet-name>
// <url-pattern>/one</url-pattern>
// </servlet-mapping>
// <servlet>
// <servlet-name>second</servlet-name>
// <servlet-class>MyServlet2</servlet-class>
// </servlet>
// <servlet-mapping>
// <servlet-name>second</servlet-name>
// <url-pattern>/two</url-pattern>
// </servlet-mapping>
// <servlet>
// <servlet-name>third</servlet-name>
// <servlet-class>MyServlet3</servlet-class>
// </servlet>
// <servlet-mapping>
// <servlet-name>third</servlet-name>
// <url-pattern>/three</url-pattern>
// </servlet-mapping>
// </web-app>



//7. Write a Servlet program to write two cookies "user" and "pass" in user's computer.


// index.html
// <html>
// 	<head><title>First Page</title></head>
// 	<body>
// 		<form action="servletone" method="post">
// 			Username<input type="text" name="user"><br>			
// 			Password<input type="password" name="pass"><br>			
// 			<input type="submit" value="login">
// 		</form>
// 	</body>
// </html>

// MyServlet1.java
// import javax.servlet.*;
// import java.io.*;
// import javax.servlet.http.*;
// public class MyServlet1 extends HttpServlet {
// 	public void service(HttpServletRequest req, HttpServletResponse res)
// 		throws ServletException,IOException{
// 		String s1=req.getParameter("user");
// 		String s2=req.getParameter("pass");
// 		Cookie c1=new Cookie("user",s1);
// 		c1.setMaxAge(1);
// 		Cookie c2=new Cookie("pass",s2);
// 		c2.setMaxAge(1);
// 		res.addCookie(c1);
// 		res.addCookie(c2);
// 		res.setContentType("text/html");
// 		PrintWriter out=res.getWriter();
// 		out.print("<html><body><form action='servlettwo' method='post'>");
// 		out.print("Email<input type='text' name='mail'><br>");
// 		out.print("<input type='submit' value='send'></form></body></html>");
// 		out.close();
// 	}
// }

// web.xml
// <web-app>
// 	<servlet>
// 		<servlet-name>first</servlet-name>
// 		<servlet-class>MyServlet1</servlet-class>
// 	</servlet>
// 	<servlet-mapping>
// 		<servlet-name>first</servlet-name>
// 		<url-pattern>/servletone</url-pattern>
// 	</servlet-mapping>
// </web-app>



// 8. Write a JSP program to demonstrate include directive.

// Ans8:
// header.html
// <center><h1>Matrix Computers</h1>
// <b>10/564 mansarovar</b></center>
// <hr width="50%">

// index.html
// <html>
// 	<head><title>First Page</title></head>
// 	<body>
// 		This web site is developed & maintained by:<br>		
// 		<%@ include file="header.jsp" %>
// 		<br>Some text

// 	</body>
// </html>





//9. Write a JSP program to read context parameters.

// Ans9:
// web.xml
// <web-app>
// 	<context-param>
// 		<param-name>color</param-name>
// 		<param-value>red</param-value>
// 	</context-param>
// 	<context-param>
// 		<param-name>font</param-name>
// 		<param-value>arial</param-value>
// 	</context-param>
// </web-app>

// index.jsp
// <html>
// 	<head><title>First Page</title></head>
// 	<body>
// <%
// 	String s1=application.getInitParameter("color");
// 	String s2=application.getInitParameter("font");
// 	out.print("Color is " + s1 + "<br>");
// 	out.print("Font is " + s2 + "<br>");
// %>

// 	</body>
// </html>




