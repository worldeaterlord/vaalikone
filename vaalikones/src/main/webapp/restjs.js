var t2 = "t2";
var t1 = "t1";
function Lue(t) {
	var tiedot = document.getElementById("tiedot");
	var urli;
	if (t === t1) {
		urli = "./rest/ehd/a";
	}
	if (t === t2) {
		urli = "./rest/ehd/b";
	}
	var ehdokas = new Object();

	ehdokas.ehdokasId = tiedot.EHDOKAS_ID.value;
	ehdokas.sukunimi = tiedot.SUKUNIMI.value;
	ehdokas.etunimi = tiedot.ETUNIMI.value;
	ehdokas.puolue = tiedot.PUOLUE.value;
	ehdokas.kotipaikkakunta = tiedot.KOTIPAIKKAKUNTA.value;
	ehdokas.ika = tiedot.IKA.value;
	ehdokas.miksiEduskuntaan = tiedot.MIKSI_EDUSKUNTAAN.value;
	ehdokas.mitaAsioitaHaluatEdistaa = tiedot.MITA_ASIOITA_HALUAT_EDISTAA.value;
	ehdokas.ammatti = tiedot.AMMATTI.value;

	var asd = JSON.stringify(ehdokas);

	if (t === t1) {
		document.getElementById("a").innerHTML = "Ehdokkaan tiedot muokattu!";
		setTimeout(function(){
			document.getElementById("a").innerHTML = "";
		}, 4000);
	} else {
		document.getElementById("b").innerHTML = "Uusi ehdokas lisätty!";
		setTimeout(function(){
			document.getElementById("b").innerHTML = "";
		}, 4000);
	}


	var xhttp = new XMLHttpRequest();
	xhttp.open("POST", urli, true);

	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send(asd);
	setTimeout(function(){
		show()
	}, 1000);
	

}
function show(){
	
	var url = "./rest/ehd/kaikki";
	var xhttp = new XMLHttpRequest();
	var setit = [];
	document.getElementById("kaikkiehdokkaatkentta").innerHTML = "";
	
	xhttp.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
			  jsn = JSON.parse(this.responseText);

			  for (var i = 0;i <= jsn.length-1; i++){
				  
				  setit[i] = JSON.parse(this.responseText)[i];
				  
				  document.getElementById("kaikkiehdokkaatkentta").innerHTML +=
					  "Ehdokas ID: " + setit[i].ehdokasId +  
					  "    Nimi: " + setit[i].sukunimi + " " + setit[i].etunimi + "<br>";
			  }
		    
		  }
		};
	xhttp.open("GET", url, true);
	xhttp.send();
	
}
function setUrl(){
	var d = document.getElementById("del").poistaid.value;
	var url = "./rest/ehd/poista/" + d;
	
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			  if (this.readyState == 4 && this.status == 200) {
			    document.getElementById("inner").innerHTML = this.responseText;
			  }
			};
		xhttp.open("GET", url, true);						
		xhttp.send();
		setTimeout(function(){
			show()
		}, 1000);

}
window.onload = _ =>
	show();