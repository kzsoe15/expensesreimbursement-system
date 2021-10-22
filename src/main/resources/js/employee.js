window.onload = function(){
	getData();
}

function getData(){
	fetch('http://localhost:9001/user/employee/reimb').then( 
		function(response) {
			return response.json();
		}, function() {
			console.log('Error');
		}
	).then(function(myJSON){
		console.log('its me here');
		console.log(myJSON);
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

//function used to create table cells
function createTableCell(value){
	let cell  = document.createElement("td");
	cell.appendChild(document.createTextNode(value));
	return cell;
}
