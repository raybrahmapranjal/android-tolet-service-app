<?php
error_reporting(0);
$con=mysqli_connect("localhost","root","","tolet");
$username=$_POST["t1"];
$password=$_POST["t2"];
$sql="select *from admin_log where username ='$username' and password='$password'";
$rs=mysqli_query($con,$sql);
$c=mysqli_num_rows($rs);
if($c==1)
{
	
	$rs1=mysqli_fetch_row($rs);
	$password=$rs1[0];
	if($password==$password)
	{
		session_start();
		$_SESSION["username"]=$username;
		header("Location:newside.php");
	}
	else
	{
		echo "pwd not match";
	}
}
else
{
	
	 echo"<script type='text/javascript' language='javascript'>
 alert('incorrect username or password');
 </script>";
  header("Refresh:0;admin.html");
}
?>