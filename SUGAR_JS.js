// SCRIPT TIMING
var scriptStartTime = new Date();
 console.log("Global Script Started at : " + scriptStartTime.getHours() + "h : "+scriptStartTime.getMinutes() + "m : " + scriptStartTime.getSeconds() + "s");
 
var scriptEndTime = new Date();
scriptTimingMs = parseFloat(scriptEndTime.getTime() - scriptStartTime.getTime());
console.log("Global Script ENDED at : " + scriptEndTime.getHours() + "h : "+scriptEndTime.getMinutes() + "m : " + scriptEndTime.getSeconds() + "s");
console.log("Le script a mis " + scriptTimingMs/1000 + " secondes.");



// RADIO BOX VANILLA
function radio()
{
     var cases = document.getElementById("idForm").mesCases;
     var platFavori;
 
     // on recherche le bouton coche (s'il y en a un)
     for(var i=0; i<cases.length && !platFavori; i++)
          if(cases[i].checked)
               platFavori = cases[i].value;
 
     // s'il y en a un, on affiche la valeur correspondante
     if(platFavori)    
          alert("Votre plat favori est : " + platFavori);
}

// ================================
// |     AJAX  -  VANILLA JS      |
// ================================
Here is how you can submit your form via Ajax:

function submitFormAjax() {
    let xmlhttp= window.XMLHttpRequest ?
        new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");

    xmlhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200)
            alert(this.responseText); // Here is the response
    }

    let name = document.getElementById('name').innerHTML;
    let email = document.getElementById('email').innerHTML;

    xmlhttp.open("GET","your_url.php?name=" + name + "&email=" + email, true);
    xmlhttp.send();
}
This example is using GET, but you could also use POST:

xmlhttp.open("POST","your_url.php",true);
xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xmlhttp.send("name=" + name + "&email=" + email);
Note:

You must call submitFormAjax() after validateFormOnSubmit is done with no errors, here:

if (reason.length == 0) {
    // Show some loading image and submit form
    submitFormAjax();
} else {
    return false;
}