<?php
error_reporting(0);
$con=mysqli_connect("localhost","root","","tolet");
$PType_ID=$_POST["t1"];
$P_Type=$_POST["t2"];



$sql="insert into propertytype(PType_ID,P_Type)values('$PType_ID','$P_Type')";
$rs=mysqli_query($con,$sql);
//echo $sql;
if($rs==1)
{
		
	echo"<script type='text/javascript' language='javascript'>
alert('entry successfull !!');
 </script>";
 header("Refresh:0;newside.php");

	}
	else
	{
		echo"<script type='text/javascript' language='javascript'>
 alert('sorry! failed');
 </script>";
  header("Refresh:0;property.php");
		}
?>