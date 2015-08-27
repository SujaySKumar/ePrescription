<?php
include_once './DbConnect.php';

function getCategories(){
    $db = new DbConnect();
    // array for json response
    $response = array();
	if(isset($_POST["Name"]))
	$category = $_POST["Name"];
    $response["patient"] = array();
	
    
    // Mysql select query
    $result = mysql_query("SELECT * FROM patient WHERE Name='$category'");
    
    while($row = mysql_fetch_array($result)){
        // temporary array to create single category
        $tmp = array();
        $tmp["prescription"] = $row["prescription"];
        $tmp["Name"] = $row["Name"];
        
        // push category to final json array
        array_push($response["patient"], $tmp);
    }
    
    // keeping response header to json
    header('Content-Type: application/json');
    //$response=utf8_encode($response);
    // echoing json result
    echo json_encode($response,JSON_PRETTY_PRINT);
}

getCategories();
?>