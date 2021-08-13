<?php

  header("Access-Control-Allow-Origin: *");
 
  $conn = new mysqli("localhost", "root","", "bd80007");
  if($conn->connect_error) {
  echo "Unable to connect, please try again";
  die();
  }
  $sql = "SELECT * FROM doctors";
  $stmt = $conn->prepare($sql);

  $stmt->execute();
  $result = $stmt->get_result(); 
  if ($result->num_rows > 0) {
  	$doctors = array();
    $i = 0;
    while ($row = $result->fetch_assoc()) {
    	$doctors[$i]['doc_no'] = addslashes(htmlentities($row['doc_no']));
    	$doctors[$i]['d_name'] = addslashes(htmlentities($row['d_name']));
    	$doctors[$i]['qualification'] = addslashes(htmlentities($row['qualification']));
    	$doctors[$i]['ph_no'] = addslashes(htmlentities($row['ph_no']));
    	$doctors[$i]['dept_no'] = addslashes(htmlentities($row['doc_no']));
    	$i++;
    }
    echo json_encode(array ('result' => 'OK', 'data' => $doctors));

  } else {
  echo "Unable to process you request, please try again";
  die();
  }


  $stmt->close();
  $conn->close();
?>
