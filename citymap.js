// +======================={PROJECT - PRESENTATION}======================+
// |                                                                     |
// |Project Name    : gestionVillepdo - CMDB/ITIL                        |
// |Categorie       : Dynamic App Website                                |
// |FrameWorks      : Bootstrap 4 - MDB                                  |
// |Author          : OrbitTurner                                        |
// |Official Name   : Mohamed GUEYE                                      |
// |Version         : v.0.1.1                                            |
// |Created         : 18-DECEMBER-2019                                   |
// |Last update     : 02-JAN-2020                                        |
// |Partie          : CITYMAP JS                                         | 
// |LANGAGE UTILISE : ANGLAIS - FRANCAIS                                 |
// +=====================================================================+
// Pour tout aide concernant le code source contactez-moi!!
var ProjectPath = "/lpgl_projects/gestionVillepdo/src/";
var databaseMarkers;
var map;
var infowindow;
// Initialize and add the map
function initMap() {
    // The location of Uluru
    var Dakar = {lat: 14.716677, lng: -17.467686};
        // The map, centered at Uluru
       map = new google.maps.Map(
          document.getElementById('cityMap'), {zoom: 4, center: Dakar});
    //===== GET LOCATION BY AJAX =====
    $.ajax({
      url: ProjectPath+'controller/villeController.php',
      type: 'GET',
      data: { cityList: 1 },
      dataType: 'json',
      success: function(data) {
        databaseMarkers = data;
        // console.log(databaseMarkers); DEBUGGING
        // Parcours du JSON
        for (let i = 0; i < databaseMarkers.length; i++) {
          // Current object
          var city = databaseMarkers[i];
          console.log(databaseMarkers.cityname);
          // Adding a new marker for the object (The Current City)
          var marker = new google.maps.Marker({
            position: new google.maps.LatLng(city.latitude,city.longitude),
            map: map,
            title: city.cityname // this works, giving the marker a title with the correct title
          });
          
          // Adding a new info window for the object
          var clicker = addClicker(marker, city.cityname);
          // console.log(marker);
        } //END LOOP
      }// END SUCCESS
    }); // END AJAX
  } // END INIT

    

 // Adding a new click event listener for the object
  function addClicker(marker, content) {
    console.log('clicked');
    google.maps.event.addListener(marker, 'click', function() {
      
      if (infowindow) {infowindow.close();}
      infowindow = new google.maps.InfoWindow({content: content});
      infowindow.open(map, marker);
      
    });
  }