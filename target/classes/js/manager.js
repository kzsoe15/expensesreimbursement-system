
window.onload = function(){
	getData();
}



function getData(){
	fetch('http://localhost:9001/user/manager/reimb').then( 
		function(response) {
			return response.json();
		}, function() {
			console.log('Error');
		}
	).then(function(myJSON){
		ourDOMManipulation(myJSON);
	})
}

function ourDOMManipulation(jsonResponse){
	var mydata = Object.values(jsonResponse);
	console.log(mydata);
	let table = document.getElementById("myReimbTableData");
	for(let i=0; i<mydata.length; i++){
		let tr  = document.createElement("tr");
		
		tr.appendChild(createTableCell(mydata[i].reimbId));
		tr.appendChild(createTableCell(mydata[i].reimAmount));
		tr.appendChild(createTableCell(mydata[i].submitDate));
		tr.appendChild(createTableCell(mydata[i].resolvedDate));

		if(mydata[i].reimDescription == null) {
			tr.appendChild(createTableCell(""));
		} else {
			tr.appendChild(createTableCell(mydata[i].reimDescription));
		}
		
		tr.appendChild(createTableCell(mydata[i].authorName));

		if(mydata[i].resolverName == null) {
			tr.appendChild(createTableCell(""));
		} else {
			tr.appendChild(createTableCell(mydata[i].resolverName));	
		}		
		tr.appendChild(createTableCell(mydata[i].status));
		tr.appendChild(createTableCell(mydata[i].type));
		
		table.appendChild(tr);
	}
	
}


function createTableCell(value){
	let cell  = document.createElement("td"); 
	cell.appendChild(document.createTextNode(value));
	return cell;
}


//taken form w3school
function myFunction() {
  var input, filter, table, tr, td, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myReimbTable");
  tr = table.getElementsByTagName("tr");


  for (let i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[7];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
