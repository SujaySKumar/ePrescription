<?php
 
include_once './DbConnect.php';
 
function createNewCategory() {
    if (true/*isset($_POST["Name"]) && $_POST["Name"] != "" && isset($_POST["Phone"]) && $_POST["Phone"] != "" && isset($_POST["Symptoms"]) && $_POST["Symptoms"] != "" */) {
        // response array for json
        $response = array();
        $category = $_POST["Name"];
         //$phone=$_POST["Phone"];
        $pres=$_POST["prescription"];
        $db = new DbConnect();
 
        // mysql query
        $query = "UPDATE patient SET prescription='$pres' WHERE name='$category'";
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