<?php
$con=mysqli_connect("localhost","root","","tolet");
$Id=$_GET["a"];
$sql=mysqli_query($con,"delete from owner_property where PropertyId='$Id'");
if($sql=1)
{
	echo"<script type='text/javascript' language='javascript'>
	alert(successfully deleted);
	</script>";
	header("refresh:0;crud.php");
	}
	else
	{
		echo"error";
		}

?>