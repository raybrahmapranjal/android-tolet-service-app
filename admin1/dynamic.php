<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Untitled Document</title>
</head>

<body>

<div class="container register-form">
            <div class="form">
                <div class="note">
                
                    <p>Owner Property Entry</p>
                </div>
<div class="form-group">
<div class="row">
<div class="col-sm-5"></div>
<div class="col-sm-5" style="padding:20px"; border:#377 thin double;">
<div class="form-group">

<label>Owner information*</label>
<select name="select" id="select" class="form-control">
<?php
		$con=mysqli_connect("localhost", "root", "", "tolet");
		$q=mysqli_query($con, "select * from owner_details");
		while($rs=mysqli_fetch_row($q))
		{
			echo "<option value='$rs[0]'>$rs[1]</option>";
		}
		?>

</select>

</div>
<form id="form1" name="form1" method="post" action="ownerprop.php" enctype="multipart/form-data">
<div class="form-group">
<form id="form1" name="form1" method="post" action="ownerprop.php" enctype="multipart/form-data">
<label>PropertyID*</label>
<input type="t1" name="t1" id="t1" class="form-control" />

</div>

<div class="form-group">

<label>PType_ID*</label>
<input type="t2" name="t2" id="t2" class="form-control" />
</div>


<div class="form-group">

<label>OwnerID*</label>
<input type="t3" name="t3" id="t3" class="form-control" />
</div>


<div class="form-group">

<label>Type*</label>
<select name="drop" id="drop" class="form-control">
  <option>Single </option>
  <option>2BHK</option>
  <option>3BHK</option>
  <option>4BHK</option>
  <option>independent house</option>
  <option>5BHK</option>
 


</select>

</div>
<div class="">
<div class="form-group">
<label>Rent*</label>
 <div class="input-group">
   <div class="input-group-prepend">
        <span class="input-group-text">Rs.</span>
       <input type="t4" name="t4" id="t4" class="form-control">
  </div>
  </div>
  </div>


<div class="form-group">

<label>Facilities*</label>
<br/>

&nbsp&nbsp&nbsp&nbsp<h7>AC</h7>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<h7>Garage</h7>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<h7>Swimming Pool</h7>
&nbsp&nbsp&nbsp&nbsp&nbsp<h7>Inverter</h7>

<br/>
<label class="radio-inline">
 <input type="radio" name="r1" id="r1" value="Yes"> Yes  </label>


<label class="radio-inline">
  <input type="radio" name="r1" id="r2" value="No">No </label> 


&nbsp&nbsp&nbsp
<label class="radio-inline">
 <input type="radio" name="r2" id="r3" value="Yes"> Yes  </label>


<label class="radio-inline">
  <input type="radio" name="r2" id="r4" value="No">No </label> 

&nbsp&nbsp&nbsp
<label class="radio-inline">
 <input type="radio" name="r3" id="r5" value="Yes"> Yes  </label>


<label class="radio-inline">
  <input type="radio" name="r3" id="r6" value="No">No </label> 

&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<label class="radio-inline">
 <input type="radio" name="r4" id="r7" value="Yes"> Yes  </label>


<label class="radio-inline">
  <input type="radio" name="r4" id="r8" value="No">No </label> 


<div class="form-group"
<label>Localities*</label>
<input type="t5" name="t5" id="t5" class="form-control" />
</div>
<div class="form-group">
    <label for="exampleFormControlFile1">Images*</label>
    <input type="file" class="form-control-file" name="i1" id="i1">
  </div>
<div class="form-group">
<input type="submit" name="b1" value="SAVE" class="btn btn-success"/>
<input type="button" name="b1" value="CANCEL" class="btn btn-danger"/>
</div>
</div>
</form>
</body>
</html>


<style>
.note
{
    text-align: center;
    height: 50px;
    background: #ff8c00;
    color: #FFFFFF;
    font-weight: bold;
    line-height: 50px;
	font-size:24px;
}
body{
background:#AFEEEE;
}
</style>