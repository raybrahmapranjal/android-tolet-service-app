<?php
error_reporting(0);
$con=mysqli_connect("localhost","root","","tolet");
$OwnerID=$_POST["t1"];
$HouseOwner=$_POST["t2"];
$HouseAddress=$_POST["t3"];
$Phone=$_POST["t4"];

$sql="insert into owner_details(OwnerID,HouseOwner,HouseAddress,Phone)values('$OwnerID','$HouseOwner','$HouseAddress','$Phone')";
$rs=mysqli_query($con,$sql);
echo $sql;
if($rs==1)
{
	
	echo"<script type='text/javascript' language='javascript'>
alert('Registration Successfull !!');
 </script>";
 header("Refresh:0;newside.php");

	}
	else
	{
	echo"<script type='text/javascript' language='javascript'>
 alert('sorry! Registration failed !');
 </script>";
  header("Refresh:0;landreg.html");
  
		}
?>