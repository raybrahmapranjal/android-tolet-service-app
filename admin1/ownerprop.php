<?php
error_reporting(0);
$con=mysqli_connect("localhost","root","","tolet");
$PropertyID=$_POST["t1"];
$PType_ID=$_POST["t2"];
$OwnerID=$_POST["t3"];
$Type=$_POST["drop"];
$Rent=$_POST["t4"];
$AC=$_POST["r1"];
$SwimmingPool=$_POST["r2"];
$Garage=$_POST["r3"];
$Inverter=$_POST["r4"];

$Localities=$_POST["t5"];
$pic=$_FILES["i1"]["name"];

move_uploaded_file($_FILES["i1"]["tmp_name"],"house/".$_FILES['i1']["name"]);
$sql="insert into owner_property(PropertyID,PType_ID,OwnerID,Type,Rent,AC,SwimmingPool,Garage,Inverter,Localities,pic,Status1)values('$PropertyID','$PType_ID','$OwnerID','$Type','$Rent','$AC','$SwimmingPool','$Garage','$Inverter','$Localities','$pic','0')";
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
  header("Refresh:0;dynamic.php");
		}
?>