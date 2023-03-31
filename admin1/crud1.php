<!DOCTYPE html>
<html>
<head>
 <title></title>

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

 <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
   <script type="text/javascript" charset="utf8" src="https://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

</head>
<body>

 <div class="container">
 <div class="col-lg-12">
 <br><br>
 <h1 class="text-warning text-center" > Owner property details </h1>
 <br>
 <form id="form1" name="form1" method="GET" action="crud1.php">
  <form class="form-inline">   
    <input class="form-control mr-sm-2" name="t1"  id="t1" type="search" placeholder="PropertyID" value="<?php echo @$_GET['t1'];?>" aria-label="Search">
    <button class="btn btn-success my-2 my-sm-0" name="btn" id="btn" type="submit">Search</button>
  </form>

 <table  id="tabledata" class=" table table-striped table-hover table-bordered">
 
 <tr class="bg-dark text-white text-center">
  <form>
  <br>
<thead>
<th>PropertyID</th>
<th>OwnerID</th>
<th>Type</th>
<th>Rent</th>
<th>AC</th>
<th>SwimmingPool</th>
<th>Garage</th>
<th>Inverter</th>
<th>Localities</th>

</thead>

 </tr >
 </html>
  <?php

$con=mysqli_connect("localhost","root","","tolet");
if (isset($_GET['btn'])){
$a=$_GET["t1"];

$sql="select * from owner_property where PropertyID=$a";

}else

	$sql="select *from owner_property";
$rs=mysqli_query($con,$sql);
error_reporting(0);
$nor=mysqli_num_rows($rs);
error_reporting(0);
if($nor==0)
{
	echo "<h4 class='text-center text-danger'>oops! no data found</h4>";
	}

?>
<?php
while ($rs1=mysqli_fetch_row($rs))
{
	echo "<tr>";
	echo "<td>$rs1[0] </td>";
	echo "<td>$rs1[1]</td>";
	echo "<td>$rs1[2]</td>";
	echo "<td>$rs1[3]</td>";
	echo "<td>$rs1[4]</td>";
	echo "<td>$rs1[5]</td>";
	echo "<td>$rs1[6]</td>";
	echo "<td>$rs1[7]</td>";
	echo "<td>$rs1[8]</td>";
	echo "</tr>";
}


?>
