
	function swapStyleSheet(sheet){
	  	document.getElementById('theme').setAttribute('href', sheet);

	  	localStorage.setItem("sheet", sheet);
	  	if (sheet==="jalkapallostyle.css"){
	  		document.getElementById("myCheckbox").checked = true;
	  	}
	  	else{
		    document.getElementById("myCheckbox").checked =false;

	  	}

	}


	function toggleCheck() {
		  if(document.getElementById("myCheckbox").checked === true){
		    swapStyleSheet("jalkapallostyle.css");
		    document.getElementById("myCheckbox").checked = true;
		  } else {
		    swapStyleSheet("style.css");
		    document.getElementById("myCheckbox").checked =false;
		  }
		}

	window.onload = _ =>

	 swapStyleSheet(localStorage.getItem("sheet") || "jalkapallostyle.css");
