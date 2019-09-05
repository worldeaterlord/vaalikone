var f1 = "f1";
var f2 = "f2";
var t2 = "t2";
var t1 = "t1";

function lueKys(f){
	
	var tiedot = document.getElementById("kyssarit");
	var urli;
	if (f === f1) {
		urli = "./rest/kyss/muokKys";
	}
	if (f === f2) {
		urli = "./rest/kyss/lisKys";
	}
	var kysymys = new Object();
	
	kysymys.kysymysId = kyssarit.KYSYMYS_ID.value;
	kysymys.kysymys = kyssarit.KYSYMYS.value;
	
	var roflstomp = JSON.stringify(kysymys);
	
	if (f === f1) {
		document.getElementById("c").innerHTML = "Kysymys muokattu!";
		setTimeout(function(){
			document.getElementById("c").innerHTML = "";
		}, 4000);
	} else {
		document.getElementById("d").innerHTML = "Uusi kysymys lisätty!";
		setTimeout(function(){
			document.getElementById("d").innerHTML = "";
		}, 4000);
	}
	
	var xhttp = new XMLHttpRequest();
	xhttp.open("POST", urli, true);

	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send(roflstomp);
	
	setTimeout(function(){
		kys()
	}, 1000);
}

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
	}, 500);
	

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
		}, 500);

}

function poistaKys(){
	var x = document.getElementById("delKys").poistaKysymys.value;
	var url = "./rest/kyss/poistaKys/" + x;
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
		    document.getElementById("innerKys").innerHTML = this.responseText;
		  }
		};
	xhttp.open("GET", url, true);
	xhttp.send();
	setTimeout(function(){
		document.getElementById("innerKys").innerHTML = "";
	}, 4000);
	setTimeout(function(){
		kys()
	}, 1000);
}

function kys(){
	
	var url = "./rest/kyss/kys";
	var xhttp = new XMLHttpRequest();
	var arr = [];
	document.getElementById("kaikkikysymyksetkentta").innerHTML = "";
	
	xhttp.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
			  jeison = JSON.parse(this.responseText);

			  for (var i = 0;i <= jeison.length-1; i++){
				  
				  arr[i] = JSON.parse(this.responseText)[i];
				  
				  document.getElementById("kaikkikysymyksetkentta").innerHTML +=
					  "Kysymys ID: " + arr[i].kysymysId +  
					  "   Kysymys: " + arr[i].kysymys + "<br>";
			  }
		    
		  }
		};
	xhttp.open("GET", url, true);
	xhttp.send();
}
window.onload = _ =>
	show();
	kys();