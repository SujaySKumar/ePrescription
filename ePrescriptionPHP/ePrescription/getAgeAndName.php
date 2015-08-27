<?php
include_once './DbConnect.php';

function getCategories(){
    
    $db = new DbConnect();
    // array for json response
    $response = array();
    $response["patient"] = array();
    $result = mysql_query("SELECT * FROM patient ");
    
    while($row = mysql_fetch_array($result)){
        // temporary array to create single category
        $tmp = array();
        //$tmp["Age"] = $row["Age"];
        //$tmp["Name"] = $row["Name"];
		$tmp["prescription"]=$row["prescription"];
        
        // push category to final json array
        array_push($response["patient"], $tmp);
    }
    
    // keeping response header to json
    header('Content-Type: application/json');
    //$response=utf8_encode($response);
    // echoing json result
    echo json_encode($response,JSON_PRETTY_PRINT);
	//echo $result;
}

getCategories();
?>