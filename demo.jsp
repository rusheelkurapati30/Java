<%@page import="java.sql.*,java.util.*"%>
<%
String Item_ID=request.getParameter("Item_ID");
out.println(Item_ID);
String Item_Description=request.getParameter("Item_Description");
out.println(Item_Description);
String Unit_Price=request.getParameter("Unit_Price");
out.println(Unit_Price);
int Stock_Quantity=Integer.parseInt(request.getParameter("Stock_Quantity"));
out.println(Stock_Quantity);
String Supplier_ID=request.getParameter("Supplier_ID");
out.println(Supplier_ID);



String Status="Active";
String Item_ID="F";
String Item_Description="B";
float Unit_Price=1;
int Stock_Quantity=3;
String Supplier_ID="s102";


out.println("1");
        try{
        out.println("2");
         Class.forName("com.mysql.jdbc.Driver");
out.println("3");

           Connection con = DriverManager.getConnection("jdbc:mysql://165.22.14.77/dbRusheel", "rusheel", "rusheel");
out.println("4");

           Statement st=con.createStatement();
out.println("5");
String sql="insert into Item(Status,Item_ID,Item_Description,Unit_Price,Stock_Quantity,Supplier_ID) values('"+Status+"','"+Item_ID+"','"+Item_Description+"','"+Unit_Price+"','"+Stock_Quantity+"', '"+Supplier_ID+"')";
out.println(sql);
int i=st.executeUpdate(sql);
out.println("6");

        out.println("Data is successfully inserted!");
        }
        catch(Exception e){
        System.out.print(e);
        e.printStackTrace();
        }
        %>




<!-- function showRecords()
{
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
if(this.readyState == 4 && this.status == 200)
{
document.getElementById("details").innerHTML = this.responseText;
}
};
xhttp.open("GET", "showRecords.jsp", true);
xhttp.send();
}
function save()
{
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
if(this.readyState == 4 && this.status == 200)
{
document.getElementById("details").innerHTML = this.responseText;
};
xhttp.open("GET", "rusheelSave.jsp?Item_ID="+document.getElementById("Item_ID").value+"&Item_Description="+document.getElementById("Item_Description").value+"&Unit_Price="+document.getElem$
xhttp.send();
} -->


