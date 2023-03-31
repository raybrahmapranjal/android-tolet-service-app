<?php
	$host='localhost';
	$uname='root';
	$pwd='';
	$db="tolet";
	$id=$_POST["id"];

	$con = mysqli_connect($host,$uname,$pwd,$db) or die("connection failed");
	
    $flag=array();
	$q="SELECT * FROM owner_property where PType_ID='$id' and Status1='0'";
	$r1=mysqli_query($con,$q);
	//echo $q;
	while($row = mysqli_fetch_assoc($r1))
   	 {
        $flag[] = $row;
   	 }
	
	print(json_encode($flag));
	
?>