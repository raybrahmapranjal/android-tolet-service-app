
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
 <h1 class="text-warning text-center" >  Owner Property Details </h1>
 <br>
 <table  id="tabledata" class=" table table-striped table-hover table-bordered">
 
 <tr class="bg-dark text-white text-center">
 
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
<th colspan="2" align="center">action</th>
</thead>

 </tr >
 </html>
<?php
$con=mysqli_connect("localhost","root","","tolet");
$sql="select *from owner_property";
$sql1=mysqli_query($con,$sql);
while ($row=mysqli_fetch_row($sql1))
{
   

	echo "<tr>";
	echo "<td>$row[0]</td>";
	echo "<td>$row[1]</td>";
    echo "<td>$row[2]</td>";
    echo "<td>$row[3]</td>";
    echo "<td>$row[4]</td>";
    echo "<td>$row[5]</td>";
    echo "<td>$row[6]</td>";
    echo "<td>$row[7]</td>";
	echo "<td>$row[8]</td>";
	
	
	echo "<td><button class='btn-danger btn'>  <a href='del.php?a=$row[0]' class='text-white'>Delete </a>  </button> </td>";
	echo "<td> <button class='btn-success btn'><a href='edit.php?a=$row[0]' class='text-white'>Update</a></td>";

 
	echo "</tr>";
}
?>
