<?php
 
include_once './DbConnect.php';
 
function createNewCategory() {
    if (true/*isset($_POST["Name"]) && $_POST["Name"] != "" && isset($_POST["Phone"]) && $_POST["Phone"] != "" && isset($_POST["Symptoms"]) && $_POST["Symptoms"] != "" */) {
        // response array for json
        $response = array();
        $category = $_POST["Name"];
         //$phone=$_POST["Phone"];
		 if($_POST["comDisease"] )
        $com="Broken"//$_POST["comDisease"];
		
		 if($_POST["herDisease"] )
		$her=$_POST["herDisease"];
		
		 if($_POST["fatDisease"] !="")
		$fat=$_POST["fatDisease"];
		

        $db = new DbConnect();
 
        // mysql query
		if($com !=""){
        $query = "UPDATE patient SET comDisease='$com' WHERE name='$category'";
		}
		if($her !=""){
        $query = "UPDATE patient SET herDisease='$her' WHERE name='$category'";
		}
		if($fat !=""){
        $query = "UPDATE patient SET fatDisease='$fat' WHERE name='$category'";
		}
        $result = mysql_query($query) or die(mysql_error());
        if ($result) {
            $response["error"] = false;
            $response["message"] = "Category updated successfully!";
        } else {
            $response["error"] = true;
            $response["message"] = "Failed to create category!";
        }
    } else {
        $response["error"] = true;
        $response["message"] = "Category name is missing!";
    }
     
    // echo json response
    echo json_encode($response);
}
 
createNewCategory();
?>