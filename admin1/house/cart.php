<?php
	$host='localhost';
	$uname='root';
	$pwd='';
	$db="tolet";
	$un=$_POST["uname"];
	$id=$_POST["id"];
	$date=$_POST["Date1"];
	$price=$_POST["id"];

	//$num=$_POST["num"];
	
	$con = mysqli_connect($host,$uname,$pwd,$db) or die("connection failed");
	$q="SELECT * FROM owner_property where PropertyID='$id'";
	$r1=mysqli_query($con,$q);
	while($row = mysqli_fetch_row($r1))
	{
		$price=$row[4];
		
		$sql2="insert into rent(username,PropertyID,price,Odate)values('$un','$id','$price','$date')";
		$q=mysqli_query($con,$sql2);
	}
?>