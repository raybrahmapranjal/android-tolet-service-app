<?php
	$host='localhost';
	$uname='root';
	$pwd="";
	$db="tolet";

	$con = mysqli_connect($host,$uname,$pwd,$db) or die("connection failed");
	
    $flag=array();
	$q="SELECT * FROM propertytype";
	//echo $q;
	$r1=mysqli_query($con,$q);
	//echo mysqli_num_rows($r1);
	while($row = mysqli_fetch_assoc($r1))
    {
        $flag[] = $row;
    }
	
	//echo count($flag);
	print(json_encode($flag));
	//mysql_close($con);
?>
